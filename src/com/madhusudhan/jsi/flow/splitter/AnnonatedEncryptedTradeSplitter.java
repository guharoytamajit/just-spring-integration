package com.madhusudhan.jsi.flow.splitter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.integration.Message;
import org.springframework.integration.annotation.Splitter;
import org.springframework.stereotype.Component;

import com.madhusudhan.jsi.domain.EncryptedTrade;
import com.madhusudhan.jsi.domain.ITrade;
import com.madhusudhan.jsi.domain.TradeImpl;

@Component
public class AnnonatedEncryptedTradeSplitter{

	@Splitter
	public List<ITrade> splitMyMessageToTrades(Message<?> message) {
		
		List<ITrade> trades = new ArrayList<ITrade>();
		
		TradeImpl t = (TradeImpl)message.getPayload();
		
		EncryptedTrade et = new EncryptedTrade(t.getEncryptedMsg());
		
		trades.add(t);
		
		trades.add(et);
		
		System.out.println("Splitting message done, list: "+trades);
		
		return trades;
	}

}
