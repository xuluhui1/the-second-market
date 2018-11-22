package com.second_hand.dao;

import java.util.List;

import com.second_hand.model.School;

public abstract class SchoolDao {
	public abstract int insertSchool(School school);//增
	public abstract int removeSchoolById(int id);//删
	public abstract int updateSchool(School school);//改
	public abstract List<School> selectSchool();//查
	public abstract School selectSchoolById(int id);
}
