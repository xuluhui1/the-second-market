package com.second_hand.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.second_hand.dao.GoodszrDao;
import com.second_hand.model.Goodszr;
import com.second_hand.util.JDBCUtil;
import com.second_hand.wrapperClass.MySoldGoodsFList;

public class GoodszrDaoImpl implements GoodszrDao{
	public Connection conn=null;
	private PreparedStatement ps;
	private ResultSet rs;

	public int insertGoodszr(Goodszr goodszr) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int removeGoodszrById(int goodszrid) {
		int count=0;
		String sql="delete from goodszr where goodszrid=?";
		conn=JDBCUtil.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, goodszrid);
			
			count=ps.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return count;
	}

	public int updateGoodszr(Goodszr goodszr) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Goodszr> selectGoodszr() {
		return null;
	}

	public Goodszr selectGoodszrById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<MySoldGoodsFList> selectGoodszr_1() {
		List<MySoldGoodsFList> list=new ArrayList<MySoldGoodsFList>();
		MySoldGoodsFList resultGoodszr=null;
		String sql="select pubdate,goodszrid,goodsname,price,buyerid,nickname,goodszr.address,ordnumber,statu from goodszr,user where goodszr.buyerid=user.userid and statu='-1'";
		conn=JDBCUtil.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				resultGoodszr=new MySoldGoodsFList();
				resultGoodszr.setPubdate(rs.getString("pubdate"));
				resultGoodszr.setGoodszrid(rs.getInt("goodszrid"));
				resultGoodszr.setGoodsname(rs.getString("goodsname"));
				resultGoodszr.setPrice(rs.getDouble("price"));
				resultGoodszr.setBuyerid(rs.getInt("buyerid"));
				resultGoodszr.setBuyername(rs.getString("nickname"));
				resultGoodszr.setAddress(rs.getString("address"));
				resultGoodszr.setOrdnumber(rs.getString("ordnumber"));
				resultGoodszr.setStatu(rs.getString("statu"));
				list.add(resultGoodszr);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int updateFStatus_10(int goodszrid) {
		int count=0;
		String sql="update goodszr set statu=? where goodszrid=?";
		conn=JDBCUtil.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, "-1");
			ps.setInt(2, goodszrid);
			count=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	public List<MySoldGoodsFList> selectGoodszr0() {
		List<MySoldGoodsFList> list=new ArrayList<MySoldGoodsFList>();
		MySoldGoodsFList resultGoodszr=null;
		String sql="select pubdate,goodszrid,goodsname,goodspic,goodsmsg,price,orig,sellerid,nickname,goodszr.address,ordnumber,statu,classname from goodszr,user,goodsclass where goodszr.classid=goodsclass.classid and goodszr.sellerid=user.userid and statu='0'";
		conn=JDBCUtil.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				resultGoodszr=new MySoldGoodsFList();
				resultGoodszr.setPubdate(rs.getString("pubdate"));
				resultGoodszr.setGoodspic(rs.getString("goodspic"));
				resultGoodszr.setGoodszrid(rs.getInt("goodszrid"));
				resultGoodszr.setGoodsmsg(rs.getString("goodsmsg"));
				resultGoodszr.setOrig(rs.getDouble("orig"));
				resultGoodszr.setGoodsname(rs.getString("goodsname"));
				resultGoodszr.setPrice(rs.getDouble("price"));
				resultGoodszr.setSellerid(rs.getInt("sellerid"));
				resultGoodszr.setBuyername(rs.getString("nickname"));
				resultGoodszr.setAddress(rs.getString("address"));
				resultGoodszr.setOrdnumber(rs.getString("ordnumber"));
				resultGoodszr.setStatu(rs.getString("statu"));
				resultGoodszr.setClassname(rs.getString("classname"));
				list.add(resultGoodszr);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int updateFStatus01(int goodszrid) {
		int count=0;
		String sql="update goodszr set statu=? where goodszrid=?";
		conn=JDBCUtil.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, "1");
			ps.setInt(2, goodszrid);
			count=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	public List<MySoldGoodsFList> selectGoodszr1() {
		List<MySoldGoodsFList> list=new ArrayList<MySoldGoodsFList>();
		MySoldGoodsFList resultGoodszr=null;
		String sql="select pubdate,goodszrid,goodsname,price,buyerid,nickname,goodszr.address,ordnumber,statu from goodszr,user where goodszr.buyerid=user.userid and statu='1'";
		conn=JDBCUtil.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				resultGoodszr=new MySoldGoodsFList();
				resultGoodszr.setPubdate(rs.getString("pubdate"));
				resultGoodszr.setGoodszrid(rs.getInt("goodszrid"));
				resultGoodszr.setGoodsname(rs.getString("goodsname"));
				resultGoodszr.setPrice(rs.getDouble("price"));
				resultGoodszr.setBuyerid(rs.getInt("buyerid"));
				resultGoodszr.setBuyername(rs.getString("nickname"));
				resultGoodszr.setAddress(rs.getString("address"));
				resultGoodszr.setOrdnumber(rs.getString("ordnumber"));
				resultGoodszr.setStatu(rs.getString("statu"));
				list.add(resultGoodszr);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int updateFStatus12(int goodszrid) {
		int count=0;
		String sql="update goodszr set statu=? where goodszrid=?";
		conn=JDBCUtil.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, "2");
			ps.setInt(2, goodszrid);
			count=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	public List<MySoldGoodsFList> selectGoodszr2() {
		List<MySoldGoodsFList> list=new ArrayList<MySoldGoodsFList>();
		MySoldGoodsFList resultGoodszr=null;
		String sql="select pubdate,goodszrid,goodsname,price,buyerid,nickname,goodszr.address,ordnumber,statu from goodszr,user where goodszr.buyerid=user.userid and statu='2'";
		conn=JDBCUtil.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				resultGoodszr=new MySoldGoodsFList();
				resultGoodszr.setPubdate(rs.getString("pubdate"));
				resultGoodszr.setGoodszrid(rs.getInt("goodszrid"));
				resultGoodszr.setGoodsname(rs.getString("goodsname"));
				resultGoodszr.setPrice(rs.getDouble("price"));
				resultGoodszr.setBuyerid(rs.getInt("buyerid"));
				resultGoodszr.setBuyername(rs.getString("nickname"));
				resultGoodszr.setAddress(rs.getString("address"));
				resultGoodszr.setOrdnumber(rs.getString("ordnumber"));
				resultGoodszr.setStatu(rs.getString("statu"));
				list.add(resultGoodszr);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int updateFStatus23(int goodszrid) {
		int count=0;
		String sql="update goodszr set statu=? where goodszrid=?";
		conn=JDBCUtil.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, "3");
			ps.setInt(2, goodszrid);
			count=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	public List<MySoldGoodsFList> selectGoodszr3() {
		List<MySoldGoodsFList> list=new ArrayList<MySoldGoodsFList>();
		MySoldGoodsFList resultGoodszr=null;
		String sql="select pubdate,goodszrid,goodsname,price,buyerid,nickname,goodszr.address,ordnumber,statu from goodszr,user where goodszr.buyerid=user.userid and statu='3'";
		conn=JDBCUtil.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				resultGoodszr=new MySoldGoodsFList();
				resultGoodszr.setPubdate(rs.getString("pubdate"));
				resultGoodszr.setGoodszrid(rs.getInt("goodszrid"));
				resultGoodszr.setGoodsname(rs.getString("goodsname"));
				resultGoodszr.setPrice(rs.getDouble("price"));
				resultGoodszr.setBuyerid(rs.getInt("buyerid"));
				resultGoodszr.setBuyername(rs.getString("nickname"));
				resultGoodszr.setAddress(rs.getString("address"));
				resultGoodszr.setOrdnumber(rs.getString("ordnumber"));
				resultGoodszr.setStatu(rs.getString("statu"));
				list.add(resultGoodszr);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int updateFStatus34(int goodszrid) {
		int count=0;
		String sql="update goodszr set statu=? where goodszrid=?";
		conn=JDBCUtil.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, "4");
			ps.setInt(2, goodszrid);
			count=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	public List<MySoldGoodsFList> selectGoodszr4() {
		List<MySoldGoodsFList> list=new ArrayList<MySoldGoodsFList>();
		MySoldGoodsFList resultGoodszr=null;
		String sql="select pubdate,goodszrid,goodsname,price,buyerid,nickname,goodszr.address,ordnumber,statu from goodszr,user where goodszr.buyerid=user.userid and statu='4'";
		conn=JDBCUtil.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				resultGoodszr=new MySoldGoodsFList();
				resultGoodszr.setPubdate(rs.getString("pubdate"));
				resultGoodszr.setGoodszrid(rs.getInt("goodszrid"));
				resultGoodszr.setGoodsname(rs.getString("goodsname"));
				resultGoodszr.setPrice(rs.getDouble("price"));
				resultGoodszr.setBuyerid(rs.getInt("buyerid"));
				resultGoodszr.setBuyername(rs.getString("nickname"));
				resultGoodszr.setAddress(rs.getString("address"));
				resultGoodszr.setOrdnumber(rs.getString("ordnumber"));
				resultGoodszr.setStatu(rs.getString("statu"));
				list.add(resultGoodszr);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
