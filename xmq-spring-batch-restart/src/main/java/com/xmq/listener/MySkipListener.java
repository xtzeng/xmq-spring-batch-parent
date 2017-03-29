package com.xmq.listener;

import org.springframework.batch.core.listener.SkipListenerSupport;

import com.xmq.model.People;
import com.xmq.model.PeopleDESC;


public class MySkipListener extends SkipListenerSupport<People, PeopleDESC> {

	@Override
	public void onSkipInRead(Throwable t) {
		// TODO Auto-generated method stub
		super.onSkipInRead(t);
		System.out.println(">>>>>>>>>>>>>>skip in read>>>>>>>>>>>>>>");
	}

	@Override
	public void onSkipInWrite(PeopleDESC item, Throwable t) {
		// TODO Auto-generated method stub
		super.onSkipInWrite(item, t);
		System.out.println(">>>>>>>>>>>>>>skip in write>>>>>>>>>>>>>>");
		System.out.println(">>>>=" + item.toString());
	}

	/**
	 * 当processor抛出 skip include包含的异常时
	 */
	@Override
	public void onSkipInProcess(People item, Throwable t) {
		// TODO Auto-generated method stub
		super.onSkipInProcess(item, t);
		System.out.println(">>>>>>>>>>>>>>skip in process>>>>>>>>>>>>>>");
		System.out.println(">>>>=" + item.toString());
	}
}
