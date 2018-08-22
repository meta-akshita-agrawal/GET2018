
public class QueryHelper {
	
	
	public String fetchOrderDetailsByShopperIDQuery() {
		
		return "select o.`OrderID`,o.`Date`,o.`Total_Price`\n"+
 				"from `order` o\n" +	
 				"where o.`Status` = \"Shipped\" and s.`ShopperID` =?\n" + 
 				"order by o.`date` \n";
	}
	
	public String insertImagesForProductQuery() {
		 return "Insert into gallery (ProductID,ImagLocation) values (?,LOAD_FILE(?))";
	}
	
	public String updateOldProductsInactiveQuery() {
		
		return "";
	}

	
	public String childCategoriesCountQuery() {
		return "";
	}
	
}
