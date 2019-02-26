package com.metacube.advertismentWebServices.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metacube.advertismentWebServices.JDBCConnection.ConnectionHelper;
import com.metacube.advertismentWebServices.entity.Advertisement;

public class MySQLAdvertisementDao implements AdvertisementDao {

	private static MySQLAdvertisementDao mySQLAdvertisementDao = new MySQLAdvertisementDao();

	// CREATING SINGLE INSTANCE FOR THIS CLASS
	public static MySQLAdvertisementDao getInstance() {
		return mySQLAdvertisementDao;
	}

	// QUERIES
	private static String GET_ALL_ADVERTISEMENTS = "select * from advertisment.advertisement";
	private static String INSERT_CATEGORY = "insert into advertisment.advertisement(`title`,`description`,`category_id`) values(?,?,?)";
	private static String GET_ALL_ADVERTISEMENTS_BY_CATEGORY_ID = "select * from advertisment.advertisement where `category_id`=?";
	private static String UPDATE_ADVERTISEMENT_NAME = "update advertisment.advertisement set `title`= ? where idAdvertisement=?";
	private static String DELETE_ADVERTISEMENT_BY_ID = "delete from advertisment.advertisement where idAdvertisement=?";

	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	/**
	 * Gets all advertisements
	 */
	@Override
	public List<Advertisement> getAll() {

		List<Advertisement> advertisementList = new ArrayList<Advertisement>();

		try {
			conn = ConnectionHelper.getConnection();
			psmt = conn.prepareStatement(GET_ALL_ADVERTISEMENTS);

			rs = psmt.executeQuery();

			while (rs.next()) {
				Advertisement advertisement = new Advertisement();
				advertisement.setAdvertisementID(rs.getInt("idAdvertisement"));
				advertisement.setDescription(rs.getString("description"));
				advertisement.setTitle(rs.getString("title"));
				advertisement.setCategoryID(rs.getInt("category_id"));
				advertisementList.add(advertisement);
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
		return advertisementList;

	}

	/**
	 * Insert an advertisement in the advertisement table
	 */
	@Override
	public int insert(Advertisement advertisement) {

		try {
			conn = ConnectionHelper.getConnection();
			psmt = conn.prepareStatement(INSERT_CATEGORY);

			psmt.setString(1, advertisement.getTitle());
			psmt.setString(2, advertisement.getDescription());
			psmt.setInt(3, advertisement.getCategoryID());

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
	 * Gets all advertisements for the specific category id
	 */
	@Override
	public List<Advertisement> getAdvertisementsByCategoryId(int id) {

		List<Advertisement> advertisementList = new ArrayList<Advertisement>();

		try {
			conn = ConnectionHelper.getConnection();
			psmt = conn.prepareStatement(GET_ALL_ADVERTISEMENTS_BY_CATEGORY_ID);

			psmt.setInt(1, id);

			rs = psmt.executeQuery();

			while (rs.next()) {

				Advertisement advertisement = new Advertisement();
				advertisement.setAdvertisementID(rs.getInt("idAdvertisement"));
				advertisement.setDescription(rs.getString("description"));
				advertisement.setTitle(rs.getString("title"));
				advertisement.setCategoryID(rs.getInt("category_id"));

				advertisementList.add(advertisement);
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
		return advertisementList;

	}

	/**
	 * Updates advertisement name
	 */
	@Override
	public int updateNameById(String title, int id) {

		try {
			conn = ConnectionHelper.getConnection();
			psmt = conn.prepareStatement(UPDATE_ADVERTISEMENT_NAME);

			psmt.setString(1, title);
			psmt.setInt(2, id);

			return psmt.executeUpdate();

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return 0;
	}

	/**
	 * Deletes an advertisement
	 */
	@Override
	public int deleteAdvertisementById(int id) {

		try {
			conn = ConnectionHelper.getConnection();
			psmt = conn.prepareStatement(DELETE_ADVERTISEMENT_BY_ID);

			psmt.setInt(1, id);

			return psmt.executeUpdate();

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return 0;

	}

}
