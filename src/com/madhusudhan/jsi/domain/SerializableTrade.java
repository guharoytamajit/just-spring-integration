package com.madhusudhan.jsi.domain;

import java.io.Serializable;

public class SerializableTrade implements Serializable{
	private String id = null;
	private String direction = null;
	private String account = null;
	private String security = null;
	private String status = null;
	private int quantity = 0;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getSecurity() {
		return security;
	}
	public void setSecurity(String security) {
		this.security = security;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "SerializableTrade [id=" + id + ", direction=" + direction + ", account="
				+ account + ", security=" + security + ", status=" + status
				+ "]";
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
