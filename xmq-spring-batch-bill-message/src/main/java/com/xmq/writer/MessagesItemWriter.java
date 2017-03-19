package com.xmq.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.xmq.model.Message;

public class MessagesItemWriter implements ItemWriter<Message>{

	public void write(List<? extends Message> messages) throws Exception {
		System.out.println("write results");
		for (Message m : messages) {
			System.out.println("message---------------->>>>>>>>>>>"+m.getContent());
		}
	}
}
