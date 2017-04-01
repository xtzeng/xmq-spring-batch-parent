package com.xmq;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/logging-skipped-items-job.xml")
public class LoggingSkippedItemsTest {
	
	@Autowired
	private Job skipJob;
	
	@Autowired
	private JobLauncher jobLauncher;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Before public void setUp() {
		jdbcTemplate.update("delete from contact");
	}
	
	@Test public void loggingSkippedItems() throws Exception {
		// TODO 05 take a look at the contacts.txt file in src/main/resources
		// count the number of badly formatted lines
		// TODO 06 launch the test and check the console outputs the warnings
		JobExecution execution = jobLauncher.run(skipJob, new JobParameters());
		assertEquals(ExitStatus.COMPLETED, execution.getExitStatus());
		assertEquals(6,jdbcTemplate.queryForObject("select count(1) from contact",Integer.class).intValue());
	}
	
}
