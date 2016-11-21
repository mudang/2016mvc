package com.mvc2.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mvc2.model.GuestVo;

public class SqlTemplate {
	private static final String driver ="oracle.jdbc.OracleDriver";
	private static final String url ="jdbc:oracle:thin:@localhost:1521:xe";
	private static final String user ="scott";
	private static final String password ="tiger";
	private Connection conn;
	private PreparedStatement pstmt;
	
	public SqlTemplate() {
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url, user, password);
		}catch (ClassNotFoundException e) {
		}catch (SQLException e) {
		}
	}
	public void setConn(Connection conn) {
		this.conn = conn;
	
	}
	
	public void executeUpdate(String sql,Object[] obj){
		try {
			pstmt = conn.prepareStatement(sql);
			rowMapper(obj);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}	
			
	}
	}

	public void rowMapper(Object[] obj) throws SQLException{
		for(int i=0; i<obj.length; i++){
			pstmt.setObject(i+1, obj[i]);
		}
//		pstmt.setObject(1, obj[0]);
//		pstmt.setObject(2, obj[1]);
//		pstmt.setObject(3, obj[2]);
	}
	
}
