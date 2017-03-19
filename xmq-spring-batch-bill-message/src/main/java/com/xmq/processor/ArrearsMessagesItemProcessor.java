package com.xmq.processor;

import org.springframework.batch.item.ItemProcessor;

import com.xmq.model.Bill;
import com.xmq.model.Message;

public class ArrearsMessagesItemProcessor implements
		ItemProcessor<Bill, Message> {

	public Message process(Bill item) throws Exception {
		if (item.getPayStatus() == 0) {/*unpaid*/
			Message m = new Message();
			m.setUser(item.getUser());
			m.setContent("Hello " + item.getUser().getName()
					+ ",please pay promptly at end of this month.");
			return m;
		}
		return null;
	}

}
