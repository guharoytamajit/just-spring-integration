package com.madhusudhan.jsi.endpoints.polling;

import org.springframework.context.ApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessagingException;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.core.MessageHandler;
import org.springframework.integration.endpoint.PollingConsumer;
import org.springframework.scheduling.support.PeriodicTrigger;
import org.springframework.scheduling.support.CronTrigger;

public class PositionsPollingConsumer {
	private PollingConsumer consumer = null;

	private PositionsHandler positionsHandler = null;
	private ApplicationContext ctx = null;
	private PeriodicTrigger periodicTrigger = null;
	private CronTrigger cronTrigger = null;

	public PositionsPollingConsumer(ApplicationContext ctx,
			QueueChannel positionsChannel) {
		
		this.ctx = ctx;
		// sec min hr day month weekday
		String cronExpression="* 01 00 * * MON-FRI";
		cronTrigger = new CronTrigger(cronExpression);
//		periodicTrigger = new PeriodicTrigger(2000);
//
//		periodicTrigger.setInitialDelay(0);
//
//		periodicTrigger.setFixedRate(false);

		positionsHandler = new PositionsHandler();

		consumer = new PollingConsumer(positionsChannel, positionsHandler);

		consumer.setBeanFactory(ctx);
		
	}

	public void startConsumer() {

		consumer.start();
	}

	class PositionsHandler implements MessageHandler {

		public void handleMessage(Message<?> message) throws MessagingException {
			System.out.println("Handling a message using PollingConsumer: "
					+ message.getPayload().toString());
		}

	}

}
