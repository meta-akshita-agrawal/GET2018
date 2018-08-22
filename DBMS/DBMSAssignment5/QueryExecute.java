import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueryExecute {

	public List<Order> fetchOrderDetailsByShopperID(int id, String query) throws SQLException{ 
		
		try(
				Connection conn = Connectivity.getConnection();
				PreparedStatement psmt = conn.prepareStatement(query);
				) {
			
			psmt.setInt(1, id);
			return OrderResultSet.getOrderResultList(psmt.executeQuery());
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		
		return null;
	}
	
	
	public boolean insertImagesForProduct(int productID, ArrayList<String> productImagesPaths, String query) throws SQLException {
		

		try(
				Connection conn = Connectivity.getConnection();
				PreparedStatement psmt = conn.prepareStatement(query);
				
				) {
				conn.setAutoCommit(false);
			
				for(String path:productImagesPaths) {
					psmt.setInt(1, productID);
					psmt.setString(2, path);
					psmt.addBatch();
				}

				int[] result = psmt.executeBatch();
			
				if(result.length == productImagesPaths.size()) {
				
					conn.commit();
					return true;
				
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
				//conn.rollback();
			}
		return false;
		
	}
	
	public int updateOldProductsInactive(String query) throws SQLException {
		
		try(
				Connection conn = Connectivity.getConnection();
				PreparedStatement psmt = conn.prepareStatement(query);
				) {
			
			return psmt.executeUpdate();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		
		return 0;
	}

	
}
