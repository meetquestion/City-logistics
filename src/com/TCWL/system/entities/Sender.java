package com.TCWL.system.entities;

import java.util.HashSet;
import java.util.Set;

/**
 * Sender entity. @author MyEclipse Persistence Tools
 */

public class Sender implements java.io.Serializable {

	// Fields

	private Integer senderId;
	private Servicecompany servicecompany;
	private String senderName;
	private String senderPhone;
	private String senderStatus;
	private Set ordersends = new HashSet(0);

	// Constructors

	/** default constructor */
	public Sender() {
	}

	/** full constructor */
	public Sender(Servicecompany servicecompany, String senderName,
			String senderPhone, String senderStatus, Set ordersends) {
		this.servicecompany = servicecompany;
		this.senderName = senderName;
		this.senderPhone = senderPhone;
		this.senderStatus = senderStatus;
		this.ordersends = ordersends;
	}

	// Property accessors

	public Integer getSenderId() {
		return this.senderId;
	}

	public void setSenderId(Integer senderId) {
		this.senderId = senderId;
	}

	public Servicecompany getServicecompany() {
		return this.servicecompany;
	}

	public void setServicecompany(Servicecompany servicecompany) {
		this.servicecompany = servicecompany;
	}

	public String getSenderName() {
		return this.senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getSenderPhone() {
		return this.senderPhone;
	}

	public void setSenderPhone(String senderPhone) {
		this.senderPhone = senderPhone;
	}

	public String getSenderStatus() {
		return this.senderStatus;
	}

	public void setSenderStatus(String senderStatus) {
		this.senderStatus = senderStatus;
	}

	public Set getOrdersends() {
		return this.ordersends;
	}

	public void setOrdersends(Set ordersends) {
		this.ordersends = ordersends;
	}

}