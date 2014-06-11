package com.madhusudhan.jsi.channels;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.MessageHeaders;
import org.springframework.integration.MessagingException;
import org.springframework.integration.channel.AbstractPollableChannel;
import org.springframework.integration.channel.PriorityChannel;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.channel.RendezvousChannel;
import org.springframework.integration.core.MessageHandler;
import org.springframework.integration.support.MessageBuilder;

import com.madhusudhan.jsi.domain.Trade;

public class ChannelTest {
	private ApplicationContext ctx = null;

	private MessageChannel qChannel = null;

	private MessageChannel pubSubChannel = null;

	private MessageChannel priorityChannel = null;

	private MessageChannel rendezvousChannel = null;

	public ChannelTest() {
		ctx = new ClassPathXmlApplicationContext("channels-beans.xml");

		qChannel = ctx.getBean("q-channel", MessageChannel.class);

		pubSubChannel = ctx.getBean("pubsub-channel", MessageChannel.class);

		priorityChannel = ctx.getBean("priority-channel", MessageChannel.class);

		rendezvousChannel = ctx.getBean("rendezvous-channel",
				MessageChannel.class);

	}

	public void sendTrade(Trade t) {
		Message<Trade> tradeMsg = MessageBuilder.withPayload(t).build();

		qChannel.send(tradeMsg, 10000);

		System.out.println(t.getStatus() + " Trade published");

	}

	public void publishTrade(Trade t) {
		Message<Trade> tradeMsg = MessageBuilder.withPayload(t).build();

		pubSubChannel.send(tradeMsg, 10000);

		System.out.println(t.getStatus()
				+ " Trade published to a subscribable channel");

	}

	public void sendTradeToRendezvous(Trade t) {
		Message<Trade> tradeMsg = MessageBuilder.withPayload(t)
//				.setHeader(MessageHeaders.REPLY_CHANNEL, "replyChannel")
				.build();

		rendezvousChannel.send(tradeMsg);

		System.out.println(t.getStatus()
				+ " Trade published to a Rendezvous channel");

	}

	public void publishTradeWithPriority(Trade t) {
		Message<Trade> tradeMsg = MessageBuilder.withPayload(t)
				.setHeader(MessageHeaders.PRIORITY, 2).build();

		priorityChannel.send(tradeMsg, 10000);
		tradeMsg = MessageBuilder.withPayload(t)
				.setHeader(MessageHeaders.PRIORITY, 4).build();

		priorityChannel.send(tradeMsg, 10000);

		System.out.println(t.getStatus() + "High Priority Trades published");

	}

	private Trade createNewTrade() {
		Trade t = new Trade();
		t.setId("1234");
		t.setAccount("B12D45");
		t.setDirection("BUY");
		t.setStatus("NEW");
		return t;
	}

	private void send() {
		sendTrade(createNewTrade());

	}

	private void publish() {
		publishTrade(createNewTrade());
	}

	private void publishPriorityTrades() {
		publishTradeWithPriority(createNewTrade());
	}

	private void publishTradesToRendezvous() {
		sendTradeToRendezvous(createNewTrade());
	}

	public void receive() {

		// This method receives a message, however it blocks
		// indefinitely until it finds a message
		// Message m = ((QueueChannel) qChannel).receive();

		// This method receives a message, however it exists
		// within the 10seconds even if doesn't find a message
		Message m = ((QueueChannel) qChannel).receive(10000);
		System.out.println("Payload: " + m.getPayload());
	}

	public void receiveFromRendezvous() {
		Message m = ((RendezvousChannel) rendezvousChannel).receive(10000);
//		MessageChannel replyChannel = (MessageChannel) m.getHeaders().get(MessageHeaders.REPLY_CHANNEL);
		//replyChanne.send(..)
		System.out.println("Payload: " + m.getPayload());
	}

	public void subscribe() {
		((PublishSubscribeChannel) pubSubChannel)
				.subscribe(new TradeMessageHandler());
	}

	public void receivePriorityTrades() {

		Message m = ((PriorityChannel) priorityChannel).receive();
		System.out.println("Payload from Priority Channel: " + m.getPayload());
	}

	public static void main(String[] args) {
		ChannelTest test = new ChannelTest();

//		 test.send();
//		 test.receive();
//
//		 test.subscribe();
//		 test.publish();

//		 test.publishPriorityTrades();
//		 test.receivePriorityTrades();

		test.publishTradesToRendezvous();
		test.receiveFromRendezvous();

	}

	class TradeMessageHandler implements MessageHandler {

		public void handleMessage(Message<?> message) throws MessagingException {
			System.out.println("Handling Message:" + message);
		}
	}
}
