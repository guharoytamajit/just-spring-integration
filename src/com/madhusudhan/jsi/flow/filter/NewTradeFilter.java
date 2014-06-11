package com.madhusudhan.jsi.flow.filter;

import org.springframework.integration.Message;

import org.springframework.integration.annotation.Filter;
import org.springframework.integration.annotation.Header;
import org.springframework.integration.core.MessageSelector;

import com.madhusudhan.jsi.domain.Trade;

public class NewTradeFilter { //implements MessageSelector {
	
	public boolean isNewTrade(Message<?> message) {
		Trade t = (Trade)message.getPayload();
		return (t.getStatus().equalsIgnoreCase("new"));
	}
	
	public boolean isNewTrade2(Message<?> message) {
		Trade t = (Trade)message.getPayload();
		return (t.getStatus().equalsIgnoreCase("new"));
	}
//	
//	@Filter
//	public boolean acceptHeader(@Header("STATUS") String status) {
//		return (status.equalsIgnoreCase("new"));
//	}

}
