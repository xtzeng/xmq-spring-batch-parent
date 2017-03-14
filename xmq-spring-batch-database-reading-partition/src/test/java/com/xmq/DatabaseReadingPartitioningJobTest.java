package com.xmq;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.mutable.MutableLong;
import org.h2.tools.Server;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/database-reading-partitioning-job.xml")
// TODO 06 remove the Ignore annotation on the test 
//@Ignore
public class DatabaseReadingPartitioningJobTest {

	@Autowired
	private Job dataReadingPartitioningJob;
	
	@Autowired
	private JobLauncher jobLauncher;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private Map<String, Integer> productsPerCategories = new LinkedHashMap<String, Integer>() {{
		put("books",15);
		put("dvds",5);
		put("clothes",8);
		put("computers",12);
	}};
	
	
	@Before public void setUp() {
		initDatabase();
	}
	
	@Test public void fileReadingPartitioning() throws Exception {
		// TODO 07 launch the test!
		// TODO 08 after the test execution, check the ./target directory
		// to see the generated files
		
		long start = System.currentTimeMillis();
		JobExecution execution = jobLauncher.run(dataReadingPartitioningJob, 
				new JobParametersBuilder().addLong("time", start).toJobParameters()
		);
		Assert.assertEquals(ExitStatus.COMPLETED, execution.getExitStatus());
		for(String category : productsPerCategories.keySet()) {
			Assert.assertEquals(
				productsPerCategories.get(category).intValue(),
				FileUtils.readLines(new File("./target/","products_"+category+".txt")).size()
			);
		}
	}	
	
	private void initDatabase() {
		jdbcTemplate.update("delete from product");
		for(final String category : productsPerCategories.keySet()) {
			final int productsToInsert = productsPerCategories.get(category); 
			jdbcTemplate.batchUpdate(
				"insert into product (name,category) values (?,?)",
				new BatchPreparedStatementSetter() {
					@Override
					public void setValues(PreparedStatement ps, int i) throws SQLException {
						ps.setString(1,category+i);
						ps.setString(2, category);
					}
					
					@Override
					public int getBatchSize() {
						return productsToInsert; 
					}
				}
			);
		}
	}
}
