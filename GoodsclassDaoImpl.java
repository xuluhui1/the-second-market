package com.second_hand.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.second_hand.dao.GoodsclassDao;
import com.second_hand.model.Goodsclass;
import com.second_hand.util.JDBCUtil;

public class GoodsclassDaoImpl extends GoodsclassDao{

	public Connection conn=null;
	private PreparedStatement ps;
	private ResultSet rs;
	@Override
	public int insertGoodsclass(Goodsclass goodsclass) {
		int count=0;
		String sql="insert into goodsclass(classname) values(?)";
		conn=JDBCUtil.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, goodsclass.getClassname());
			count=ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int removeGoodsclassById(int id) {
		// TODO Auto-generated method stub
		int count=0;
		String sql="delete from  goodsclass where classid=?";
		conn=JDBCUtil.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1,id);
			count=ps.executeUpdate(); 
		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int updateGoodsclass(Goodsclass goodsclass) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Goodsclass> selectGoodsclass() {
		List<Goodsclass> list=new ArrayList<Goodsclass>();
		String sql="select classid,classname from goodsclass";
		Goodsclass resultclass=null;
		conn=JDBCUtil.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				resultclass=new Goodsclass();
				resultclass.setClassid(rs.getInt("classid"));
				resultclass.setClassname(rs.getString("classname"));
				list.add(resultclass);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Goodsclass selectGoodsclassById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
