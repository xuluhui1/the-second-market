package com.second_hand.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.second_hand.dao.SchoolDao;
import com.second_hand.model.School;
import com.second_hand.util.JDBCUtil;
public class SchoolDaoImpl extends SchoolDao{
	public Connection conn=null;
	private PreparedStatement ps;
	private ResultSet rs;

	@Override
	public int insertSchool(School school) {
		// TODO Auto-generated method stub
		int count=0;
		//1sql
		String sql="insert into school(schoolname) values(?)";
		//2打开连接
		conn=JDBCUtil.getConnection();
		//3创建执行命令对象
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1,school.getSchoolname());
			//4执行命令对象
			count=ps.executeUpdate(); 
		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int removeSchoolById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateSchool(School school) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<School> selectSchool() {
		// TODO Auto-generated method stub
		List<School> list= new ArrayList<School>();
		School resultSchool =null;
		//1sql
		String sql="select schoolid,schoolname from school";
		//2打开链接
		conn=JDBCUtil.getConnection();
		//3创建执行命令对象
		try {
			ps=conn.prepareStatement(sql);
			
			//4执行命令对象
			rs=ps.executeQuery(); 
			//5结果集
			while(rs.next()){
				resultSchool= new School();
				resultSchool.setSchoolid(rs.getInt("schoolid"));
				resultSchool.setSchoolname(rs.getString("schoolname"));
				list.add(resultSchool);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public School selectSchoolById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
