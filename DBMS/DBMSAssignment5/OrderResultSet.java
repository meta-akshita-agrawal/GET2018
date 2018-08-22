import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderResultSet {
	
	private static  List<Order> orderList;
	
	public static List<Order> getOrderResultList(ResultSet rs) throws SQLException{
		
		try {
			orderList = new ArrayList<Order>();
			while(rs.next()) {
				orderList.add(new Order(rs.getInt(1),rs.getDate(2),rs.getFloat(3)));
			}
			return orderList;
		}
		catch(NullPointerException ne){
			throw new NullPointerException("Resultset is empty");
		}
	}
	
}
