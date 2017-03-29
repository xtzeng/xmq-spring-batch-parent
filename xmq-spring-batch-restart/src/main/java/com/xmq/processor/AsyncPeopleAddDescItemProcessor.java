package com.xmq.processor;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.core.task.SyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

import com.xmq.model.People;
import com.xmq.model.PeopleDESC;

public class AsyncPeopleAddDescItemProcessor implements
		ItemProcessor<People, Future<PeopleDESC>> {

	/**
	 * SyncTaskExecutor会在当前线程执行完客户提交给它的任务，即它是以同步方式完成任务的执行的。
	 * 
	 */
	private TaskExecutor taskExecutor = new SyncTaskExecutor();

	public Future<PeopleDESC> process(final People item) throws Exception {
		FutureTask<PeopleDESC> task = new FutureTask<PeopleDESC>(
				new Callable<PeopleDESC>() {
					public PeopleDESC call() throws Exception {
						Thread.sleep(2000);
						System.out.println("process people desc");
						return new PeopleDESC(item.getLastName(),
								item.getFirstName(), Thread.currentThread()
										.getName());
					}
				});
		this.taskExecutor.execute(task);
		return task;
	}

	public TaskExecutor getTaskExecutor() {
		return this.taskExecutor;
	}

	public void setTaskExecutor(TaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}

}
