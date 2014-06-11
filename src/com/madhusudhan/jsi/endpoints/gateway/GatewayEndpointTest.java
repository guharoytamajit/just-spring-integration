package com.madhusudhan.jsi.endpoints.gateway;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.support.MessageBuilder;

import com.madhusudhan.jsi.domain.Position;
import com.madhusudhan.jsi.domain.Trade;


public class GatewayEndpointTest {
	private ApplicationContext ctx = null;
	private ITradeGateway tradeGateway = null;
	private ITradeGatewayAsync asyncTradeGateway = null;

	public GatewayEndpointTest() {
		ctx = new ClassPathXmlApplicationContext("endpoints-gateway-beans.xml");
		
		tradeGateway = ctx.getBean("tradeGateway",ITradeGateway.class);
		
		System.out.println("Gateway obtained:"+tradeGateway);
		
        asyncTradeGateway = ctx.getBean("asyncTradeGateway",ITradeGatewayAsync.class);
		
		System.out.println("Async Gateway obtained:"+asyncTradeGateway);
	}

	public void publishTrade(Trade t) {

		Trade it = tradeGateway.processTrade(t);

		System.out.println("Trade Message published (Reply)."+it.getStatus());

	}
	
	public void publishTradeAsync(Trade t) {

		Future<Trade> f = asyncTradeGateway.processTrade(t);

		Trade ft = null;
		try {
			ft = f.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		System.out.println("Trade Message published (Reply)."+ft.getStatus());

	}

	private Trade createNewTrade() {
		Trade t = new Trade();
		t.setId("1234");
		t.setAccount("B12D45");
		return t;
	}
	public static void main(String[] args) {
		GatewayEndpointTest test = new GatewayEndpointTest();
		Trade t = test.createNewTrade();
//		test.publishTrade(t);
		
		test.publishTradeAsync(t);
	}
}
