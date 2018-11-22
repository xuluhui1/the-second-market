package com.second_hand.model;

public class User{
	private int userid;//用户编号
	private String nickname;//昵称
	private String password;//密码
	private String email;//邮箱
	private String phone;//电话
	private int schoolid;
	private int departid;//院系
	private String address;//地址
	private String photourl;//照片
	private String qq;//qq号
	private int intergal;//积分
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSchoolid() {
		return schoolid;
	}
	public void setSchoolid(int schoolid) {
		this.schoolid = schoolid;
	}
	public int getDepartid() {
		return departid;
	}
	public void setDepartid(int departid) {
		this.departid = departid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhotourl() {
		return photourl;
	}
	public void setPhotourl(String photourl) {
		this.photourl = photourl;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public int getIntergal() {
		return intergal;
	}
	public void setIntergal(int intergal) {
		this.intergal = intergal;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
