package com.madhusudhan.jsi.domain;


public class EncryptedTrade implements ITrade{

	private String encryptedMsg = null;

	public EncryptedTrade(String encryptedMsg) {
		this.encryptedMsg = encryptedMsg;
	}

	public String getEncryptedMsg() {
		return encryptedMsg;
	}

	public void setEncryptedMsg(String encryptedMsg) {
		this.encryptedMsg = encryptedMsg;
	}
}
