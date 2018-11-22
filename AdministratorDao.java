package com.second_hand.dao;

import java.util.List;

import com.second_hand.model.Administrator;

public abstract class AdministratorDao {
	public abstract int insertAdministrator(Administrator administrator);//增
	public abstract int removeAdministratorById(int id);//删
	public abstract int updateAdministrator(Administrator administrator);//改
	public abstract List<Administrator> selectAdministrator();//查
	public abstract Administrator selectAdministratorById(int id);
	public abstract Administrator login(Administrator admin);
}
