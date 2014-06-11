package com.madhusudhan.jsi.flow.splitter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.support.MessageBuilder;

import com.madhusudhan.jsi.domain.ITrade;
import com.madhusudhan.jsi.domain.TradeImpl;

public class FlowSplittersTest {
	private ApplicationContext ctx = null;

	private MessageChannel inChannel = null;

	public FlowSplittersTest() {
		ctx = new ClassPathXmlApplicationContext("flow-splitters-beans.xml");

		inChannel = ctx.getBean("in-channel", MessageChannel.class);

	}

	public void publishTrade(ITrade t) {

		Message<ITrade> tradeMsg = MessageBuilder.withPayload(t)
				.setHeader("status", "NEW").build();

		inChannel.send(tradeMsg, 10000);

		System.out.println("Trade Message published.");

	}

	private TradeImpl createNewTrade() {
		TradeImpl t = new TradeImpl();
		t.setId("1234");
		t.setAccount("B12D45");
		t.setDirection("BUY");
		t.setStatus("NEW");
		t.setEncryptedMsg("DDFd92322Ddf-3034790808");
		return t;
	}

	public void publish() {

		publishTrade(createNewTrade());
	}

	public static void main(String[] args) {
		FlowSplittersTest test = new FlowSplittersTest();

		test.publish();
	}
}
