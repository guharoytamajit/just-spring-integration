package com.madhusudhan.jsi.adapters.file;

import java.io.File;

import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.channel.QueueChannel;

public class PositionReceiver {
	private MessageChannel channel = null;
	private File positionsFile = null;

	public PositionReceiver(MessageChannel channel) {
		this.channel = channel;
	}

	public void receiveTrade() {
		while (true) {
			Message<?> m = ((QueueChannel) channel).receive();
			positionsFile = (File)m.getPayload();
			
			System.out.println("Payload: " +positionsFile );
		}
	}

	public void start() {
		receiveTrade();
	}
}
