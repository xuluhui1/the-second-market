package com.second_hand.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.second_hand.model.User;
import com.second_hand.util.JDBCUtil;

public class UserDaoDemo {
	public Connection conn=null;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public List<User> selectUserList(){
		List<User> list=new ArrayList<User>();
		User resultUser=null;
		String sql="select userid,nickname,password from user";
		conn=JDBCUtil.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				resultUser=new User();
				resultUser.setUserid(rs.getInt("userid"));
				resultUser.setNickname(rs.getString("nickname"));
				resultUser.setPassword(rs.getString("password"));
				list.add(resultUser);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
