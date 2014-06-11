package com.madhusudhan.jsi.adapters.jms;

import org.springframework.integration.Message;
import org.springframework.integration.support.converter.MessageConverter;


public class PositionsConverter implements MessageConverter {

	public <P> Message<P> toMessage(Object object) {
		return null;
	}

	public <P> Object fromMessage(Message<P> message) {
		return null;
	}

}
