package com.madhusudhan.jsi.endpoints.enricher;

import org.springframework.integration.Message;
import org.springframework.integration.MessageHeaders;

import com.madhusudhan.jsi.domain.Trade;

public class TradeEnricher {
	public String enrichHeader(Message m) {
		
		System.out.println("MSG RECD");
		Trade t = (Trade)m.getPayload();
		return t.getId()+"SRC";
	}
}
