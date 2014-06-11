package com.madhusudhan.jsi.domain;

public class Position {
	private String id = null;
	private String account = null;
	private String positionType = null;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPositionType() {
		return positionType;
	}
	public void setPositionType(String positionType) {
		this.positionType = positionType;
	}
	@Override
	public String toString() {
		return "Position [id=" + id + ", account=" + account
				+ ", positionType=" + positionType + "]";
	}
	
}
