package com.second_hand.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	private static final String user="root";
	private static final String password="root";
	private static final String url="jdbc:mysql://localhost:3306/second_hand";
	private static final String driver="com.mysql.jdbc.Driver";
	static Connection conn=null;

	public static Connection getConnection() {
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url, user, password);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(Connection conn,Statement stmt,PreparedStatement pstmt,ResultSet rs) {
		try {
			if(conn!=null) {
				conn.close();
			}
			if(stmt!=null) {
				stmt.close();
			}
			if(pstmt!=null) {
				pstmt.close();
			}
			if(rs!=null) {
				rs.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
