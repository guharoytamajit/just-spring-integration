package com.madhusudhan.jsi.channels;

import java.util.Comparator;

import org.springframework.integration.Message;

import com.madhusudhan.jsi.domain.Account;

public class AccountComparator implements Comparator<Message<Account>> {

	public int compare(Message<Account> msg1, Message<Account> msg2) {
		Account a1 = (Account)msg1.getPayload();
		Account a2 = (Account)msg2.getPayload();
		
		Integer i1 = a1.getAccountType();
		Integer i2 = a2.getAccountType();
		
//		System.out.println("Account1:"+i1);
//		System.out.println("Account2:"+i2);
		System.out.println("compare val: "+i1.compareTo(i2));
		
		return i1.compareTo(i2);
	}

}
