package com.TCWL.system.entities;

/**
 * Permiss entity. @author MyEclipse Persistence Tools
 */

public class Permiss implements java.io.Serializable {

	// Fields

	private Integer permissId;
	private String permissName;

	// Constructors

	/** default constructor */
	public Permiss() {
	}

	/** full constructor */
	public Permiss(String permissName) {
		this.permissName = permissName;
	}

	// Property accessors

	public Integer getPermissId() {
		return this.permissId;
	}

	public void setPermissId(Integer permissId) {
		this.permissId = permissId;
	}

	public String getPermissName() {
		return this.permissName;
	}

	public void setPermissName(String permissName) {
		this.permissName = permissName;
	}

}