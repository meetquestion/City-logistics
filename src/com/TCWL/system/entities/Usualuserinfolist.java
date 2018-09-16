package com.TCWL.system.entities;

/**
 * Usualuserinfolist entity. @author MyEclipse Persistence Tools
 */

public class Usualuserinfolist implements java.io.Serializable {

	// Fields

	private Integer userId;
	private Userloginlist userloginlist;
	private String usualName;
	private String usualPhone;
	private String usualEmail;

	// Constructors

	/** default constructor */
	public Usualuserinfolist() {
	}

	/** minimal constructor */
	public Usualuserinfolist(Integer userId, Userloginlist userloginlist) {
		this.userId = userId;
		this.userloginlist = userloginlist;
	}

	/** full constructor */
	public Usualuserinfolist(Integer userId, Userloginlist userloginlist,
			String usualName, String usualPhone, String usualEmail) {
		this.userId = userId;
		this.userloginlist = userloginlist;
		this.usualName = usualName;
		this.usualPhone = usualPhone;
		this.usualEmail = usualEmail;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Userloginlist getUserloginlist() {
		return this.userloginlist;
	}

	public void setUserloginlist(Userloginlist userloginlist) {
		this.userloginlist = userloginlist;
	}

	public String getUsualName() {
		return this.usualName;
	}

	public void setUsualName(String usualName) {
		this.usualName = usualName;
	}

	public String getUsualPhone() {
		return this.usualPhone;
	}

	public void setUsualPhone(String usualPhone) {
		this.usualPhone = usualPhone;
	}

	public String getUsualEmail() {
		return this.usualEmail;
	}

	public void setUsualEmail(String usualEmail) {
		this.usualEmail = usualEmail;
	}

}