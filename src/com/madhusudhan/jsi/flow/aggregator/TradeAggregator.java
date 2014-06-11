package com.madhusudhan.jsi.flow.aggregator;

import java.util.List;

import com.madhusudhan.jsi.domain.EncryptedTrade;
import com.madhusudhan.jsi.domain.ITrade;
import com.madhusudhan.jsi.domain.TradeImpl;

public class TradeAggregator {

	public ITrade aggregateTrade(List<ITrade> childTrades) {
		ITrade t = null;
		TradeImpl t1 = null;
		String encryptedMsg = null;
		EncryptedTrade t2 = null;

		for (ITrade trade : childTrades) {
			System.out.println("Received child trade:" + trade);
			t = (ITrade) trade;

			if (t instanceof TradeImpl) {
				t1 = (TradeImpl) trade;
				System.out.println("Original T1 : "+t1);
			} else if (t instanceof EncryptedTrade) {
				t2 = (EncryptedTrade)t;
				encryptedMsg = t2.getEncryptedMsg();
			}
		}
		t1.setEncryptedMsg(encryptedMsg);
		System.out.println("Enc Msg in T1: "+t1.getEncryptedMsg());
		System.out.println("T1 : "+t1);

		return t1;

	}
}
