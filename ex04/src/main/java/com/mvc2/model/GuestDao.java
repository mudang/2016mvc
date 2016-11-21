package com.mvc2.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class GuestDao {
	private Logger logger = Logger.getLogger(this.getClass());
	private static final String diver ="oracle.jdbc.OracleDriver";
	private static final String url ="jdbc:oracle:thin:@localhost:1521:xe";
	private static final String user ="scott";
	private static final String password ="tiger";
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	public GuestDao(){
		try {
			Class.forName(diver);
			conn=DriverManager.getConnection(url, user, password);
		}catch (ClassNotFoundException e) {
			logger.error("driver 확인");
		}catch (SQLException e) {
			logger.error(e.getMessage());
		}
	}

	public List<GuestVo> selectAll() {
		String sql = "select * from guest";
		List<GuestVo> list = new ArrayList<GuestVo>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				list.add(new GuestVo(rs.getInt("sabun"),rs.getString("name")
						,rs.getDate("nalja"),rs.getInt("pay")));
			}
		} catch (SQLException e) {
			logger.error("selectAll메소드 에러");
		}finally{
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (Exception e) {
				logger.error("close()오류");
			}
		}
		
		
		
		return list;
	}

	public void insertOne(GuestVo vo) {
		String sql="INSERT INTO GUEST VALUES(?,?,SYSDATE,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getSabun());
			pstmt.setString(2, vo.getName());
			pstmt.setInt(3, vo.getPay());
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

	public GuestVo selectOne(int sabun) {
		String sql= "select * from guest where sabun=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, sabun);
			rs=pstmt.executeQuery();
			if(rs.next()){
				return new GuestVo(rs.getInt("sabun")
						,rs.getString("name")
						,rs.getDate("nalja")
						,rs.getInt("pay"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
		return null;
	}
	
}
