package com.TCWL.system.entities;

import java.util.HashSet;
import java.util.Set;

/**
 * Geter entity. @author MyEclipse Persistence Tools
 */

public class Geter implements java.io.Serializable {

	// Fields

	private Integer geterId;
	private String geterName;
	private String geterPhone;
	private String geterAddress;
	private String geterSenderId;
	private String geterStatus;
	private Set ordersends = new HashSet(0);

	// Constructors

	/** default constructor */
	public Geter() {
	}

	/** full constructor */
	public Geter(String geterName, String geterPhone, String geterAddress,
			String geterSenderId, String geterStatus, Set ordersends) {
		this.geterName = geterName;
		this.geterPhone = geterPhone;
		this.geterAddress = geterAddress;
		this.geterSenderId = geterSenderId;
		this.geterStatus = geterStatus;
		this.ordersends = ordersends;
	}

	// Property accessors

	public Integer getGeterId() {
		return this.geterId;
	}

	public void setGeterId(Integer geterId) {
		this.geterId = geterId;
	}

	public String getGeterName() {
		return this.geterName;
	}

	public void setGeterName(String geterName) {
		this.geterName = geterName;
	}

	public String getGeterPhone() {
		return this.geterPhone;
	}

	public void setGeterPhone(String geterPhone) {
		this.geterPhone = geterPhone;
	}

	public String getGeterAddress() {
		return this.geterAddress;
	}

	public void setGeterAddress(String geterAddress) {
		this.geterAddress = geterAddress;
	}

	public String getGeterSenderId() {
		return this.geterSenderId;
	}

	public void setGeterSenderId(String geterSenderId) {
		this.geterSenderId = geterSenderId;
	}

	public String getGeterStatus() {
		return this.geterStatus;
	}

	public void setGeterStatus(String geterStatus) {
		this.geterStatus = geterStatus;
	}

	public Set getOrdersends() {
		return this.ordersends;
	}

	public void setOrdersends(Set ordersends) {
		this.ordersends = ordersends;
	}

}