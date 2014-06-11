package com.madhusudhan.jsi.channels;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessagingException;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.core.MessageHandler;
import org.springframework.integration.support.MessageBuilder;

import com.madhusudhan.jsi.domain.Trade;

public class PubSubTest {
	MessageHandler handler = new TradeMessageHandler();

	private ApplicationContext ctx = null;

	private PublishSubscribeChannel pubSubChannel = null;

	public PubSubTest() {
		ctx = new ClassPathXmlApplicationContext("channels-beans.xml");

		pubSubChannel = ctx.getBean("pubsub-channel",
				PublishSubscribeChannel.class);

	}

	// subscribe to the channel
	public void subscribe() {
		boolean handlerAdded = pubSubChannel.subscribe(handler);
		System.out.println("Handler added?" + handlerAdded);
	}

	// Unsubscribe using the same channel and handler references.
	public void unsubscribe() {
		boolean handlerRemoved = pubSubChannel.unsubscribe(handler);
		System.out.println("Handler removed?" + handlerRemoved);
	}

	class TradeMessageHandler implements MessageHandler {
		public void handleMessage(Message<?> message) throws MessagingException {
			System.out.println("Handling Message:" + message);
		}
	}

	public void publishTrade() {

		Trade t = createNewTrade();

		Message<Trade> tradeMsg = MessageBuilder.withPayload(t).build();

		pubSubChannel.send(tradeMsg, 10000);

		System.out.println(t.getStatus()
				+ " Trade published to a subscribable channel");

	}

	private Trade createNewTrade() {
		Trade t = new Trade();
		t.setId("1234");
		t.setAccount("B12D45");
		t.setDirection("BUY");
		t.setStatus("NEW");
		return t;
	}

	public static void main(String[] args) {
		PubSubTest test = new PubSubTest();

		test.subscribe();
		test.publishTrade();
		test.unsubscribe();
	}
}