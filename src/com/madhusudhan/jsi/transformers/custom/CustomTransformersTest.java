package com.madhusudhan.jsi.transformers.custom;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.support.MessageBuilder;

import com.madhusudhan.jsi.domain.Trade;

public class CustomTransformersTest {
	private ApplicationContext ctx = null;

	private MessageChannel channel = null;
	
	public CustomTransformersTest() {
		ctx = new ClassPathXmlApplicationContext("transformers-custom-beans.xml");
		
		channel = ctx.getBean("trades-in-channel",MessageChannel.class);
	}
	public void publishTrade(Trade t) {
		Message<Trade> tradeMsg = MessageBuilder.withPayload(t).build();
		
		channel.send(tradeMsg, 10000);
		
		System.out.println("Trade Message published.");
		
	}

	private Trade createNewTrade() {
		Trade t = new Trade();
		t.setId("1234");
		t.setAccount("B12D45");
		t.setDirection("BUY");
		t.setStatus("NEW");
		return t;
	}
	
	private void publish() {
		publishTrade(createNewTrade());
	}
	
	public static void main(String[] args) {
		CustomTransformersTest test = new CustomTransformersTest();
		
		test.publish();
	}
}
