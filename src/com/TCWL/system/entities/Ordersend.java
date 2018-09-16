package com.TCWL.system.entities;

import java.sql.Timestamp;

/**
 * Ordersend entity. @author MyEclipse Persistence Tools
 */

public class Ordersend implements java.io.Serializable {

	// Fields

	private String orderId;
	private Servicecompany servicecompany;
	private Sender sender;
	private Userloginlist userloginlist;
	private Geter geter;
	private String orderType;
	private String orderDescribe;
	private String orderSize;
	private Timestamp orderSendDate;
	private Timestamp orderGetDate;
	private String orderStatus;

	// Constructors

	/** default constructor */
	public Ordersend() {
	}

	/** minimal constructor */
	public Ordersend(String orderId) {
		this.orderId = orderId;
	}

	/** full constructor */
	public Ordersend(String orderId, Servicecompany servicecompany,
			Sender sender, Userloginlist userloginlist, Geter geter,
			String orderType, String orderDescribe, String orderSize,
			Timestamp orderSendDate, Timestamp orderGetDate, String orderStatus) {
		this.orderId = orderId;
		this.servicecompany = servicecompany;
		this.sender = sender;
		this.userloginlist = userloginlist;
		this.geter = geter;
		this.orderType = orderType;
		this.orderDescribe = orderDescribe;
		this.orderSize = orderSize;
		this.orderSendDate = orderSendDate;
		this.orderGetDate = orderGetDate;
		this.orderStatus = orderStatus;
	}

	// Property accessors

	public String getOrderId() {
		return this.orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Servicecompany getServicecompany() {
		return this.servicecompany;
	}

	public void setServicecompany(Servicecompany servicecompany) {
		this.servicecompany = servicecompany;
	}

	public Sender getSender() {
		return this.sender;
	}

	public void setSender(Sender sender) {
		this.sender = sender;
	}

	public Userloginlist getUserloginlist() {
		return this.userloginlist;
	}

	public void setUserloginlist(Userloginlist userloginlist) {
		this.userloginlist = userloginlist;
	}

	public Geter getGeter() {
		return this.geter;
	}

	public void setGeter(Geter geter) {
		this.geter = geter;
	}

	public String getOrderType() {
		return this.orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getOrderDescribe() {
		return this.orderDescribe;
	}

	public void setOrderDescribe(String orderDescribe) {
		this.orderDescribe = orderDescribe;
	}

	public String getOrderSize() {
		return this.orderSize;
	}

	public void setOrderSize(String orderSize) {
		this.orderSize = orderSize;
	}

	public Timestamp getOrderSendDate() {
		return this.orderSendDate;
	}

	public void setOrderSendDate(Timestamp orderSendDate) {
		this.orderSendDate = orderSendDate;
	}

	public Timestamp getOrderGetDate() {
		return this.orderGetDate;
	}

	public void setOrderGetDate(Timestamp orderGetDate) {
		this.orderGetDate = orderGetDate;
	}

	public String getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "Ordersend [orderId=" + orderId + ", servicecompany="
				+ servicecompany + ", sender=" + sender + ", userloginlist="
				+ userloginlist + ", geter=" + geter + ", orderType="
				+ orderType + ", orderDescribe=" + orderDescribe
				+ ", orderSize=" + orderSize + ", orderSendDate="
				+ orderSendDate + ", orderGetDate=" + orderGetDate
				+ ", orderStatus=" + orderStatus + "]";
	}

	
}