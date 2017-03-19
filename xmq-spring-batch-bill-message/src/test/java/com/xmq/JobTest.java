package com.xmq;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.task.SyncTaskExecutor;

public class JobTest {

	
	public static final String RUN_DAY_KEY = "run.day";
	
	@Test
	public void testMessageJob(){
		ClassPathXmlApplicationContext c = new ClassPathXmlApplicationContext("message_job.xml");
		SimpleJobLauncher launcher = new SimpleJobLauncher();
		launcher.setJobRepository((JobRepository) c.getBean("jobRepository"));
		launcher.setTaskExecutor(new SyncTaskExecutor());
		try {
			Map<String,JobParameter> parameters = new HashMap<String,JobParameter>();
			parameters.put(RUN_DAY_KEY,new JobParameter("2017-03-19"));
			JobExecution je = launcher.run((Job) c.getBean("messageJob"),new JobParameters(parameters));
			System.out.println(je);
			System.out.println(je.getJobInstance());
			System.out.println(je.getStepExecutions());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testBillJob(){
		ClassPathXmlApplicationContext c = new ClassPathXmlApplicationContext(
				"billing_job.xml");
		
		SimpleJobLauncher launcher = new SimpleJobLauncher();
			launcher.setJobRepository((JobRepository) c.getBean("jobRepository"));
			launcher.setTaskExecutor(new SyncTaskExecutor());
			
		try {
			Map<String, JobParameter> parameters = new HashMap<String, JobParameter>();
			parameters.put(RUN_DAY_KEY, new JobParameter("2017-03-19"));
			JobExecution je = launcher.run((Job) c.getBean("billingJob"),
					new JobParameters(parameters));
			System.out.println(je);
			System.out.println(je.getJobInstance());
			System.out.println(je.getStepExecutions());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
