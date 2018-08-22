package jdbc;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class TestClass {

	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

	@Test
	public void testForOrderFetch() throws SQLException, ParseException {

		QueryExecute qe = new QueryExecute();

		List<Order> orderList = qe.fetchOrderDetailsByShopperID(4);

		List<Order> expectedList = new ArrayList<>();

		expectedList.add(new Order(55, formatter.parse("2018-07-29"), 1400));
		expectedList.add(new Order(27, formatter.parse("2018-08-09"), 4300));
		expectedList.add(new Order(22, formatter.parse("2018-08-10"), 10011));
		expectedList.add(new Order(15, formatter.parse("2018-08-17"), 190));

		int i = 0;

		for (Order order : expectedList) {
			assertEquals(order.getOrderID(), orderList.get(i).orderID);
			assertEquals(order.getDate(), orderList.get(i).date);
			assertEquals(order.getTotalPrice(), orderList.get(i).totalPrice,
					0.00);
			i++;
		}
	}

	@Test
	public void testForInsertingImages() throws SQLException {

		QueryExecute qe = new QueryExecute();

		ArrayList<String> productImagePaths = new ArrayList<>();

		productImagePaths
				.add("C:\\Program Files\\MySQL\\MySQL Workbench 8.0 CE\\images\\1.jpg");
		productImagePaths
				.add("C:\\Program Files\\MySQL\\MySQL Workbench 8.0 CE\\images\\2.jpg");
		productImagePaths
				.add("C:\\Program Files\\MySQL\\MySQL Workbench 8.0 CE\\images\\3.jpg");
		productImagePaths
				.add("C:\\Program Files\\MySQL\\MySQL Workbench 8.0 CE\\images\\4.jpg");
		productImagePaths
				.add("C:\\Program Files\\MySQL\\MySQL Workbench 8.0 CE\\images\\5.jpg");

		boolean rowsInsertedCheck = qe.insertImagesForProduct(1,
				productImagePaths);

		assertEquals(rowsInsertedCheck, true);

	}

	@Test
	public void testForUpdatingInactiveProducts() throws SQLException {

		QueryExecute qe = new QueryExecute();

		int result = qe.updateOldProductsInactive();

		assertEquals(result, 1);

	}

	@Test
	public void testForChildCategoryCount() throws SQLException {

		QueryExecute qe = new QueryExecute();

		List<Category> categoryList = qe.childCategoriesCount();

		List<Category> expectedList = new ArrayList<>();

		expectedList.add(new Category("Books", 2));
		expectedList.add(new Category("Electronics", 2));
		expectedList.add(new Category("Fashion", 2));

		int i = 0;

		for (Category category : expectedList) {
			assertEquals(category.getParentCategory(), categoryList.get(i)
					.getParentCategory());
			assertEquals(category.getChildCount(), categoryList.get(i)
					.getChildCount());
			i++;
		}

	}

}
