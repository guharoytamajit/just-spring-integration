package com.madhusudhan.jsi.flow.aggregator;

import org.springframework.integration.Message;
import org.springframework.integration.aggregator.CorrelationStrategy;

import com.madhusudhan.jsi.domain.TradeImpl;

public class MyCorrelationStrategy implements CorrelationStrategy {

	public Object getCorrelationKey(Message<?> message) {
		TradeImpl t = (TradeImpl) message.getPayload();

		return null;
	}
}
