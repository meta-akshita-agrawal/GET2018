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

	declare max_order_month int(2);
    
    set max_order_month = (select order_month 
			   from ( SELECT MONTH(o.`Date`) AS order_month ,COUNT(o.`OrderID`) As Counted 
				  FROM  `order` o
				  WHERE YEAR(o.`Date`)= order_year
   				  GROUP BY MONTH(o.`Date`)) AS t
                                  having max(t.counted));
                    
	return (max_order_month);

end;
