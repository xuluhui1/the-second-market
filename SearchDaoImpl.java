package com.second_hand.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.second_hand.dao.SearchDao;
import com.second_hand.demo.KeyWordTurnRedTools;
import com.second_hand.model.Bbs;
import com.second_hand.model.Suggestion;
import com.second_hand.util.JDBCUtil;

public class SearchDaoImpl extends SearchDao{
	public Connection conn=null;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public List<Bbs>SearchBbsString(String keyword) {
		KeyWordTurnRedTools tools=new KeyWordTurnRedTools();
		List<Bbs> list=new ArrayList<Bbs>();
		Bbs resultBbs=null;
		String sql="select * from bbs where concat(bbsid,senddate,senderid,receiverid,goodsid,message) like ?";
		conn=JDBCUtil.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1,"%"+keyword+"%");
			rs=ps.executeQuery();
			while(rs.next()) {
				resultBbs=new Bbs();
				resultBbs.setId(rs.getInt("bbsid"));
				resultBbs.setBbsid(tools.KeyWordTurnRedTools(String.valueOf(rs.getInt("bbsid")), keyword));
				resultBbs.setSenddate(tools.KeyWordTurnRedTools(rs.getString("senddate"), keyword));
				resultBbs.setSenderid(tools.KeyWordTurnRedTools(String.valueOf(rs.getInt("senderid")),keyword));
				resultBbs.setReceiverid(tools.KeyWordTurnRedTools(String.valueOf(rs.getInt("receiverid")), keyword));
				resultBbs.setGoodsid(tools.KeyWordTurnRedTools(String.valueOf(rs.getInt("goodsid")), keyword));
				resultBbs.setMessage(tools.KeyWordTurnRedTools(rs.getString("message"), keyword));
				list.add(resultBbs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	} 
	public List<Suggestion>SearchSuggestionString(String keyword) {
		KeyWordTurnRedTools tools=new KeyWordTurnRedTools();
		List<Suggestion> list=new ArrayList<Suggestion>();
		Suggestion resultSuggestion=null;
		String sql="select * from suggestion where concat(suggestionid,talktime,senderid,receiverid,suggestioncontent,suggestionstatus) like ?";
		conn=JDBCUtil.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1,"%"+keyword+"%");
			rs=ps.executeQuery();
			while(rs.next()) {
				resultSuggestion=new Suggestion();
				resultSuggestion.setId(rs.getInt("suggestionid"));
				resultSuggestion.setSuggestionid(tools.KeyWordTurnRedTools(String.valueOf(rs.getInt("suggestionid")),keyword));
				resultSuggestion.setTalktime(tools.KeyWordTurnRedTools(rs.getString("talktime"),keyword));
				resultSuggestion.setSenderid(tools.KeyWordTurnRedTools(String.valueOf(rs.getInt("senderid")),keyword));
				resultSuggestion.setSid(rs.getInt("senderid"));
				resultSuggestion.setReceiverid(tools.KeyWordTurnRedTools(String.valueOf(rs.getInt("receiverid")),keyword));
				resultSuggestion.setSuggestioncontent(tools.KeyWordTurnRedTools(rs.getString("suggestioncontent"),keyword));
				resultSuggestion.setSuggestionstatus(rs.getInt("suggestionstatus"));
				list.add(resultSuggestion);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
