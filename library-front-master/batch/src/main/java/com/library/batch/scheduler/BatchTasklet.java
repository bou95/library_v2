package com.library.batch.scheduler;

import java.util.*;


import com.library.service.BorrowsService;
import com.library.service.ReservationService;
import entities.Borrows;
import entities.Reservation;
import entities.Users;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.library.batch.mail.ApacheMail;

@Component
public class BatchTasklet implements Tasklet {

    @Value("${batch.message}")
    private String message;

    @Autowired
    BorrowsService borrowsService;

    @Autowired
    ReservationService reservationService;

    @Autowired
    private ApacheMail mail;

    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        System.out.println(message);

        List<Borrows> outdated = (borrowsService.outdatedBorrows());

        if(outdated.size() > 0 ) {
            for (Borrows borrows : outdated) {
                Users users = borrows.getBorrower();
                mail.send(users);
            }
        }else
            System.out.println("Aucun livre ");

        List<Borrows> borrows = (borrowsService.getAllBorrow());
        for(Borrows borrow: borrows){
            if(((borrow.getTerm().toGregorianCalendar().getTime().getTime() - new Date().getTime()) <= 366419394)
                    && borrow.getBorrower().isReminder()){
                mail.reminder(borrow);
            }
            System.out.println(borrow.getTerm().toGregorianCalendar().getTime().getTime() - new Date().getTime() );
        }

        List<Reservation> reservations =(reservationService.getAllReservations());
        for(Reservation reservation: reservations){
            if(reservation.getBook().getAvailable() > 0){
                if(reservation.getIndex() == 1){
                    mail.reservations(reservation.getBorrower(), reservation.getBook());
                }
            }
        }

        return RepeatStatus.FINISHED;
    }


}
