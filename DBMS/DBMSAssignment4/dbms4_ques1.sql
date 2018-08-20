/*A function to calculate number of orders in a month. 
Month and year will be input parameter to function./*

DELIMITER $$

CREATE FUNCTION orders_count(order_month int(2), order_year int(4)) RETURNS int(3)
	deterministic
begin 
	
    declare order_count int(3);
    
    set order_count = (select count(*) from `order`
					   where month(`Date`) = order_month and year(`Date`) = order_year  );
   
	return (order_count);
end;

/* a function to return month in a year having maximum orders. 
Year will be input parameter./*

DELIMITER $$

CREATE FUNCTION max_order_month(order_year int(4)) returns int(2)
	deterministic
begin

	declare max_order_month int(2);
    
    set max_order_month = (select month(`Date`)
				from `order`
				where year(`Date`) = order_year
				group by month(`Date`)
    				order by count(*) desc
    				limit 1);
                    
	return (max_order_month);

end;
