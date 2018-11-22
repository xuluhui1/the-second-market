package com.second_hand.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.second_hand.dao.DepartDao;
import com.second_hand.model.Depart;
import com.second_hand.util.JDBCUtil;


public class DepartDaoImpl extends DepartDao{
	public Connection conn=null;
	private PreparedStatement ps;
	private ResultSet rs;

	@Override
	public int insertDepart(Depart depart) {
		// TODO Auto-generated method stub
		int count=0;
		//1sql
		String sql="insert into depart(departname) values(?)";
		//2打开连接
		conn=JDBCUtil.getConnection();
		//3创建执行命令对象
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1,depart.getDepartname());
			//4执行命令对象
			count=ps.executeUpdate(); 
		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;

	}

	@Override
	public int removeDepartById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateDepart(Depart depart) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Depart> selectDepart() {
		// TODO Auto-generated method stub
		List<Depart> list= new ArrayList<Depart>();
		Depart resultDepart =null;
		//1sql
		String sql="select departid,departname from depart";
		//2打开链接
		conn=JDBCUtil.getConnection();
		//3创建执行命令对象
		try {
			ps=conn.prepareStatement(sql);
			
			//4执行命令对象
			rs=ps.executeQuery(); 
			//5结果集
			while(rs.next()){
				resultDepart= new Depart();
				resultDepart.setDepartid(rs.getInt("departid"));
				resultDepart.setDepartname(rs.getString("departname"));
				list.add(resultDepart);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Depart selectDepartById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
