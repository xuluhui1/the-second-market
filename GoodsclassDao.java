package com.second_hand.dao;

import java.util.List;

import com.second_hand.model.Goodsclass;

public abstract class GoodsclassDao {
	public abstract int insertGoodsclass(Goodsclass goodsclass);//增
	public abstract int removeGoodsclassById(int id);//删
	public abstract int updateGoodsclass(Goodsclass goodsclass);//改
	public abstract List<Goodsclass> selectGoodsclass();//查
	public abstract Goodsclass selectGoodsclassById(int id);
}
