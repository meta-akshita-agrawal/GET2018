/*Creates a view displaying the order information with latest ordered items should be displayed first for last 60 days*/
CREATE VIEW orders_by_shopper as 
SELECT p.`ProductID`, p.`ProductName`, p.`Price`, s.`Name`, o.`Date`, o.`Status`
FROM `product` p
INNER JOIN `ordered_product` op
on op.`ProductID` = p.`ProductID`
INNER JOIN `order` o
on o.`OrderID` = op.`OrderID`
INNER JOIN `shopper` s
on s.`ShopperID` = o.`ShopperID`
WHERE o.`Date` >= curdate() - 60
order by o.`Date` desc;

/*Uses the above view to display the Products(Items) which are in ‘shipped’ state*/
SELECT v.`ProductName`
FROM orders_by_shopper v
WHERE v.`Status` = "Shipped";

/*Uses the above view to display the top 5 most selling products.*/
SELECT v.`ProductName`
FROM orders_by_shopper v
group by v.`ProductID`
Order by count(*) desc
limit 5;