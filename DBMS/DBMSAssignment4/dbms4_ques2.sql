/*A Stored procedure to retrieve average sales of each product in a month.
Month and year will be input parameter to function.*/

DELIMITER $$

 CREATE procedure average_sales (IN sales_month int(2), IN sales_year int(4))
	begin 
   
		select p.`ProductName` as pn, count(*) as counted
		from `product` p
		inner join `ordered_product` op
		on p.`ProductID` = op.`ProductID`
		inner join `order` o
		on op.`OrderID` = o.`OrderID`
		where month(o.`Date`) = sales_month and year(o.`Date`) = sales_year
		group by p.`ProductID`
    
	end;
    
    
call average_sales(1,2018);

/*A stored procedure to retrieve table having order detail with status for a given period.
Start date and end date will be input parameter.*/
									  
DELIMITER $$

CREATE procedure order_detail(in start_date date, in end_date date)
	
    begin
    /*If start date is greater than end date take first date of month as start date.*/
    if start_date > end_date then
		set start_date = DATE_ADD(DATE_ADD(LAST_DAY(end_date),
                INTERVAL 1 DAY),
            INTERVAL - 1 MONTH);
	end if;	
    
		select o.`OrderID`, o.`Status`
		from `order` o
		where o.`Date` between start_date and end_date;
    
    end;

call order_detail(str_to_date("2018-09-01","%Y-%m-%d"),str_to_date("2018-07-02","%Y-%m-%d"));
 
