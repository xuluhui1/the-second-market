package com.second_hand.dao;

import java.util.List;

import com.second_hand.model.Goodsqg;
import com.second_hand.wrapperClass.MySoldGoodsFList;

public abstract class GoodsqgDao {
	public abstract int insertGoodsqg(Goodsqg goodsqg);//增
	public abstract int removeGoodsqgById(int id);//删
	public abstract int updateGoodsqg(Goodsqg goodsqg);//改
	public abstract List<Goodsqg> selectGoodsqg();//查
	public abstract Goodsqg selectGoodsqgById(int id);
	public abstract List<MySoldGoodsFList> selectGoodsqgDiffer(String statu);//显示不同状态下的商品
	public abstract int updateFStatusDiffer(int goodsqgid,String A);//商品状态的各种转换
	
}
