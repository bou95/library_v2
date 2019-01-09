package com.library.batch;

import com.library.batch.MailProcessor;
import com.library.batch.OutDatedGetter;
import com.library.client.BorrowsClient;
import com.library.service.BorrowsService;
import com.library.service.impl.BorrowsServiceImpl;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableBatchProcessing
public class TaskletsConfig {

    private OutDatedGetter outDatedGetter = new OutDatedGetter();
    private MailProcessor mailProcessorSender = new MailProcessor();

    @Autowired
    private JobBuilderFactory jobs;

    @Autowired
    private StepBuilderFactory steps;

    @Bean
    protected Step outDated() {
        return steps
                .get("outDated")
                .tasklet(outDatedGetter)
                .build();
    }

    @Bean
    protected Step mailProcessor() {
        return steps
                .get("mailProcessor")
                .tasklet(mailProcessorSender)
                .build();
    }

    @Bean
    public Job job() {
        return jobs
                .get("taskletsJob")
                .start(outDated())
                .next(mailProcessor())
                .build();
    }


    @Bean
    public JobLauncherTestUtils jobLauncherTestUtils() {
        return new JobLauncherTestUtils();
    }

    @Bean
    public JobRepository jobRepository() throws Exception {
        MapJobRepositoryFactoryBean factory
                = new MapJobRepositoryFactoryBean();
        factory.setTransactionManager(transactionManager());
        return (JobRepository) factory.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new ResourcelessTransactionManager();
    }

    @Bean
    public JobLauncher jobLauncher() throws Exception {
        SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
        jobLauncher.setJobRepository(jobRepository());
        return jobLauncher;
    }

}
