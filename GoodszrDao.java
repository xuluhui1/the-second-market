package com.second_hand.dao;

import java.util.List;

import com.second_hand.model.Goodszr;
import com.second_hand.wrapperClass.MySoldGoodsFList;



public interface GoodszrDao {
	public abstract int insertGoodszr(Goodszr goodszr);//增
	public abstract int removeGoodszrById(int id);//删
	public abstract int updateGoodszr(Goodszr goodszr);//改
	public abstract List<Goodszr> selectGoodszr();//查
	public abstract Goodszr selectGoodszrById(int id);
	public abstract List<MySoldGoodsFList> selectGoodszr_1();//输出未过审核的商品
	public abstract int updateFStatus_10(int goodszrid);//等待过审核——>未通过审核
	public abstract List<MySoldGoodsFList> selectGoodszr0();//输出等待审核的商品
	public abstract int updateFStatus01(int goodszrid);//等待过审核——>上架
	public abstract List<MySoldGoodsFList> selectGoodszr1();//输出上架的商品
	public abstract int updateFStatus12(int goodszrid);//上架——>有人购买，未发货
	public abstract List<MySoldGoodsFList> selectGoodszr2();//输出有人购买，未发货的商品
	public abstract int updateFStatus23(int goodszrid);//有人购买，未发货——>已发货，未到货
	public abstract List<MySoldGoodsFList> selectGoodszr3();//输出已发货，未到货的商品
	public abstract int updateFStatus34(int goodszrid);//未到货——>订单完成
	public abstract List<MySoldGoodsFList> selectGoodszr4();//输出订单完成的商品
}
