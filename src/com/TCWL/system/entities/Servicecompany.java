package com.TCWL.system.entities;

import java.util.HashSet;
import java.util.Set;

/**
 * Servicecompany entity. @author MyEclipse Persistence Tools
 */

public class Servicecompany implements java.io.Serializable {

	// Fields

	private Integer scId;
	private String scName;
	private String scNum;
	private Set senders = new HashSet(0);
	private Set ordersends = new HashSet(0);

	// Constructors

	/** default constructor */
	public Servicecompany() {
	}

	/** full constructor */
	public Servicecompany(String scName, String scNum, Set senders,
			Set ordersends) {
		this.scName = scName;
		this.scNum = scNum;
		this.senders = senders;
		this.ordersends = ordersends;
	}

	// Property accessors

	public Integer getScId() {
		return this.scId;
	}

	public void setScId(Integer scId) {
		this.scId = scId;
	}

	public String getScName() {
		return this.scName;
	}

	public void setScName(String scName) {
		this.scName = scName;
	}

	public String getScNum() {
		return this.scNum;
	}

	public void setScNum(String scNum) {
		this.scNum = scNum;
	}

	public Set getSenders() {
		return this.senders;
	}

	public void setSenders(Set senders) {
		this.senders = senders;
	}

	public Set getOrdersends() {
		return this.ordersends;
	}

	public void setOrdersends(Set ordersends) {
		this.ordersends = ordersends;
	}

}