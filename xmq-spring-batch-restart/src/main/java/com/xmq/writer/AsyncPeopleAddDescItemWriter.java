package com.xmq.writer;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Future;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.xmq.model.PeopleDESC;

@Component
public class AsyncPeopleAddDescItemWriter implements
		ItemWriter<Future<PeopleDESC>> {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void write(List<? extends Future<PeopleDESC>> items)
			throws Exception {
		LinkedList<Future<PeopleDESC>> linklist = new LinkedList<Future<PeopleDESC>>(
				items);

		Future<PeopleDESC> future;

		// the head of this linklist
		while ((future = linklist.poll()) != null) {
			if (future.isDone()) {
				if (!future.isCancelled()) {
					System.out.println("write people desc");
					PeopleDESC peopleDESC = future.get();
					this.jdbcTemplate
							.update("insert into people_desc (first_name, last_name, batch_desc) values (?, ?, ?)",
									peopleDESC.getFirstName(),
									peopleDESC.getLastName(),
									peopleDESC.getDesc());
				}
			} else {
				linklist.addLast(future);
			}
		}
	}
}
