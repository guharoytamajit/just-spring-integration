package com.madhusudhan.jsi.flow.router;

import org.springframework.integration.Message;

import com.madhusudhan.jsi.domain.Trade;

public class BigTradeRouter {
	public String bigTrade(Message<Trade> message) {
		Trade t = message.getPayload();
		if (t.getQuantity() > 10000)
			return "big-trades-channel";
		return "trades-stdout";
	}
}
