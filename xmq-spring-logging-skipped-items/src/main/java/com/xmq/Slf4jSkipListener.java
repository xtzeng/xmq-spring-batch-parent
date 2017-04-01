package com.xmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.listener.SkipListenerSupport;

// TODO 01 make the listener extend the SkipListenerSupport class
public class Slf4jSkipListener<T,S> extends SkipListenerSupport{
	
	private static final Logger LOG = LoggerFactory.getLogger(Slf4jSkipListener.class);

	// TODO 02 override the onSkipInRead method and log the exception message
	// use the warn level
	@Override
	public void onSkipInRead(Throwable t) {
		LOG.warn("skipped item:------------->>>>>>>>>>>>>>>>>>>>> {}",t.toString());
	}
}
