package com.madhusudhan.jsi.transformers.custom;

import java.util.HashMap;
import java.util.Map;

import org.springframework.integration.annotation.Transformer;
import org.springframework.stereotype.Component;

import com.madhusudhan.jsi.domain.Trade;

@Component
public class AnnotatedTradeMapTransformer {
	
	@Transformer
	public Map<String, String> transform(Trade t) {
		System.out.println("Annotated Transformer was called..");
		Map<String,String> tradeNameValuesMap = new HashMap<String,String>();
		
		tradeNameValuesMap.put("TRADE_ID", t.getId());
		tradeNameValuesMap.put("TRADE_ACCOUNT", t.getAccount());
		tradeNameValuesMap.put("TRADE_SECURITY", t.getSecurity());
		tradeNameValuesMap.put("TRADE_DIRECTION", t.getDirection());
		tradeNameValuesMap.put("TRADE_STATUS", t.getStatus());
		
		return tradeNameValuesMap;
	}
}
