package com.xmq.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.util.StringUtils;

import com.xmq.model.Message;
import com.xmq.model.User;

public class MessagesItemProcessor implements ItemProcessor<User, Message> {

	public Message process(User user) throws Exception {
		if(!StringUtils.hasText(user.getName())){
			throw new RuntimeException("The user name is required!");
		}
		Message m = new Message();
		m.setUser(user);
		m.setContent("Hello " + user.getName()
				+ ",please pay promptly at end of this month.");
		return m;
	}

}
