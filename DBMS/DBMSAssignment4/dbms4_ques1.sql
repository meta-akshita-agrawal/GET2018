DELIMITER $$

CREATE FUNCTION orders_count(order_month int(2), order_year int(4)) RETURNS int(3)
	deterministic
begin 
	
    declare order_count int(3);
    
    set order_count = (select count(*) from `order`
					   where month(`Date`) = order_month and year(`Date`) = order_year  );
   
	return (order_count);
end;


DELIMITER $$

CREATE FUNCTION max_order_month(order_year int(4)) returns int(2)
	deterministic
begin

	declare order_month int(2);
    
    set order_month =(select month(`Date`)
	from `order`
	group by month(`Date`)
    order by count(*) desc
    limit 1);
                    
	return (order_month);

end;
