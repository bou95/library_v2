package com.library.batch;

import com.library.email.ApplicationMailer;
import com.opensymphony.xwork2.inject.Inject;
import entities.Books;
import entities.Borrows;
import entities.Users;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.List;

@Component
public class MailProcessor implements Tasklet, StepExecutionListener {

    private List<Borrows> outdated;
    @Inject
    ApplicationMailer applicationMailer;

    @Override
    public void beforeStep(StepExecution stepExecution) {
        ExecutionContext executionContext = stepExecution
                .getJobExecution()
                .getExecutionContext();
        this.outdated =(List<Borrows>) executionContext.get("outDated");

    }

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        Users user = new Users();
        Books book = new Books();
        if (outdated.size() > 0){
            for(int i = 0; i < outdated.size(); i++ ){
                user.setFirstName(outdated.get(i).getBorrower().getFirstName());
                user.setLastName(outdated.get(i).getBorrower().getLastName());
                user.setEmail(outdated.get(i).getBorrower().getEmail());
                book.setTitle(outdated.get(i).getBook().getTitle());
                XMLGregorianCalendar term = outdated.get(i).getTerm();
                applicationMailer.sendMail(user.getEmail(), "Prêt expiré", "Bonjour "+user.getLastName()+ ",/n"+ "le livre "+book.getTitle()+ " emprunté le "+term+" est arrivé a expritation");
            }
        }
        return RepeatStatus.FINISHED;
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return ExitStatus.COMPLETED;
    }
}
