package com.madhusudhan.jsi.endpoints.common;

import com.madhusudhan.jsi.domain.Position;

public class PositionReceiver {
	public void receive(Position p) {
		
		System.out.println("Received a position from a pub-sub channel using bridge:"+p);
	}
}
