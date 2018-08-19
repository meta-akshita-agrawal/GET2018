DELIMITER $$

 CREATE procedure average_sales (IN sales_month int(2), IN sales_year int(4))
	begin 
    
    select pn, avg(counted) from(
		select p.`ProductName` as pn, count(*) as counted
		from `product` p
		inner join `ordered_product` op
		on p.`ProductID` = op.`ProductID`
		inner join `order` o
		on op.`OrderID` = o.`OrderID`
		where month(o.`Date`) = sales_month and year(o.`Date`) = sales_year
		group by p.`ProductID`) as counts
    group by pn;
    
	end;
    
    
call average_sales(1,2018);

DELIMITER $$

CREATE procedure order_detail(in start_date date, in end_date date)
	
    begin
    
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
 