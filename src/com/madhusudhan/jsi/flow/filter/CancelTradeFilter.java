package com.madhusudhan.jsi.flow.filter;

import org.springframework.integration.Message;

import org.springframework.integration.core.MessageSelector;

import com.madhusudhan.jsi.domain.Trade;

public class CancelTradeFilter implements MessageSelector {

	public boolean accept(Message<?> message) {
		Trade t = (Trade)message.getPayload();
		return (t.getStatus().equalsIgnoreCase("cancel"));
	}

}
