package com.madhusudhan.jsi.flow.filter;

import org.springframework.integration.Message;
import org.springframework.integration.annotation.Filter;
import org.springframework.stereotype.Component;

import com.madhusudhan.jsi.domain.Trade;

@Component
public class AnnotatedNewTradeFilter {

	@Filter
	public boolean accept(Message<?> message) {
		System.out.println("Inside Annotated Filter");
		Trade t = (Trade)message.getPayload();
		return (t.getStatus().equalsIgnoreCase("cancel"));
	}

}
