/*Displays Shopper’s information along with number of orders he/she placed during last 30 days.*/
SELECT s.`ShopperID`,s.`Name`,COUNT(s.`ShopperID`) as 'number of products placed'
FROM `shopper` s
INNER JOIN `order` o
ON s.`ShopperID` = o.`ShopperID`
WHERE o.`Date` >= curdate() -30
GROUP BY s.`ShopperID`;

/*Displays the top 10 Shoppers who generated maximum number of revenue in last 30 days.*/
SELECT s.`ShopperID`,s.`Name`
FROM `shopper` s
INNER JOIN `order` o
ON s.`ShopperID` = o.`ShopperID`
WHERE o.`Date` >= curdate() -30
GROUP BY s.`ShopperID`
order by SUM(o.Total_Price) DESC
LIMIT 10;


/*Display top 20 Products which are ordered most in last 60 days along with numbers.
*/
SELECT p.`ProductName`, COUNT(op.`Order_ProductID`) as num
FROM `product` p
Inner join `ordered_product` op
on p.`ProductID` = op.`ProductID`
inner join `order` o
on o.`OrderID` = op.`OrderID`
WHERE o.`Date` >= curdate() - 60
GROUP BY p.`ProductID`
Order by num desc
limit 20;

/*Displays Monthly sales revenue of the StoreFront for last 6 months. It should display each month’s sale.*/
select o.`OrderID`,case
    when month(o.`Date`) = month(curdate()) then 'Month 1' 
    when month(o.`Date`) = month(curdate()) - 1 then 'Month 2'
    when month(o.`Date`) = month(curdate()) - 2 then 'Month 3'
    when month(o.`Date`) = month(curdate()) - 3 then 'Month 4'
    when month(o.`Date`) = month(curdate()) - 4 then 'Month 5'
    when month(o.`Date`) = month(curdate()) - 5 then 'Month 6'
    end as months, sum(o.Total_Price) as monthly_revenue
from `order` o
GROUP BY months;

SET SQL_SAFE_UPDATES = 0;

/*Marks the products as Inactive which are not ordered in last 90 days.*/
update `product`
SET `Status` = 'Inactive'
WHERE `ProductID` not in
(SELECT p.`ProductID`
	FROM (SELECT * FROM `product`) as p
	INNER JOIN `ordered_product` op
	ON p.`ProductID` = op.`ProductID`
	INNER JOIN `order` o
	ON o.`OrderID` = op.`OrderID`
    WHERE o.`Date` >= curdate() - 90);


SELECT c.`Category_Name`, count(*) as count 
FROM `category` c
INNER JOIN `product_category` pc
on pc.`CategoryID` = c.`CategoryID`
group by pc.`CategoryID`, c.`Parent_CategoryID`;

/*Display top 10 Items which were cancelled most.
*/
SELECT p.`ProductName`, count(*) as count
FROM `product` p
INNER JOIN `ordered_product` op
ON p.`ProductID`= op.`ProductID`
WHERE op.`Product_Status` = "Cancelled"
GROUP BY op.`ProductID`
ORDER BY count desc
LIMIT 10;


