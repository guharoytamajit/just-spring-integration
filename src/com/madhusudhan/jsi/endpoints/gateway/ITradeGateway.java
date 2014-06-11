package com.madhusudhan.jsi.endpoints.gateway;

import com.madhusudhan.jsi.domain.Trade;

public interface ITradeGateway {

	public Trade processTrade(Trade t);
}