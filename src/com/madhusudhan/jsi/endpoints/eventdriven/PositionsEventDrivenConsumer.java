package com.madhusudhan.jsi.endpoints.eventdriven;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessagingException;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.core.MessageHandler;
import org.springframework.integration.endpoint.EventDrivenConsumer;

public class PositionsEventDrivenConsumer {
	private EventDrivenConsumer consumer = null;
	private PositionsHandler positionsHandler = null;
	private ApplicationContext ctx = null;

	public PositionsEventDrivenConsumer(ApplicationContext ctx,
			PublishSubscribeChannel positionsChannel) {
		
		this.ctx = ctx;

		positionsHandler = new PositionsHandler();

		consumer = new EventDrivenConsumer(positionsChannel, positionsHandler);

		consumer.setBeanFactory(ctx);
		
	}

	public void startConsumer() {

		consumer.start();
	}

	class PositionsHandler implements MessageHandler {

		public void handleMessage(Message<?> message) throws MessagingException {
			System.out.println("Handling a message using a EventDrivenConsumer: "
					+ message.getPayload().toString());
		}

	}
	
	
}
