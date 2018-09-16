package com.TCWL.system.entities;

import java.util.HashSet;
import java.util.Set;

/**
 * Userloginlist entity. @author MyEclipse Persistence Tools
 */

public class Userloginlist implements java.io.Serializable {

	// Fields

	private Integer userId;
	private String username;
	private String password;
	private String roleList;
	private String userSenderId;
	private Set ordersends = new HashSet(0);
	private Set usualuserinfolists = new HashSet(0);

	// Constructors

	/** default constructor */
	public Userloginlist() {
	}

	/** full constructor */
	public Userloginlist(String username, String password, String roleList,
			String userSenderId, Set ordersends, Set usualuserinfolists) {
		this.username = username;
		this.password = password;
		this.roleList = roleList;
		this.userSenderId = userSenderId;
		this.ordersends = ordersends;
		this.usualuserinfolists = usualuserinfolists;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoleList() {
		return this.roleList;
	}

	public void setRoleList(String roleList) {
		this.roleList = roleList;
	}

	public String getUserSenderId() {
		return this.userSenderId;
	}

	public void setUserSenderId(String userSenderId) {
		this.userSenderId = userSenderId;
	}

	public Set getOrdersends() {
		return this.ordersends;
	}

	public void setOrdersends(Set ordersends) {
		this.ordersends = ordersends;
	}

	public Set getUsualuserinfolists() {
		return this.usualuserinfolists;
	}

	public void setUsualuserinfolists(Set usualuserinfolists) {
		this.usualuserinfolists = usualuserinfolists;
	}

}