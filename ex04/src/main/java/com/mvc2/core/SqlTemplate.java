package com.mvc2.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvc2.model.GuestVo;
import com.mvc2.util.ConnTmlp;

public class SqlTemplate {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public SqlTemplate(){
	}
	public void executeUpdate(String sql,Object[] obj){
		try {
			pstmt =ConnTmlp.getcConnection().prepareStatement(sql);
			for(int i=0; i<obj.length; i++){
				pstmt.setObject(i+1, obj[i]);
			}
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
	
	public List executeList(String sql,RowMapper mapper){
	return executeList(sql,null,mapper);
	
	}
	public List<GuestVo> executeList(String sql, Object[] obj, RowMapper mapper){
		List<GuestVo> list = new ArrayList<GuestVo>();
		try {
			pstmt =ConnTmlp.getcConnection().prepareStatement(sql);
			if(obj!=null){
			for(int i=0; i<obj.length; i++){
				pstmt.setObject(i+1, obj[i]);
			}
			}
			rs = pstmt.executeQuery();
			return mapper.rowMapper(rs);
		} catch (SQLException e) {
		}finally{
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (Exception e) {
			}
		}
		return null;
	}	
	
	
	
	
	public Object executeOne(String sql, Object[] obj, RowMapper mapper){
		return executeList(sql, obj,mapper).get(0);
	}
	


	
}
