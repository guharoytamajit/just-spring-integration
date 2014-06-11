package com.madhusudhan.jsi.endpoints.delayer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.support.MessageBuilder;

import com.madhusudhan.jsi.domain.Price;

public class DelayerTest {
	private ApplicationContext ctx = null;
	private MessageChannel channel = null;

	public DelayerTest() {
		ctx = new ClassPathXmlApplicationContext("endpoints-delayer-beans.xml");

		channel = ctx.getBean("prices-in-channel", MessageChannel.class);
	}

	public void publishPrice(Price p) {
		Message<Price> msg = MessageBuilder.withPayload(p).build();

		channel.send(msg, 10000);

		System.out.println("Price Message published.");

	}

	private Price createNewPrice() {
		Price p = new Price();
		p.setInstrument("APLE");
		p.setPrice(394.56);
		return p;
	}

	public void start() {

		publishPrice(createNewPrice());

	}

	public static void main(String[] args) {
		DelayerTest pp = new DelayerTest();
		pp.start();
	}
}
