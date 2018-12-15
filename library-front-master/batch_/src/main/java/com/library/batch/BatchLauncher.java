package com.library.batch;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;

import javax.annotation.Resource;

public class BatchLauncher {

    private static final Logger LOGGER = LogManager.getLogger(BatchLauncher.class);

    @Resource
    private Job scheduledJob;

    @Resource
    private JobLauncher jobLauncher;

    public void run() {
        JobParameters parameters = new JobParametersBuilder()
                .addLong("currentTime", System.currentTimeMillis())
                .toJobParameters();

        try {
            jobLauncher.run(scheduledJob, parameters);
        } catch (JobExecutionAlreadyRunningException |
                JobInstanceAlreadyCompleteException |
                JobRestartException |
                JobParametersInvalidException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
