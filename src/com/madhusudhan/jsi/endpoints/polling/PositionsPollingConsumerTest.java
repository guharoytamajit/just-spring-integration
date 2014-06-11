package com.madhusudhan.jsi.endpoints.polling;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.support.MessageBuilder;

import com.madhusudhan.jsi.domain.Position;

public class PositionsPollingConsumerTest {
	private ApplicationContext ctx = null;
	private QueueChannel channel = null;
	private PositionsPollingConsumer consumer = null;

	public PositionsPollingConsumerTest() {
		ctx = new ClassPathXmlApplicationContext("endpoints-api-beans.xml");
		channel = ctx.getBean("polling-channel", QueueChannel.class);

	}

	private void start() {
		consumer = new PositionsPollingConsumer(ctx, channel);
		consumer.startConsumer();
	}

	public void publishPosition(Position p) {
		Message<Position> msg = MessageBuilder.withPayload(p).build();

		channel.send(msg, 10000);

		System.out.println("Position Message published.");

	}

	private Position createNewPosition() {
		Position p = new Position();
		p.setId("1234");
		p.setAccount("B12D45");
		return p;
	}

	public static void main(String[] args) {
		PositionsPollingConsumerTest test = new PositionsPollingConsumerTest();
		test.start();
		test.publishPosition(test.createNewPosition());
		
	}
}
