package com.madhusudhan.jsi.flow.filter;

import org.springframework.integration.Message;

import com.madhusudhan.jsi.domain.Trade;

public class OwnCancelTradeFilter {

	public boolean isTradeCancelled(Message<?> message) {
		Trade t = (Trade)message.getPayload();
		return (t.getStatus().equalsIgnoreCase("cancel"));
	}

}
