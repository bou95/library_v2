package com.library.batch;

import com.library.service.BorrowsService;
import com.library.service.EmailService;
import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import entities.Borrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


import static java.time.temporal.ChronoUnit.DAYS;

public class BatchTasklet implements Tasklet {

    private static final Logger LOGGER = LogManager.getLogger(BatchTasklet.class);

    @Autowired
    BorrowsService borrowsService;

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        List<Borrows> borrowsList = expired(borrowsService.getAllBorrow());
        EmailService service = new EmailService();

        LocalDate currentDate = LocalDate.now();
        LocalDate term;
        for (Borrows borrows : borrowsList) {
            Borrows ob = borrowsService.getById(borrows.getBorrower().getUser_id());
            String to = ob.getBorrower().getEmail();

            term = LocalDate.from(ob.getTerm().toGregorianCalendar().toZonedDateTime().toLocalDate());

            String subject = "Date de prêt dépassé ";

            String text = "La date de retour du livre  \""
                    + ob.getBook().getTitle()
                    + "\" que vous avez emprunté est dépassé depuis le"
                    + term.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"))
                    + " de " +DAYS.between(term, currentDate) + " jours";

            service.sendSimpleMessage(to, subject, text);
            LOGGER.info("Message envoyé au " + ob.getBorrower().getEmail());
        }
        return RepeatStatus.FINISHED;
    }

    private List<Borrows> expired(List<Borrows> borrowsList) throws DatatypeConfigurationException {
        List<Borrows> borrows = new ArrayList<>();
        for (int i = 0; i < borrowsList.size(); i++) {
            GregorianCalendar c = new GregorianCalendar();
            c.setTime(new Date());
            XMLGregorianCalendar rn = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
            Borrows ob = new Borrows();
            if (borrowsList.get(i).getTerm().compare(rn) > 0){
                ob.setBorrow_Id(borrowsList.get(i).getBorrow_Id());
            }
            borrows.add(ob);

        }
        return borrows;
    }
}
