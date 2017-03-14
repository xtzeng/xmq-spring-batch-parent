/**
 * 
 */
package com.xmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class HelloWorldTasklet implements Tasklet {

	private static Logger logger = LoggerFactory.getLogger(HelloWorldTasklet.class);
	
	@Override
	public RepeatStatus execute(StepContribution contribution,
			ChunkContext chunkContext) throws Exception {
		logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>Hello World");
		return RepeatStatus.FINISHED;
		// TODO 01 print "Hello World!" on the console
		// TODO 02 return RepeatStatus.FINISHED
		// Spring Batch will execute the method once then
//		return null;
	}
	
}
