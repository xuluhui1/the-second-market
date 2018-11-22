package com.second_hand.wrapperClass;

public class MySoldGoodsFList {
	private String pubdate;//交易时间
	private int goodszrid;//转让商品ID
	private int goodsqgid;//求购商品ID
	private String goodsname;//商品名字
	private double price;//出售商品价格
	private double orig;
	private String goodsmsg;//商品描述
	private String phone;//手机
	private String qq;//qq
	private String goodspic;
	private String sellername;//出售人
	private String classname;
	private int sellerid;
	private int buyerid;//收货人ID
	private String buyername;//购买人人
	private String address;//收货或者交易地址
	private String ordnumber;//订单编号
	private String statu;//商品状态(-1审核失败,0等待审核,1审核通过，未被购买2购买，未发货3发货，未收到4收到货物)
	public String getPubdate() {
		return pubdate;
	}
	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}
	public int getGoodszrid() {
		return goodszrid;
	}
	public void setGoodszrid(int goodszrid) {
		this.goodszrid = goodszrid;
	}
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getSellername() {
		return sellername;
	}
	public void setSellername(String sellername) {
		this.sellername = sellername;
	}
	public int getBuyerid() {
		return buyerid;
	}
	public void setBuyerid(int buyerid) {
		this.buyerid = buyerid;
	}
	public int getSellerid() {
		return sellerid;
	}
	public void setSellerid(int sellerid) {
		this.sellerid = sellerid;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public String getBuyername() {
		return buyername;
	}
	public void setBuyername(String buyername) {
		this.buyername = buyername;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	
	public String getGoodspic() {
		return goodspic;
	}
	public void setGoodspic(String goodspic) {
		this.goodspic = goodspic;
	}
	public double getOrig() {
		return orig;
	}
	public void setOrig(double orig) {
		this.orig = orig;
	}
}
