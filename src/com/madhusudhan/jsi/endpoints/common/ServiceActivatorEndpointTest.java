package com.madhusudhan.jsi.endpoints.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.support.MessageBuilder;

import com.madhusudhan.jsi.domain.Position;


public class ServiceActivatorEndpointTest {
	private ApplicationContext ctx = null;
	private MessageChannel channel = null;

	public ServiceActivatorEndpointTest() {
		ctx = new ClassPathXmlApplicationContext("endpoints-common-beans.xml");
		
		channel = ctx.getBean("positions-channel",MessageChannel.class);
	}

	public void publishPosition(Position p) {
		Message<Position> msg = MessageBuilder.withPayload(p).build();

		channel.send(msg, 10000);

		System.out.println("Position Message published for a sevice activator to pickup.");

	}

	private Position createNewPosition() {
		Position p = new Position();
		p.setId("1234");
		p.setAccount("B12D45");
		return p;
	}
	public static void main(String[] args) {
		ServiceActivatorEndpointTest test = new ServiceActivatorEndpointTest();
		Position p = test.createNewPosition();
		test.publishPosition(p);
	}
}
