package com.second_hand.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.second_hand.dao.GoodsqgDao;
import com.second_hand.model.Goodsqg;
import com.second_hand.util.JDBCUtil;
import com.second_hand.wrapperClass.MySoldGoodsFList;

public class GoodsqgDaoImpl extends GoodsqgDao{
	public Connection conn=null;
	private PreparedStatement ps;
	private ResultSet rs;
	@Override
	public int insertGoodsqg(Goodsqg goodsqg) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeGoodsqgById(int goodsqgid) {
		int count=0;
		String sql="delete from goodsqg where goodsqgid=?";
		conn=JDBCUtil.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, goodsqgid);
			
			count=ps.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return count;
	}

	@Override
	public int updateGoodsqg(Goodsqg goodsqg) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Goodsqg> selectGoodsqg() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Goodsqg selectGoodsqgById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<MySoldGoodsFList> selectGoodsqgDiffer(String statu) {
		List<MySoldGoodsFList> list=new ArrayList<MySoldGoodsFList>();
		MySoldGoodsFList resultGoodsqg=null;
		String sql="select goodsqgid,goodsname,goodsmsg,goodsqg.address address,price,user.phone,user.qq,pubdate,sellerid,buyerid,nickname,classname,ordnumber,statu from goodsqg,user,goodsclass where goodsqg.classid=goodsclass.classid and user.userid=goodsqg.buyerid and statu=?";
		conn=JDBCUtil.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, statu);
			rs=ps.executeQuery();
			while(rs.next()) {
				resultGoodsqg=new MySoldGoodsFList();
				resultGoodsqg.setGoodszrid(rs.getInt("goodsqgid"));
				resultGoodsqg.setGoodsname(rs.getString("goodsname"));
				resultGoodsqg.setGoodsmsg(rs.getString("goodsmsg"));
				resultGoodsqg.setAddress(rs.getString("address"));
				resultGoodsqg.setPrice(rs.getDouble("price"));
				resultGoodsqg.setPhone(rs.getString("phone"));
				resultGoodsqg.setQq(rs.getString("qq"));
				resultGoodsqg.setPubdate(rs.getString("pubdate"));
				resultGoodsqg.setSellerid(rs.getInt("sellerid"));
				resultGoodsqg.setBuyerid(rs.getInt("buyerid"));
				resultGoodsqg.setBuyername(rs.getString("nickname"));
				resultGoodsqg.setClassname(rs.getString("classname"));
				resultGoodsqg.setOrdnumber(rs.getString("ordnumber"));
				resultGoodsqg.setStatu(rs.getString("statu"));
				list.add(resultGoodsqg);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int updateFStatusDiffer(int goodsqgid,String A) {
		int count=0;
		String sql="update goodsqg set statu=? where goodszrqg=?";
		conn=JDBCUtil.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, A);
			ps.setInt(2, goodsqgid);
			count=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
}
