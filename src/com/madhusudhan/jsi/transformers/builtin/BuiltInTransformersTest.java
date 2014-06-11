package com.madhusudhan.jsi.transformers.builtin;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.support.MessageBuilder;

import com.madhusudhan.jsi.domain.SerializableTrade;
import com.madhusudhan.jsi.domain.Trade;

public class BuiltInTransformersTest {
	private ApplicationContext ctx = null;

	private MessageChannel inChannel = null;
	
	public BuiltInTransformersTest() {
		ctx = new ClassPathXmlApplicationContext("transformers-builtin-beans.xml");
		
		inChannel = ctx.getBean("in-channel",MessageChannel.class);
		
	}
	public void publishTrade(Trade t) {
		Message<Trade> tradeMsg = MessageBuilder.withPayload(t).build();
		
		inChannel.send(tradeMsg, 10000);
		
		System.out.println("Trade Message published.");
		
	}
	
	public void publishTradeXml(String xml) {
		Message<String> tradeMsg = MessageBuilder.withPayload(xml).build();
		
		inChannel.send(tradeMsg, 10000);
		
		System.out.println("XML Trade Message published.");
		
	}

	public void publishSerializableTrade(SerializableTrade t) {
		Message<SerializableTrade> tradeMsg = MessageBuilder.withPayload(t).build();
		
		inChannel.send(tradeMsg, 10000);
		
		System.out.println("SerializableTrade Message published.");
		
	}
	private Trade createNewTrade() {
		Trade t = new Trade();
		t.setId("1234");
		t.setAccount("B12D45");
		t.setDirection("BUY");
		t.setStatus("NEW");
		return t;
	}
	
	private String createNewTradeXml() {
	  return "<trade status='NEW' account='B12D45' direction='BUY'/>";
	}
	
	private SerializableTrade createNewSerializableTrade() {
		SerializableTrade t = new SerializableTrade();
		t.setId("1234");
		t.setAccount("B12D45");
		t.setDirection("BUY");
		t.setStatus("NEW");
		return t;
	}
	
	private void publish() {
		publishTrade(createNewTrade());
		
//		publishSerializableTrade(createNewSerializableTrade());
		
//		publishTradeXml(createNewTradeXml());
	}
	
	public static void main(String[] args) {
		BuiltInTransformersTest test = new BuiltInTransformersTest();
		
		test.publish();
	}
}
