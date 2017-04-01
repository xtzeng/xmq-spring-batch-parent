package com.xmq;

import java.util.UUID;

import org.apache.commons.lang.math.RandomUtils;

public class RegistrationService {

	public RegistrationConfirmation process(Contact contact) {
		// TODO 01 take a look at the (dummy) business logic
		// it's about confirming the contact is registered
		return new RegistrationConfirmation(
			UUID.randomUUID().toString(),
			contact,
			RandomUtils.nextBoolean()
		);
	}
	
}
