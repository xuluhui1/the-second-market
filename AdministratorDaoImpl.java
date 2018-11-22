package com.second_hand.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.second_hand.dao.AdministratorDao;
import com.second_hand.model.Administrator;
import com.second_hand.util.JDBCUtil;

public class AdministratorDaoImpl extends AdministratorDao{
	public Connection conn=null;
	private PreparedStatement ps;
	private ResultSet rs;
	@Override
	public int insertAdministrator(Administrator administrator) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeAdministratorById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateAdministrator(Administrator administrator) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Administrator> selectAdministrator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Administrator selectAdministratorById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Administrator login(Administrator admin) {
		Administrator resultAdmin=null;
		String sql="select auserid,ausername,apassword from administrator where ausername=? and apassword=?";
		conn=JDBCUtil.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, admin.getAusername());
			ps.setString(2, admin.getApassword());
			rs=ps.executeQuery();
			if(rs.next()) {
				resultAdmin=new Administrator();
				resultAdmin.setAuserid(rs.getInt("auserid"));
				resultAdmin.setAusername(rs.getString("ausername"));
				resultAdmin.setApassword(rs.getString("apassword"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return resultAdmin;
	}

}
