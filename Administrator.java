package com.second_hand.model;

public class Administrator {
	private int auserid;//管理员编号
	private String ausername;//管理员用户名
	private String apassword;//管理员密码
	
	public int auserid() {
		return auserid;
	}
	
	public void setAuserid(int auserid) {
		this.auserid=auserid;
	}
	
	public String getAusername() {
		return ausername;
	}
	
	public void setAusername(String ausername) {
		this.ausername=ausername;
	}
	
	public String getApassword() {
		return apassword;
	}
	
	public void setApassword(String apassword) {
		this.apassword=apassword;
	}
}
