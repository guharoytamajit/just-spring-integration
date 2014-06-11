package com.madhusudhan.jsi.flow.filter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.support.MessageBuilder;

import com.madhusudhan.jsi.domain.Trade;

public class FlowFiltersTest {
	private ApplicationContext ctx = null;

	private MessageChannel inChannel = null;
	
	public FlowFiltersTest() {
		ctx = new ClassPathXmlApplicationContext("flow-filters-beans.xml");
		
		inChannel = ctx.getBean("in-channel",MessageChannel.class);
		
	}
	public void publishTrade(Trade t) {
		Message<Trade> tradeMsg = MessageBuilder.withPayload(t).build();
		
		inChannel.send(tradeMsg, 10000);
		
		System.out.println(t.getStatus()+" Trade published");
		
	}

	private Trade createNewTrade() {
		Trade t = new Trade();
		t.setId("1234");
		t.setAccount("B12D45");
		t.setDirection("BUY");
		t.setStatus("NEW");
		return t;
	}
	
	private Trade createCancelledTrade() {
		Trade t = new Trade();
		t.setId("039201");
		t.setAccount("A334D453333");
		t.setDirection("SELL");
		t.setStatus("CANCEL");
		return t;
	}
	
	private void publish() {
		publishTrade(createNewTrade());
		
		publishTrade(createCancelledTrade());
		
	}
	
	public static void main(String[] args) {
		FlowFiltersTest test = new FlowFiltersTest();
		
		test.publish();
	}
}
