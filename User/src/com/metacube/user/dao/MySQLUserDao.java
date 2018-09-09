package com.metacube.user.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.metacube.user.pojo.User;
import com.metacube.user.JDBCConnection.ConnectionHelper;

public class MySQLUserDao implements UserDao {

	private static MySQLUserDao mySQLUserDao = new MySQLUserDao();

	public static MySQLUserDao getInstance() {
		return mySQLUserDao;
	}

	// QUERIES
	static final String GET_ALL_QUERY = "select * from user.user;";
	static final String GET_USER_BY_EMAIL_QUERY = "select * from user.user where email = ?;";
	static final String INSERT_QUERY = "insert into user.user(`First Name`,`Last Name`,`Password`,`Email`,`Contact Number`,`Company`) values(?,?,?,?,?,?);";
	static final String UPDATE_QUERY = "update user.user set `First Name`= ?, `Last Name` = ?, `Password` = ?, `Contact Number`=?,`Company` = ? where `email` = ?";
	static final String DELETE_QUERY = "delete from user.user where `email` = ?";
	static final String GET_USERLIST_BY_COMPANY_NAME = "select email from user.user where `Company` = ? and email != ?;";

	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	/**
	 * Gets all users
	 * @return list of users
	 */
	public List<User> getAll() {

		List<User> userList = new ArrayList<User>();

		try {
			conn = ConnectionHelper.getConnection();
			psmt = conn.prepareStatement(GET_ALL_QUERY);

			rs = psmt.executeQuery();

			while (rs.next()) {
				userList.add(new User(rs.getString("First Name"), rs.getString("Last Name"), rs.getString("Password"),
						rs.getString("email"), rs.getString("Contact Number"), rs.getString("Company")));
			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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

	/**
	 * Gets user by unique email id
	 * @param email
	 * @return user
	 */
	public User getUserByEmail(String email) {

		try {
			conn = ConnectionHelper.getConnection();
			psmt = conn.prepareStatement(GET_USER_BY_EMAIL_QUERY);

			psmt.setString(1, email);

			rs = psmt.executeQuery();

			while (rs.next()) {
				return new User(rs.getString("First Name"), rs.getString("Last Name"), rs.getString("Password"),
						rs.getString("email"), rs.getString("Contact Number"), rs.getString("Company"));
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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

	/**
	 * Inserts a new user
	 * @param user
	 * @return 1 if successfully inserted else 0
	 */
	public int insert(User user) {

		try {
			conn = ConnectionHelper.getConnection();
			psmt = conn.prepareStatement(INSERT_QUERY);

			psmt.setString(1, user.getFirstName());
			psmt.setString(2, user.getLastName());
			psmt.setString(3, user.getPassword());
			psmt.setString(4, user.getEmail());
			psmt.setString(5, user.getContactNumber());
			psmt.setString(6, user.getCompanyName());

			return psmt.executeUpdate();

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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

	/**
	 * Updates details of a user
	 * @return 1 if successfully updated else 0
	 */
	public int update(User user) {
		try {
			conn = ConnectionHelper.getConnection();
			psmt = conn.prepareStatement(UPDATE_QUERY);

			psmt.setString(1, user.getFirstName());
			psmt.setString(2, user.getLastName());
			psmt.setString(3, user.getPassword());
			psmt.setString(4, user.getContactNumber());
			psmt.setString(5, user.getCompanyName());
			psmt.setString(6, user.getEmail());

			return psmt.executeUpdate();

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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

	/**
	 * Deletes a user
	 * @return 1 if successfully deleted else 0
	 */
	public int delete(User user) {
		try {
			conn = ConnectionHelper.getConnection();
			psmt = conn.prepareStatement(DELETE_QUERY);

			psmt.setString(1, user.getEmail());

			return psmt.executeUpdate();

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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

	/**
	 * Gets all email associated with a company
	 * @param company name of an email
	 * @param email
	 * @return list of email
	 */
	public List<String> getEmailListByCompanyName(String companyName, String email) {

		List<String> emailList = new ArrayList<String>();

		try {
			conn = ConnectionHelper.getConnection();
			psmt = conn.prepareStatement(GET_USERLIST_BY_COMPANY_NAME);

			psmt.setString(1, companyName);
			psmt.setString(2, email);

			System.out.println(companyName);
			System.out.println(email);

			rs = psmt.executeQuery();

			while (rs.next()) {
				emailList.add(rs.getString("email"));
				System.out.println("asdbh");
			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				psmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return emailList;
	}

}
