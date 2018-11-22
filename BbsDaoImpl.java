package com.second_hand.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.second_hand.dao.BbsDao;
import com.second_hand.model.Bbs;
import com.second_hand.util.JDBCUtil;

public class BbsDaoImpl extends BbsDao{
	   public Connection conn=null;
	    private PreparedStatement ps;
	    private ResultSet rs;
	@Override
	public int insertBbs(Bbs bbs) {
		// TODO Auto-generated method stub
		    int count=0;
				//1sql
				String sql="insert into bbs(senddate,senderid,receiverid,goodsid,message) values(?,?,?,?,?)";
				//2打开链接
				conn=JDBCUtil.getConnection();
				//3创建执行命令对象
				try {
					ps=conn.prepareStatement(sql);
					ps.setString(1,bbs.getSenddate());
					ps.setInt(2, Integer.parseInt(bbs.getSenderid()));
					ps.setInt(3, Integer.parseInt(bbs.getReceiverid()));
					ps.setInt(4, Integer.parseInt(bbs.getGoodsid()));
					ps.setString(5, bbs.getMessage());
					//4执行命令对象
					count=ps.executeUpdate(); 
				 
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return count;
	}

	@Override
	public int removeBbsById(int id) {
		// TODO Auto-generated method stub
		int count=0;
		String sql="delete from  bbs where bbsid=?";
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
	public int updateBbs(Bbs bbs) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Bbs> selectBbs() {
			List<Bbs> list= new ArrayList<Bbs>();
			Bbs resultBbs =null;
			//1sql
			String sql="select bbsid,senddate,senderid,receiverid,goodsid,message from bbs";
			//2打开链接
			conn=JDBCUtil.getConnection();
			//3创建执行命令对象
			try {
				ps=conn.prepareStatement(sql);
				
				//4执行命令对象
				rs=ps.executeQuery(); 
				//5结果集
				while(rs.next()){
					resultBbs= new Bbs();
					resultBbs.setId(rs.getInt("bbsid"));
					resultBbs.setBbsid(String.valueOf(rs.getInt("bbsid")));
					resultBbs.setSenddate(rs.getString("senddate"));
					resultBbs.setSenderid(String.valueOf(rs.getInt("senderid")));
					resultBbs.setReceiverid(String.valueOf(rs.getInt("receiverid")));
					resultBbs.setGoodsid(String.valueOf(rs.getInt("goodsid")));
					resultBbs.setMessage(rs.getString("message"));
					list.add(resultBbs);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
	}

	@Override
	public Bbs selectBbsById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
