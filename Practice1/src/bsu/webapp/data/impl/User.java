package bsu.webapp.data.impl;

import bsu.orderhandling.order.Order;


public class User extends RepositoryItemImpl{


	private String mFirstName;
	private String mLastName;
	private String mLogin;
	private String mPassword; // yes, we store open password :-(
	private Order mOrder;
	

	public String getFirstName() {
		return mFirstName;
	}
	public void setFirstName(String mFirstName) {
		this.mFirstName = mFirstName;
	}
	public String getLastName() {
		return mLastName;
	}
	public void setLastName(String mLastName) {
		this.mLastName = mLastName;
	}
	public String getLogin() {
		return mLogin;
	}
	public void setLogin(String login) {
		mLogin = login;
	}
	public String getPassword() {
		return mPassword;
	}
	public void setPassword(String password) {
		mPassword = password;
	}
	public Order getOrder() {
		return mOrder;
	}
	public void setOrder(Order order) {
		mOrder = order;
	}
	

}
