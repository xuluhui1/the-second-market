package com.second_hand.model;

public class Goodsqg {
	private int goodsqgid;//求购商品ID
	private String goodsname;//商品名字
	private String goodsmsg;//商品简介
	private String address;//收货或者交易地址
	private double price;//出售商品价格
	private String phone;//联系号码
	private String qq;//联系qq
	private String pubdate;//交易时间
	private int sellerid;//出售人的ID
	private int buyerid;//购买人的ID
	private int classid;//商品类型的ID
	private String ordnumber;//订单编号
	private String statu;//商品状态(-1审核失败,0等待审核,1审核通过，未被购买2购买，未发货3发货，未收到4收到货物)
	public int getGoodsqgid() {
		return goodsqgid;
	}
	public void setGoodsqgid(int goodsqgid) {
		this.goodsqgid = goodsqgid;
	}
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public String getGoodsmsg() {
		return goodsmsg;
	}
	public void setGoodsmsg(String goodsmsg) {
		this.goodsmsg = goodsmsg;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getPubdate() {
		return pubdate;
	}
	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}
	public int getSellerid() {
		return sellerid;
	}
	public void setSellerid(int sellerid) {
		this.sellerid = sellerid;
	}
	
	public int getBuyerid() {
		return buyerid;
	}
	public void setBuyerid(int buyerid) {
		this.buyerid = buyerid;
	}
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}
	
	public String getOrdnumber() {
		return ordnumber;
	}
	public void setOrdnumber(String ordnumber) {
		this.ordnumber = ordnumber;
	}
	
	public String getStatu() {
		return statu;
	}
	public void setStatu(String statu) {
		this.statu = statu;
	}
}
