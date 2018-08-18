/*Displays the list of products (Id, Title, Count of Categories) which fall in more than one Categories.
*/
SELECT p.`ProductID`, p.`ProductName`, Count(pc.`ProductID`) AS count
FROM `product` p
INNER JOIN `product_category` pc
ON p.`ProductID` = pc.`ProductID`
GROUP BY `ProductID`
HAVING count(pc.`ProductID`) > 1;

/*Display Count of products in price ranges*/
select case  
    when o.`Total_Price` between 0 and 1000 then ' 0- 1000'
    when o.`Total_Price` between 1000 and 4000 then '1000- 4000'
    when o.`Total_Price` between 4000 and 5000 then '4000- 5000'
    when o.`Total_Price` between 5000 and 15000 then '5000-15000'
    else 'above 15000' end as ranges, count(*) as COUNT 
  from `order` o
GROUP BY ranges;

