package com.TCWL.system.entities;

/**
 * Judge entity. @author MyEclipse Persistence Tools
 */

public class Judge implements java.io.Serializable {

	// Fields

	private Integer judgeId;
	private Ordersend ordersend;
	private String scNum;
	private String scCon;
	private String senderNum;
	private String senderCon;

	// Constructors

	/** default constructor */
	public Judge() {
	}

	/** full constructor */
	public Judge(Ordersend ordersend, String scNum, String scCon,
			String senderNum, String senderCon) {
		this.ordersend = ordersend;
		this.scNum = scNum;
		this.scCon = scCon;
		this.senderNum = senderNum;
		this.senderCon = senderCon;
	}

	// Property accessors

	public Integer getJudgeId() {
		return this.judgeId;
	}

	public void setJudgeId(Integer judgeId) {
		this.judgeId = judgeId;
	}

	public Ordersend getOrdersend() {
		return this.ordersend;
	}

	public void setOrdersend(Ordersend ordersend) {
		this.ordersend = ordersend;
	}

	public String getScNum() {
		return this.scNum;
	}

	public void setScNum(String scNum) {
		this.scNum = scNum;
	}

	public String getScCon() {
		return this.scCon;
	}

	public void setScCon(String scCon) {
		this.scCon = scCon;
	}

	public String getSenderNum() {
		return this.senderNum;
	}

	public void setSenderNum(String senderNum) {
		this.senderNum = senderNum;
	}

	public String getSenderCon() {
		return this.senderCon;
	}

	public void setSenderCon(String senderCon) {
		this.senderCon = senderCon;
	}

	@Override
	public String toString() {
		return "Judge [judgeId=" + judgeId + ", ordersend=" + ordersend
				+ ", scNum=" + scNum + ", scCon=" + scCon + ", senderNum="
				+ senderNum + ", senderCon=" + senderCon + "]";
	}
	
	

}