package com.library;

import com.library.batch.TaskletsConfig;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class App 
{
    public static void main( String[] args ) {
        ApplicationContext context = new AnnotationConfigApplicationContext(TaskletsConfig.class);
        JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");

        try{
            Job job = (Job) context.getBean("taskletsJob");
            JobExecution execution = jobLauncher.run(job, new JobParameters());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
