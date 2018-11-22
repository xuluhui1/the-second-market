package com.second_hand.model;

public class Bbs {
	private int id;
	private String bbsid;//留言信息编号
	private String senddate;//留言时间
	private String senderid;//留言者编号
	private String receiverid;//接收留言者编号
	private String goodsid;//留言商品
	private String message;//留言信息
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public String getBbsid() {
		return bbsid;
	}
	
	public void setBbsid(String bbsid) {
		this.bbsid=bbsid;
	}
	
	public String getSenddate() {
		return senddate;
	}
	public void setSenddate(String senddate) {
		this.senddate =senddate ;
	}
	
	public String getSenderid() {
		return senderid;
	}
	public void setSenderid(String senderid) {
		this.senderid =senderid ;
	}
	
	public String getReceiverid() {
		return receiverid;
	}
	public void setReceiverid(String receiverid) {
		this.receiverid =receiverid ;
	}
	
	public String getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(String goodsid) {
		this.goodsid =goodsid ;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message =message ;
	}
}
