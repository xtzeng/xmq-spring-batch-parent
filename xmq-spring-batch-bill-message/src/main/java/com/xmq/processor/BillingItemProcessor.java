package com.xmq.processor;

import org.springframework.batch.item.ItemProcessor;

import com.xmq.model.Bill;
import com.xmq.model.User;

public class BillingItemProcessor implements ItemProcessor<User, Bill> {

	public Bill process(User item) throws Exception {
		Bill b = new Bill();
		b.setUser(item);
		b.setFees(70.00);
		b.setPaidFees(0.0);
		b.setUnpaidFees(70.00);
		b.setPayStatus(0);/*unpaid*/
		return b;
	}

}
