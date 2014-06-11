package com.madhusudhan.jsi.basics;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.support.MessageBuilder;

import com.madhusudhan.jsi.domain.Trade;


public class NewTradeProcessorTest {
	private ApplicationContext ctx = null;

	private MessageChannel channel = null;

	public NewTradeProcessorTest() {
		ctx = new ClassPathXmlApplicationContext("basics-beans.xml");

		channel = ctx.getBean("trades-channel", MessageChannel.class);
	}

	private Trade createNewTrade() {
		Trade t = new Trade();
		t.setId("1234");
		t.setAccount("B12D45");
		t.setDirection("BUY");
		t.setStatus("NEW");
		return t;
	}

	private void sendTrade() {

		Trade trade = createNewTrade();

		Message<Trade> tradeMsg = MessageBuilder.withPayload(trade).build();

		channel.send(tradeMsg, 10000);

		System.out.println("Trade Message published.");

	}

	public static void main(String[] args) {
		NewTradeProcessorTest test = new NewTradeProcessorTest();
		test.sendTrade();
	}
}
