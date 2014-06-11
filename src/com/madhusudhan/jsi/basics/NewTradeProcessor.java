package com.madhusudhan.jsi.basics;

import org.springframework.integration.Message;

public class NewTradeProcessor {

	public void processNewTrade(Message m){
		// Process your trade here.
		System.out.println("Message received:"+m.getPayload().toString());
	}
}
