package com.madhusudhan.jsi.channels;

import java.util.concurrent.Executor;

public class AccountsExecutor implements Executor{

	public void execute(Runnable r) {
		System.out.println("AccountExecutor called"+r.getClass());
	}

}
