package com.second_hand.dao;

import java.util.List;

import com.second_hand.model.Depart;

public abstract class DepartDao {
	public abstract int insertDepart(Depart depart);//增
	public abstract int removeDepartById(int id);//删
	public abstract int updateDepart(Depart depart);//改
	public abstract List<Depart> selectDepart();//查
	public abstract Depart selectDepartById(int id);
}
