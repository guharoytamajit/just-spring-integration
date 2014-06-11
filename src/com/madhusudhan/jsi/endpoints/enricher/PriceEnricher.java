package com.madhusudhan.jsi.endpoints.enricher;

import org.springframework.integration.Message;
import org.springframework.integration.MessageHeaders;

import com.madhusudhan.jsi.domain.Price;
import com.madhusudhan.jsi.domain.Trade;

public class PriceEnricher {
	public Price enrichHeader(Message m) {
		Price t = (Price)m.getPayload();
		t.setInstrument("IBM");
		t.setPrice(111.11);
		return t;
	}
}
