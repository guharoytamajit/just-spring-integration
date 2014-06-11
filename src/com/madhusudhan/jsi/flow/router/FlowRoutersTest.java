package com.madhusudhan.jsi.flow.router;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.support.MessageBuilder;

import com.madhusudhan.jsi.domain.Account;
import com.madhusudhan.jsi.domain.Trade;

public class FlowRoutersTest {
	private ApplicationContext ctx = null;

	private MessageChannel inChannel = null;

	public FlowRoutersTest() {
		ctx = new ClassPathXmlApplicationContext("flow-routers-beans.xml");

		inChannel = ctx.getBean("in-channel", MessageChannel.class);

	}

	public void publishTrade(Trade t) {

		Message<Trade> tradeMsg = MessageBuilder.withPayload(t)
				.setHeader("status", "NEW").build();

		inChannel.send(tradeMsg, 10000);

		System.out.println("Trade Message published.");

	}

	public void publishTwoTrades(Trade t) {

		Message<Trade> tradeMsg = MessageBuilder.withPayload(t)
				.setHeader("status", "NEW").build();

		inChannel.send(tradeMsg, 10000);

		tradeMsg = MessageBuilder.withPayload(t)
				.setHeader("status", "CANCEL").build();
		
		inChannel.send(tradeMsg, 10000);
		
		System.out.println("Trade Messages published.");

	}

	public void publishAccount(Account t) {
		Message<Account> accountMsg = MessageBuilder.withPayload(t).build();

		inChannel.send(accountMsg, 10000);

		System.out.println("Account Message published.");

	}

	private Trade createNewTrade() {
		Trade t = new Trade();
		t.setId("1234");
		t.setAccount("B12D45");
		t.setDirection("BUY");
		t.setStatus("NEW");
		t.setQuantity(4000000);
		return t;
	}

	private Trade createCancelTrade() {
		Trade t = new Trade();
		t.setId("1234");
		t.setAccount("B12D45");
		t.setDirection("BUY");
		t.setStatus("CANCEL");
		return t;
	}

	private Account createNewAccount() {
		Account a = new Account();
		a.setId("A111");
		a.setFirstName("MK");

		return a;
	}

	public void publish() {

		publishTrade(createNewTrade());
//		publishTwoTrades(createNewTrade());
		// publishAccount(createNewAccount());
	}

	public static void main(String[] args) {
		FlowRoutersTest test = new FlowRoutersTest();

		test.publish();
	}
}
