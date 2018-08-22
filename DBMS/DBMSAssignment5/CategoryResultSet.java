package jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryResultSet {

	private static List<Category> categoryList;

	/**
	 * Adding values of result set in POJO class list
	 * @param rs, result set
	 * @return, list
	 * @throws SQLException
	 */
	public static List<Category> getOrderResultList(ResultSet rs)
			throws SQLException {

		try {
			categoryList = new ArrayList<Category>();
			while (rs.next()) {
				categoryList.add(new Category(rs.getString(2), rs.getInt(1)));
			}
			return categoryList;
		} catch (NullPointerException ne) {
			throw new NullPointerException("Resultset is empty");
		}
	}
}
