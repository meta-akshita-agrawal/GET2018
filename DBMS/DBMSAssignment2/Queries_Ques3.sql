/* Display Recent 50 Orders placed */
SELECT * FROM `order`
ORDER BY `Date` DESC
LIMIT 50;

/*Display 10 most expensive Orders.*/
SELECT * FROM `order`
ORDER BY `Total_Price` DESC
LIMIT 10;

/*Display all the Orders which are placed more than 10 days old and one or more items from those orders are still not shipped.*/
SELECT o.`OrderID`
FROM `order` o
INNER JOIN `ordered_product` op
ON o.`OrderID` = op.`OrderID`
WHERE op.`Product_Status` != "Shipped" AND o.`Date` <= CURDATE() - 10;


/*Display list of shoppers which haven't ordered anything since last month.*/
SELECT s.`ShopperID`, s.`Name`
FROM `shopper` s
WHERE s.`ShopperID` NOT IN (SELECT o.`ShopperID` 
                            FROM `order` o
                            WHERE month(o.`date`) >= month(CURDATE()));


/*Display list of shopper along with orders placed by them in last 15 days.*/ 
SELECT s.`ShopperID`, s.`Name`, o.`OrderID`,o.`Status`,o.`Total_Price`
FROM `shopper` s
INNER JOIN `order` o
ON o.`ShopperID` = s.`ShopperID`
WHERE o.`Date` >= CURDATE() - 15;


/*Display list of order items which are in “shipped” state for particular Order Id (i.e.: 43))*/
SELECT op.`ProductID`,p.`ProductName`
From `product` p
INNER JOIN `ordered_product` op
ON p.`ProductID`= op.`ProductID`
WHERE op.`OrderID` = 49 AND op.`Product_Status` = "Shipped";

/*Display list of order items along with order placed date which fall between Rs 20 to Rs 50 price.*/
SELECT p.`ProductName`, o.`Date`
FROM `product` p
INNER JOIN `ordered_product` op
ON P.`ProductID` = op.`ProductID`
INNER JOIN `order` o
ON o.`OrderID` = op.`OrderID`
WHERE p.`Price` >= 20 AND p.`Price` <= 50;


/*Update first 20 Order items status to “Shipped” which are placed today.*/
UPDATE `order`
SET `Status` = "Shipped"
WHERE `Date` = CURDATE();