package com.madhusudhan.jsi.transformers.custom;

import com.madhusudhan.jsi.domain.Trade;

public class PojoToStringTransformer {
	private final String tradeString = "TRADE_ID=%s,TRADE_ACCOUNT=%s, TRADE_SECURITY=%s,TRADE_DIRECTION=%s,TRADE_STATUS=%s";

	public String transform(Trade t) {
		return String.format(tradeString, t.getId(), t.getAccount(),
				t.getSecurity(), t.getDirection(), t.getStatus());
	}
}
