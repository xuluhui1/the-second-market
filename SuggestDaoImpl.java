package com.second_hand.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.second_hand.dao.SuggestionDao;
import com.second_hand.model.Suggestion;
import com.second_hand.util.JDBCUtil;

public class SuggestDaoImpl extends SuggestionDao{
	public Connection conn=null;
    private PreparedStatement ps;
    private ResultSet rs;
	public int insertSuggestion(Suggestion suggestion) {
		// TODO Auto-generated method stub
		int count=0;
		//1sql
		String sql="insert into suggestion(talktime,senderid,receiverid,suggestioncontent) values(?,?,?,?)";
		//2打开链接
		conn=JDBCUtil.getConnection();
		//3创建执行命令对象
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1,suggestion.getTalktime());
			ps.setInt(2, Integer.parseInt(suggestion.getSenderid()));
			ps.setInt(3, Integer.parseInt(suggestion.getReceiverid()));
			 ps.setString(4, suggestion.getSuggestioncontent());
			//4执行命令对象
			count=ps.executeUpdate(); 
		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	public int removeSuggestionById(int id) {
		// TODO Auto-generated method stub
		int count=0;
		String sql="delete from  suggestion where suggestionid=?";
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


	public int updateSUggestion(Suggestion suggestion) {
		// TODO Auto-generated method stub
		return 0;
	}


	public List<Suggestion> selectSuggestion() {
		// TODO Auto-generated method stub
		List<Suggestion> list= new ArrayList<Suggestion>();
		Suggestion resultSuggestion =null;
		//1sql
		String sql="select suggestionid,talktime,senderid,receiverid,suggestioncontent,suggestionstatus from suggestion";
		//2打开链接
		conn=JDBCUtil.getConnection();
		//3创建执行命令对象
		try {
			ps=conn.prepareStatement(sql);
			
			//4执行命令对象
			rs=ps.executeQuery(); 
			//5结果集
			while(rs.next()){
				resultSuggestion= new Suggestion();
				resultSuggestion.setId(rs.getInt("suggestionid"));
				resultSuggestion.setSuggestionid(String.valueOf(rs.getInt("suggestionid")));
				resultSuggestion.setTalktime(rs.getString("talktime"));
				resultSuggestion.setSenderid(String.valueOf(rs.getInt("senderid")));
				resultSuggestion.setSid(rs.getInt("senderid"));
				resultSuggestion.setReceiverid(String.valueOf(rs.getInt("receiverid")));
				resultSuggestion.setSuggestioncontent(rs.getString("suggestioncontent"));
				resultSuggestion.setSuggestionstatus(rs.getInt("suggestionstatus"));
				list.add(resultSuggestion);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public int insertASuggestion(Suggestion suggestion) {
		// TODO Auto-generated method stub
		int count=0;
		//1sql
		String sql="insert into suggestion(talktime,senderid,receiverid,suggestioncontent,suggestionstatus) values(?,?,?,?,?)";
		//2打开链接
		conn=JDBCUtil.getConnection();
		//3创建执行命令对象
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1,suggestion.getTalktime());
			ps.setInt(2, Integer.parseInt(suggestion.getSenderid()));
			ps.setInt(3, Integer.parseInt(suggestion.getReceiverid()));
			ps.setString(4, suggestion.getSuggestioncontent());
			if(suggestion.getSuggestionstatus()!="") {
				ps.setInt(5,0);
			}else {
				ps.setInt(5,1);
			}
			//4执行命令对象
			count=ps.executeUpdate(); 
		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	public int updateStatus(int suggestionid) {
		int count=0;
		conn=JDBCUtil.getConnection();
		String sql="update suggestion set suggestionstatus=? where suggestionid=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, 1);
			ps.setInt(2, suggestionid);
			//4执行命令对象
			count=ps.executeUpdate(); 
		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
}
