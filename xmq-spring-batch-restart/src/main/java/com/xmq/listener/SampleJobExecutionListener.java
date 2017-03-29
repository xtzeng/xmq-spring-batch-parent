package com.xmq.listener;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class SampleJobExecutionListener implements JobExecutionListener {

	public void beforeJob(JobExecution jobExecution) {
		System.out.println("job start.........");

	}

	public void afterJob(JobExecution jobExecution) {
		if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
			// job success

			System.out.println("job success.........");
		} else if (jobExecution.getStatus() == BatchStatus.FAILED) {
			// job failure
			System.out.println("job failure.........");
		}
	}

}
