package com.library.batch;

import com.library.service.BorrowsService;
import entities.Borrows;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

@Component
public class OutDatedGetter implements Tasklet, StepExecutionListener {

    @Autowired
    BorrowsService borrowsService;

    private List<Borrows> borrowsList;
    private List<Borrows> outdated;

    @Override
    public void beforeStep(StepExecution stepExecution) {
        outdated = new ArrayList<>();
        borrowsList = borrowsService.getAllBorrow();
    }

    @Override
    public RepeatStatus execute(StepContribution stepContribution,
                                ChunkContext chunkContext) throws Exception {
        for(int i = 0; i < borrowsList.size(); i++){
            Borrows borrows = borrowsList.get(i);
            GregorianCalendar c = new GregorianCalendar();
            XMLGregorianCalendar today = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
            int result = today.compare(borrows.getTerm());
            if(result > 0){
                outdated.add(borrows);
            }
        }
        return RepeatStatus.FINISHED;
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        stepExecution
                .getJobExecution()
                .getExecutionContext()
                .put("outDated", this.outdated);
        return ExitStatus.COMPLETED;
    }
}
