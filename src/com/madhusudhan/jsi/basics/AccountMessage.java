package com.madhusudhan.jsi.basics;

import java.util.HashMap;
import java.util.Map;

import org.springframework.integration.Message;
import org.springframework.integration.message.GenericMessage;
import org.springframework.integration.support.MessageBuilder;

import com.madhusudhan.jsi.domain.Account;


public class AccountMessage {

	public Message<Account> createAccountMessage() {
		Account a = new Account();
		Message<Account> m = MessageBuilder.withPayload(a).setHeader("ACCOUNT_EXPIRY", "NEVER").build();
		
		return m;
	}
	
	public void createGenericMessage(){
		Account a = new Account();
		
		GenericMessage<Account> gm = new GenericMessage<Account>(a);
		
		Map<String, Object> headerProperties = new HashMap<String, Object>();
		headerProperties.put("ACCOUNT_EXPIRY","NEVER");
		
		GenericMessage<Account> gmWithHeades = new GenericMessage<Account>(a,headerProperties);
	}
}
