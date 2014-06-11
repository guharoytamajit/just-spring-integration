package com.madhusudhan.jsi.adapters.file;

import java.io.File;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.integration.file.FileWritingMessageHandler;


public class PositionsFileAdapterTest {
	
	private QueueChannel positionsChannel = null;
	
	private PublishSubscribeChannel positionsOutboundChannel = null;
	
	private PublishSubscribeChannel positionsOutboundChannel2 = null;
	
	private PositionReceiver consumer = null;
	
	private ApplicationContext ctx = null;

	private FileReadingMessageSource src = null;
	
	private FileWritingMessageHandler writer = null;
	
	public PositionsFileAdapterTest() {
		
	}

	private void startStandalone() {
		src = new FileReadingMessageSource();
		
		File directory = new File("/Users/mkonda/dev/ws");
		
		src.setDirectory(directory);
		
		Message<File> msg = src.receive();
		
		
		System.out.println("Message received"+msg);
	}

	private void startStandaloneWriter() {
		
		ctx = new ClassPathXmlApplicationContext(
				"com/madhusudhan/jsi/adapters/test-adapters-file-beans.xml");
		
		positionsOutboundChannel = ctx.getBean("positions-file-channel-sub",PublishSubscribeChannel.class);
		
		positionsOutboundChannel2 = ctx.getBean("positions-file-channel-sub2",PublishSubscribeChannel.class);
		
		File directory = new File("/Users/mkonda/dev/ws/tmp");
		
		writer = new FileWritingMessageHandler(directory);
		
//		writer.setOutputChannel(positionsOutboundChannel2);
		
		positionsOutboundChannel.subscribe(writer);

	}

	private void usingDeclaredBean() {
		ctx = new ClassPathXmlApplicationContext(
				"com/madhusudhan/jsi/adapters/test-adapters-file-beans.xml");
	
		src = ctx.getBean("positionsReader", FileReadingMessageSource.class);
		
		Message<File> msg = src.receive();
		
		
		System.out.println("Message received from the bean:"+msg);
	}
	
	private void useNameSpace(){
		ctx = new ClassPathXmlApplicationContext(
				"com/madhusudhan/jsi/adapters/test-adapters-file-beans.xml");
		
//		positionsChannel = ctx.getBean("positions-files-channel",QueueChannel.class);
//		
//		consumer = new PositionReceiver(positionsChannel);
//		
//		consumer.receiveTrade();
	}

	public static void main(String[] args) {
		PositionsFileAdapterTest test = new PositionsFileAdapterTest();
//		test.startStandalone();
//		test.usingDeclaredBean();
		test.useNameSpace();
//		test.startStandaloneWriter();
	}

}
