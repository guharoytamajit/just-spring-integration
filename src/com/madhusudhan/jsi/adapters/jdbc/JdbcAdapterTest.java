package com.madhusudhan.jsi.adapters.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class JdbcAdapterTest {
	
	private ApplicationContext ctx = null;
	
	private void useNameSpace(){
		ctx = new ClassPathXmlApplicationContext(
				"adapters-jdbc-beans.xml");
		
	}

	public static void main(String[] args) {
		JdbcAdapterTest test = new JdbcAdapterTest();
		test.useNameSpace();
	}

}
