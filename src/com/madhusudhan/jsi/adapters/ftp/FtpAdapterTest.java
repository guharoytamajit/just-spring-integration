package com.madhusudhan.jsi.adapters.ftp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class FtpAdapterTest {
	
	private ApplicationContext ctx = null;
	
	private void useNameSpace(){
		ctx = new ClassPathXmlApplicationContext(
				"adapters-ftp-beans.xml");
		
	}

	public static void main(String[] args) {
		FtpAdapterTest test = new FtpAdapterTest();
		test.useNameSpace();
	}

}
