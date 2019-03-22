package com.library.batch.scheduler;

import java.util.*;


import com.library.service.BorrowsService;
import entities.Borrows;
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
    private ApacheMail mail;

    private List<Borrows> outdated;

    private List<Users> userList;


    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        System.out.println(message);

        outdated = borrowsService.outdatedBorrows();

        for(int i=0; i < outdated.size(); i++){
            Users user = outdated.get(i).getBorrower();
            mail.send(user);
        }

        return RepeatStatus.FINISHED;
    }


}
