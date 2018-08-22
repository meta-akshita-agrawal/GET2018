import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class JDBCTest {

	@Test
	public void selectOrderTest() throws SQLException {
		QueryHelper qh = new QueryHelper();
		String query = qh.fetchOrderDetailsByShopperIDQuery();
		
		QueryExecute qe = new QueryExecute();
		List<Order> orderList = qe.fetchOrderDetailsByShopperID(4, query);
		
		List<Order> expectedList = new ArrayList<Order>();
		
		expectedList.add(new Order(55, 2018-07-29, 1400.00)));
		
		
	}
	
	@Test
	public void insertImagesTest() {
		 ArrayList<String> productImagePaths = new ArrayList<>();
		    
		    productImagePaths.add("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\1.jpg");
		    productImagePaths.add("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\2.jpg");
		    productImagePaths.add("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\3.jpg");
		    productImagePaths.add("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\4.jpg");
		    productImagePaths.add("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\5.jpg");
		    
	}
}
