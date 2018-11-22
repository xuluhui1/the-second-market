package com.second_hand.dao;

import java.util.List;

import com.second_hand.model.Bbs;

public abstract class BbsDao {
	public abstract int insertBbs(Bbs bbs);//增
	public abstract int removeBbsById(int id);//删
	public abstract int updateBbs(Bbs bbs);//改
	public abstract List<Bbs> selectBbs();//查
	public abstract Bbs selectBbsById(int id);
}
