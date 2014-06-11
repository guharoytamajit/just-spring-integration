package com.madhusudhan.jsi.transformers.builtin;

import javax.xml.transform.Result;
import javax.xml.transform.sax.SAXResult;

import org.springframework.integration.xml.result.ResultFactory;

public class TradeResultFactory implements ResultFactory {

	
	public Result createResult(Object payload) {
	
		// do you processing here..
		System.out.println("Creating result ->"+payload);
		
		return new SAXResult();
	}

}
