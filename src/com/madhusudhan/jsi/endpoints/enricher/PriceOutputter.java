package com.madhusudhan.jsi.endpoints.enricher;

import org.springframework.integration.Message;
import org.springframework.integration.MessageHeaders;

public class PriceOutputter {
	public void logHeaders(Message m) {
		MessageHeaders h = m.getHeaders();
		System.out.println("Headers: "+h.toString());
		
	}
}
