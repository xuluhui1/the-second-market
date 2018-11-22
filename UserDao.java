package com.second_hand.dao;

import java.util.List;

import com.second_hand.model.User;
import com.second_hand.wrapperClass.UserManage;

public abstract class UserDao {
	public abstract int loginUser(User user);
	public abstract int resigterUser(User user);
	public abstract int removeUserById(int id);
	public abstract List<UserManage> selectUserList();
	public abstract User selectUserListById(int id);
	public abstract int updateUser(User user);
}
