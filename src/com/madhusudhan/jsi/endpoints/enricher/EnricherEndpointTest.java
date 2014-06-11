package com.madhusudhan.jsi.endpoints.enricher;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.MessageHeaders;
import org.springframework.integration.support.MessageBuilder;

import com.madhusudhan.jsi.domain.Price;

public class EnricherEndpointTest {
	private ApplicationContext ctx = null;
	private MessageChannel channel = null;

	public EnricherEndpointTest() {
		ctx = new ClassPathXmlApplicationContext("endpoints-enricher-beans.xml");

		channel = ctx.getBean("in-channel", MessageChannel.class);
	}

	public void publishPrice(Price p) {
		Message<Price> msg = MessageBuilder.withPayload(p)
				.setHeader(MessageHeaders.REPLY_CHANNEL, "reply-channel")
				.build();

		channel.send(msg, 10000);

		System.out.println("Price Message published.");

	}

	private Price createNewPrice() {
		Price p = new Price();
		return p;
	}

	public void start() {

		publishPrice(createNewPrice());

	}

	public static void main(String[] args) {
		EnricherEndpointTest pp = new EnricherEndpointTest();
		pp.start();
	}
}
