package com.madhusudhan.jsi.adapters.jms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class JmsAdapterTest {
	
	private ApplicationContext ctx = null;

	private void useNameSpace(){
		ctx = new ClassPathXmlApplicationContext(
				"adapters-jms-beans.xml");
		
	}

	public static void main(String[] args) {
		JmsAdapterTest test = new JmsAdapterTest();
		test.useNameSpace();
	}

}
