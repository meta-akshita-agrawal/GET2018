package jdbc;

public class QueryHelper {

	// helper class to return query
	public static String fetchOrderDetailsByShopperIDQuery() {

		return "select o.`OrderID`,o.`Date`,o.`Total_Price`\n"
				+ "from `order` o\n"
				+ "where o.`Status` = \"Shipped\" and o.`ShopperID` =?\n"
				+ "order by o.`date` \n";
	}

	// helper class to return query
	public static String insertImagesForProductQuery() {
		return "Insert into gallery (ProductID,ImagLocation) values (?,?)";
	}

	// helper class to return query
	public static String updateOldProductsInactiveQuery() {

		return "update `product`\n" + "SET `Status` = 'Inactive'\n"
				+ "WHERE `ProductID` not in\n" + "(SELECT p.`ProductID`\n"
				+ "FROM (SELECT * FROM `product`) as p\n"
				+ "INNER JOIN `ordered_product` op\n"
				+ "ON p.`ProductID` = op.`ProductID`\n"
				+ "INNER JOIN `order` o\n" + "ON o.`OrderID` = op.`OrderID`"
				+ "WHERE o.`Date` >= date_add(curdate(), interval -1 year));";
	}

	// helper class to return query
	public static String childCategoriesCountQuery() {
		return "SELECT count(*),\n"
				+ "IFNULL(m.Category_Name, 'Top Category') as top_category\n"
				+ "FROM category c\n" + "JOIN category m\n"
				+ "ON c.Parent_CategoryID = m.CategoryID\n"
				+ "where m.Parent_CategoryID is null\n"
				+ "group by top_category\n" + "order by top_category;";
	}

}