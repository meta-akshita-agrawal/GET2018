package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueryExecute {

	/**
	 * Executes query for id of a user, fetch all orders (Id, Order Date, Order Total) of that user 
	 * which are in shipped state in chronological order
	 * @param id, user ID
	 * @return list of POJO class order
	 * @throws SQLException
	 */
	public List<Order> fetchOrderDetailsByShopperID(int id) throws SQLException {

		String query = QueryHelper.fetchOrderDetailsByShopperIDQuery();

		try (
				Connection conn = Connectivity.getConnection();//Allocate a database 'Connection' object
				PreparedStatement psmt = conn.prepareStatement(query);) {//Allocate a 'Statement' object in the Connection
			
			psmt.setInt(1, id);//binding variable with place holder ? at position 1
			
			return OrderResultSet.getOrderResultList(psmt.executeQuery());//TO GET LIST OF POJO class order BY PASSING RESULT SET
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return null;
	}

	/**
	 * Insert five or more images of a product using batch insert technique.
	 * @param productID, id of product to insert images
	 * @param productImagesPaths, list of paths of images
	 * @return true if rows inserted are equal to number of images inserted
	 * @throws SQLException
	 */
	public boolean insertImagesForProduct(int productID,ArrayList<String> productImagesPaths) throws SQLException {

		String query = QueryHelper.insertImagesForProductQuery();

		try (	Connection conn = Connectivity.getConnection();
				PreparedStatement psmt = conn.prepareStatement(query);

		) {
			try {
				
				conn.setAutoCommit(false); //set auto commit to false so that nothing is commited before confirmation 

				for (String path : productImagesPaths) {//binding variables
					psmt.setInt(1, productID);
					psmt.setString(2, path);
					psmt.addBatch();//adding batches one by one
				}

				int[] result = psmt.executeBatch();//adding batches together

				if (result.length == productImagesPaths.size()) {//checking length of result to added images

					conn.commit();//Committing
					return true;

				}
			} catch (SQLException ex) {
				ex.printStackTrace();
				conn.rollback();//rollback if error
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return false;

	}

	/**
	 * Update all those products to inactive which were not ordered by any Shopper in last 1 year
	 * @return Return the number of products deleted
	 * @throws SQLException
	 */
	public int updateOldProductsInactive() throws SQLException {

		String query = QueryHelper.updateOldProductsInactiveQuery();

		try (Connection conn = Connectivity.getConnection();
				PreparedStatement psmt = conn.prepareStatement(query);) {

			return psmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		}

		return 0;
	}

	/**
	 * Retrieves count of child categories in child categories
	 * @return list of POJO class CATEGORY
	 * @throws SQLException
	 */
	public List<Category> childCategoriesCount() throws SQLException {

		String query = QueryHelper.childCategoriesCountQuery();

		try (Connection conn = Connectivity.getConnection();
				PreparedStatement psmt = conn.prepareStatement(query);) {

			return CategoryResultSet.getOrderResultList(psmt.executeQuery());
		} catch (SQLException se) {
			se.printStackTrace();
		}

		return null;

	}

}