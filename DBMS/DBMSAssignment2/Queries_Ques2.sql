/*Display Id, Title, Category Title, Price of the products which are Active and recently added products should be at top.
*/
SELECT p.ProductID, p.ProductName, p.Price, c.Category_Name
FROM `product` p
INNER JOIN `product_category` pc 
ON p.ProductID = pc.ProcudtID
INNER JOIN `category` c
ON pc.CategoryID = c.CategoryID
INNER JOIN `stock` s
ON s.ProductID = p.ProductID
WHERE s.`Quantity` != 0
ORDER BY s.`AddedDate` DESC;

/*Display Id, Title, Parent Category Title of all the leaf Categories */
SELECT * FROM `category` c
WHERE `Parent_CategotyID` OR `CategoryID` IN (SELECT `CategoryID` FROM `category`
                              WHERE c.`Parent_CategotyID` IS NULL
                              ORDER BY `Parent_CategotyID`);
                            


/*Display Id, Title, Parent Category Title of all the leaf Categories*/
SELECT * FROM `category`
WHERE `CategoryID` NOT IN (SELECT `Parent_CategotyID` FROM `category`
                           WHERE `Parent_CategotyID` IS NOT NULL);


/*Display Product Title, Price & Description which falls into particular category Title (i.e. “Mobile”)
*/
SELECT p.`ProductName`, p.`Price`
FROM `product` p
INNER JOIN `product_category` pc
ON p.`ProductID` = pc.`ProcudtID`
INNER JOIN `category` c
ON pc.`CategoryID` = c.`CategoryID`
WHERE c.`Category_Name` = "ethnic";

/*Display the list of Products whose Quantity on hand (Inventory) is under 50.
*/
SELECT p.`ProductID`, p.`ProductName`, p.`Price` 
FROM `product` p
INNER JOIN `stock` s
ON s.`ProductID` = p.`ProductID`
WHERE s.`quantity` <= 50;



SET SQL_SAFE_UPDATES = 0;

/*Increase the Inventory of all the products by 100.
*/
UPDATE `stock`
SET `quantity` = `quantity` + 100;



