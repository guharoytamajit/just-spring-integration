package com.madhusudhan.jsi.endpoints.common;

import com.madhusudhan.jsi.domain.Position;

public class NewTradeActivator {
	public void processNewPosition(Position t) {
		System.out.println("Method invoked by the Service Activator to process the new Trade"+t);
	}
}
