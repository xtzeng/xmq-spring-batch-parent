package com.xmq.listener;

import java.util.List;

import org.springframework.batch.core.step.item.DefaultItemFailureHandler;

public class ExceptionListener extends DefaultItemFailureHandler {

	@Override
	public void onWriteError(Exception ex, List<? extends Object> items) {
		ex.printStackTrace();
		System.out.println("write data error :" + items.toString());
	}

	@Override
	public void onReadError(Exception ex) {
		ex.printStackTrace();
		System.out.println("read data error:");
	}

}