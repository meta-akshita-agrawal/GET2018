package com.metacube.user.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.metacube.user.pojo.User;
import com.metacube.user.JDBCConnection.ConnectionHelper;

public class MySQLUserDao implements UserDao {
	
	private static MySQLUserDao mySQLUserDao = new MySQLUserDao();
	
	public static MySQLUserDao getInstance(){
		return mySQLUserDao;
	}
	
	List<User> userList = new ArrayList<User>();
	
	static final String GET_ALL_QUERY = "select * from user;";
	static final String GET_USER_BY_EMAIL_QUERY = "select * from user where email = ?;";
	static final String INSERT_QUERY = "insert into user(`First Name`,`Last Name`,`Password`,`Email`,`Contact Number`,`Company`) values(?,?,?,?,?,?);)";
	static final String UPDATE_QUERY = "update user set `First Name`= ?, `Last Name` = ?, `Password` = ?, `Contact Number`=?,`Company` = ? where `email` = ?";
	static final String DELETE_QUERY = "delete from `user` where `email` = ?";
	
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	@Override
	public List<User> getAll() {
		
		try{
			conn = ConnectionHelper.getConnection();
			psmt = conn.prepareStatement(GET_ALL_QUERY);
			
			rs = psmt.executeQuery();
			
			while(rs.next()){
				userList.add(new User(rs.getString("First Name"),rs.getString("Last Name"),rs.getString("Password"),rs.getString("email"),rs.getString("Contact Number"),rs.getString("Compnay")));
			}
			
		}catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
				psmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		return userList;
	}

	@Override
	public User getUserByEmail(String email) {
		
		try{
			conn = ConnectionHelper.getConnection();
			psmt = conn.prepareStatement(GET_USER_BY_EMAIL_QUERY);
			
			psmt.setString(1,email);
			
			rs = psmt.executeQuery();
			
			return new User(rs.getString("First Name"),rs.getString("Last Name"),rs.getString("Password"),rs.getString("email"),rs.getString("Contact Number"),rs.getString("Compnay"));
			
		}catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
				psmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		return null;
	}

	@Override
	public int insert(User user) {
		
		try{
			conn = ConnectionHelper.getConnection();
			psmt = conn.prepareStatement(INSERT_QUERY);
			
			psmt.setString(1,user.getFirstName());
			psmt.setString(2,user.getLastName());
			psmt.setString(3,user.getPassword());
			psmt.setString(4,user.getEmail());
			psmt.setString(5,user.getContactNumber());
			psmt.setString(6,user.getCompanyName());
			
			return psmt.executeUpdate();
			
		}catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
				psmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		
		return 0;
		
	}

	@Override
	public int update(User user) {
		try{
			conn = ConnectionHelper.getConnection();
			psmt = conn.prepareStatement(UPDATE_QUERY);
			
			psmt.setString(1,user.getFirstName());
			psmt.setString(2,user.getLastName());
			psmt.setString(3,user.getPassword());
			psmt.setString(4,user.getContactNumber());
			psmt.setString(5,user.getCompanyName());
			psmt.setString(6,user.getEmail());
			
			return psmt.executeUpdate();
			
		}catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
				psmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		
		return 0;
		
	}

	@Override
	public int delete(User user) {
		try{
			conn = ConnectionHelper.getConnection();
			psmt = conn.prepareStatement(DELETE_QUERY);
			
			psmt.setString(1,user.getEmail());
			
			return psmt.executeUpdate();
			
		}catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
				psmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		
		return 0;
		
	}

}
