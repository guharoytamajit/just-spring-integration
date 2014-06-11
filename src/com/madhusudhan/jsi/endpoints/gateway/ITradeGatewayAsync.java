package com.madhusudhan.jsi.endpoints.gateway;

import java.util.concurrent.Future;

import com.madhusudhan.jsi.domain.Trade;

public interface ITradeGatewayAsync {

	public Future<Trade> processTrade(Trade t);
}
