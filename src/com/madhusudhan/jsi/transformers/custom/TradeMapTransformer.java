package com.madhusudhan.jsi.transformers.custom;

import java.util.HashMap;
import java.util.Map;

import com.madhusudhan.jsi.domain.Trade;

public class TradeMapTransformer {
	public Map<String, String> transform(Trade t) {
		Map<String,String> tradeNameValuesMap = new HashMap<String,String>();
		
		tradeNameValuesMap.put("TRADE_ID", t.getId());
		tradeNameValuesMap.put("TRADE_ACCOUNT", t.getAccount());
		tradeNameValuesMap.put("TRADE_SECURITY", t.getSecurity());
		tradeNameValuesMap.put("TRADE_DIRECTION", t.getDirection());
		tradeNameValuesMap.put("TRADE_STATUS", t.getStatus());
		
		return tradeNameValuesMap;
	}
}
