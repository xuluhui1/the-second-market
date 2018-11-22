package com.second_hand.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.second_hand.dao.UserDao;
import com.second_hand.model.User;
import com.second_hand.util.JDBCUtil;
import com.second_hand.wrapperClass.UserManage;
public class UserDaoImpl extends UserDao{
	public Connection conn=null;
    private PreparedStatement ps;
    private ResultSet rs;
	@Override
	public int loginUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int resigterUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeUserById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<UserManage> selectUserList() {
		// TODO Auto-generated method stub
		List<UserManage> list= new ArrayList<UserManage>();
		UserManage resultUser =null;
		//1sql
		String sql="select userid,nickname,email,phone,qq,schoolname,departname,address from user,school,depart where user.schoolid=school.schoolid and user.departid=depart.departid";
		//2打开链接
		conn=JDBCUtil.getConnection();
		//3创建执行命令对象
		try {
			ps=conn.prepareStatement(sql);
			
			//4执行命令对象
			rs=ps.executeQuery(); 
			//5结果集
			while(rs.next()){
				resultUser= new UserManage();
				resultUser.setUserid(rs.getInt("userid"));
				resultUser.setNickname(rs.getString("nickname"));
				resultUser.setEmail(rs.getString("email"));
				resultUser.setPhone(rs.getString("phone"));
				resultUser.setQq(rs.getString("qq"));
				resultUser.setSchoolname(rs.getString("schoolname"));
				resultUser.setDepartname(rs.getString("departname"));
				resultUser.setAddress(rs.getString("address"));
				list.add(resultUser);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public User selectUserListById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

}
