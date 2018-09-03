package com.metacube.advertismentWebServices.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metacube.advertismentWebServices.entity.Category;
import com.metacube.advertismentWebServices.JDBCConnection.ConnectionHelper;


public class MySQLCategoryDao implements CategoryDao{

	
	private static MySQLCategoryDao mySQLCategoryDao = new MySQLCategoryDao();
	
	public static MySQLCategoryDao getInstance(){
		return mySQLCategoryDao;
	}
	
	private static String GET_ALL_CATEGORIES = "select * from advertisment.category";
	private static String INSERT_CATEGORY = "insert into advertisment.category(`name`) values(?)";
	private static String UPDATE_CATEGORY_NAME = "update advertisment.category set `name`=? where idCategory=?";
	private static String GET_CATEGORY_BY_ID = "select * from advertisment.category where idCategory=?";
	
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	@Override
	public List<Category> getAll() {
		
		List<Category> categoryList = new ArrayList<Category>();
		
		try{
			conn = ConnectionHelper.getConnection();
			psmt = conn.prepareStatement(GET_ALL_CATEGORIES);
			
			rs = psmt.executeQuery();
			
			while(rs.next()){
				categoryList.add(new Category(rs.getInt("idCategory"),rs.getString("name")));
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
		return categoryList;
	}

	@Override
	public int insert(Category category) {
		
		try{
			conn = ConnectionHelper.getConnection();
			psmt = conn.prepareStatement(INSERT_CATEGORY);
			
			psmt.setString(1,category.getName());
			
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
	public Category getCategoryById(int id) {
		try{
			conn = ConnectionHelper.getConnection();
			psmt = conn.prepareStatement(GET_CATEGORY_BY_ID);
			
			psmt.setInt(1,id);
			
			rs = psmt.executeQuery();
			
			while(rs.next()){
				return new Category(rs.getInt("idCategory"),rs.getString("name"));
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
		return null;
	}

	@Override
	public int updateNameById(String name,int id) {
		try{
			conn = ConnectionHelper.getConnection();
			psmt = conn.prepareStatement(UPDATE_CATEGORY_NAME);

			psmt.setString(1, name);
			psmt.setInt(2, id);
			
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
