package com.madhusudhan.jsi.flow.aggregator;

import org.springframework.integration.aggregator.ReleaseStrategy;
import org.springframework.integration.store.MessageGroup;

public class MyReleaseStrategy implements ReleaseStrategy {

	public boolean canRelease(MessageGroup group) {
		return false;
	}
}
