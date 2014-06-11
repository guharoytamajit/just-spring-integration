package com.madhusudhan.jsi.flow.router;

import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.annotation.Router;
import org.springframework.stereotype.Component;

import com.madhusudhan.jsi.domain.Trade;

@Component
public class AnnotatedBigTradeRouter {
	@Router
	public String bigTrade(Message<Trade> message) {
		Trade t = message.getPayload();
		if (t.getQuantity() > 10000)
			return "big-trades-channel";
		return "trades-stdout";
	}
	
	@Router
	public MessageChannel bigTrade2(Message<Trade> message) {
		Trade t = message.getPayload();
		if (t.getQuantity() > 10000)
			return null;
		return null;
	}
}
