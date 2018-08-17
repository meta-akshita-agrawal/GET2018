ALTER TABLE `product` AUTO_INCREMENT = 1;
ALTER TABLE `category` AUTO_INCREMENT = 1;
ALTER TABLE `product_category` AUTO_INCREMENT = 1;
ALTER TABLE `stock` AUTO_INCREMENT = 1;
ALTER TABLE `shopper` AUTO_INCREMENT = 1;
ALTER TABLE `order` AUTO_INCREMENT = 1;
ALTER TABLE `ordered_product` AUTO_INCREMENT = 1;



INSERT INTO `product` (`ProductName`,`Price`) VALUES ("Hp1105",15000.00),
                                                                            ("OnePlus",15000.00),
                                                                            ("Shirt",1000),
                                                                            ("Skirt",1000),
                                                                            ("HarryPotter",500),
                                                                            ("SteveJobs",500),
                                                                            ("Kurta",2000),
                                                                            ("Kurti",2000);
                                                                            
                                                                            
INSERT INTO `category` (`Category_Name`,`Parent_CategotyID`) VALUES ("Electronics",null),
                                                                                 ("Fashion",null),
                                                                                 ("Books",null),
                                                                                 ("Laptops",1),
                                                                                 ("Phones",1),
                                                                                 ("Men",2),
                                                                                 ("Women",2),
                                                                                 ("Fiction",3),
                                                                                 ("Non-Fiction",3),
                                                                                 ("Ethnic",6),
                                                                                 ("Ethnic",7);
                                                                                 
INSERT INTO `product_category` (`CategoryID`,`ProcudtID`) VALUES (4,1),
                                                                 (5,2),
                                                                 (6,3),
                                                                 (7,4),
                                                                 (8,5),
                                                                 (9,6),
                                                                 (10,7),
                                                                 (11,8);
                                                                 
INSERT INTO `stock` (`ProductID`,`Quantity`,`AddedDate`) VALUES (1,10,STR_TO_DATE("11-08-2018","%d-%m-%Y")),
                                                                    (2,40,STR_TO_DATE("19-05-2018","%d-%m-%Y")),
                                                                    (3,0,STR_TO_DATE("29-12-2012","%d-%m-%Y")),
                                                                    (4,20,STR_TO_DATE("19-05-2013","%d-%m-%Y")),
                                                                    (5,50,STR_TO_DATE("19-05-2018","%d-%m-%Y")),
                                                                    (6,50,STR_TO_DATE("19-05-2015","%d-%m-%Y")),
                                                                    (7,20,STR_TO_DATE("19-05-2001","%d-%m-%Y")),
                                                                    (8,20,STR_TO_DATE("19-05-2009","%d-%m-%Y"));
                             
                             

INSERT INTO `user` (`UserType`,`username`,`password`,`LoginTimeDate`) VALUES ('USER',"jksdb","skcs",CURDATE()),
                                                                             ('USER',"jksdb","skcs",CURDATE()),
                                                                             ('USER',"jksdb","skcs",CURDATE()),
                                                                             ('USER',"jksdb","skcs",CURDATE()),
                                                                             ('USER',"jksdb","skcs",CURDATE()),
                                                                             ('USER',"jksdb","skcs",CURDATE()),
                                                                             ('USER',"jksdb","skcs",CURDATE()),
                                                                             ('USER',"jksdb","skcs",CURDATE()),
                                                                             ('USER',"jksdb","skcs",CURDATE()),
                                                                             ('ADMIN',"jksdb","skcs",CURDATE());


INSERT INTO `shopper` (`Name`) VALUES ("Akshita"),
                                      ("Komal"),
                                      ("Ram"),
                                      ("Shubham"),
                                      ("Surbhi"),
                                      ("Nikhil"),
                                      ("Pratiksha"),
                                      ("Chirag"),
                                      ("Jukker");
                                      

                                                                    
                                                                    
INSERT INTO `order` (`ShopperID`,`Status`,`Date`,`Total_Price`) VALUES (1,"Shipped",STR_TO_DATE('2018-08-15', '%Y-%m-%d'),1000);
INSERT INTO `order` (`ShopperID`,`Status`,`Date`,`Total_Price`) VALUES (3,"Shipped",STR_TO_DATE('2018-08-14', '%Y-%m-%d'),200),
                                                                                (6,"Initial",STR_TO_DATE('2018-08-14', '%Y-%m-%d'),10000),
                                                                                (7,"Shipped",STR_TO_DATE('2018-08-14', '%Y-%m-%d'),3000),
                                                                                (1,"Initial",CURDATE(),1999),
                                                                                (3,"Initial",STR_TO_DATE('2018-08-13', '%Y-%m-%d'),999),
                                                                                (5,"Shipped",STR_TO_DATE('2018-08-13', '%Y-%m-%d'),199),
                                                                                (3,"Shipped",STR_TO_DATE('2018-08-13', '%Y-%m-%d'),10000),
                                                                                (2,"Shipped",STR_TO_DATE('2018-08-13', '%Y-%m-%d'),15000),
                                                                                (7,"Initial",STR_TO_DATE('2018-08-12', '%Y-%m-%d'),1300),
                                                                                (3,"Shipped",STR_TO_DATE('2018-08-12', '%Y-%m-%d'),1934),
                                                                                (2,"Shipped",STR_TO_DATE('2018-08-12', '%Y-%m-%d'),1987),
                                                                                (1,"Shipped",STR_TO_DATE('2018-08-12', '%Y-%m-%d'),109),
                                                                                (3,"Initial",STR_TO_DATE('2018-08-11', '%Y-%m-%d'),102),
                                                                                (4,"Shipped",CURDATE(),190),
                                                                                (5,"Initial",STR_TO_DATE('2018-08-11', '%Y-%m-%d'),120),
                                                                                (6,"Shipped",STR_TO_DATE('2018-08-11', '%Y-%m-%d'),1000),
                                                                                (7,"Initial",STR_TO_DATE('2018-08-11', '%Y-%m-%d'),1500),
                                                                                (2,"Shipped",STR_TO_DATE('2018-08-11', '%Y-%m-%d'),1200),
                                                                                (1,"Shipped",STR_TO_DATE('2018-08-11', '%Y-%m-%d'),1700),
                                                                                (3,"Initial",CURDATE(),10000),
                                                                                (4,"Shipped",STR_TO_DATE('2018-08-10', '%Y-%m-%d'),10011),
                                                                                (5,"Shipped",STR_TO_DATE('2018-08-10', '%Y-%m-%d'),1004),
                                                                                (6,"Shipped",STR_TO_DATE('2018-08-10', '%Y-%m-%d'),3000),
                                                                                (1,"Initial",STR_TO_DATE('2018-08-10', '%Y-%m-%d'),3200),
                                                                                (3,"Shipped",STR_TO_DATE('2018-08-9', '%Y-%m-%d'),3100),
                                                                                (4,"Shipped",STR_TO_DATE('2018-08-9', '%Y-%m-%d'),4300),
                                                                                (6,"Shipped",STR_TO_DATE('2018-08-9', '%Y-%m-%d'),5400),
                                                                                (7,"Shipped",STR_TO_DATE('2018-08-9', '%Y-%m-%d'),1200),
                                                                                (5,"Initial",STR_TO_DATE('2018-08-9', '%Y-%m-%d'),2900),
                                                                                (5,"Shipped",STR_TO_DATE('2018-08-9', '%Y-%m-%d'),4500),
                                                                                (3,"Shipped",STR_TO_DATE('2018-08-9', '%Y-%m-%d'),3400),
                                                                                (2,"Initial",STR_TO_DATE('2018-08-8', '%Y-%m-%d'),19000),
                                                                                (1,"Shipped",STR_TO_DATE('2018-08-8', '%Y-%m-%d'),2100),
                                                                                (1,"Shipped",STR_TO_DATE('2018-08-8', '%Y-%m-%d'),999),
                                                                                (1,"Shipped",CURDATE(),9999),
                                                                                (1,"Shipped",STR_TO_DATE('2018-08-4', '%Y-%m-%d'),1234),
                                                                                (2,"Shipped",STR_TO_DATE('2018-08-4', '%Y-%m-%d'),1234),
                                                                                (2,"Initial",STR_TO_DATE('2018-08-4', '%Y-%m-%d'),145),
                                                                                (3,"Shipped",STR_TO_DATE('2018-08-4', '%Y-%m-%d'),1234),
                                                                                (4,"Initial",STR_TO_DATE('2018-08-4', '%Y-%m-%d'),1786),
                                                                                (5,"Shipped",STR_TO_DATE('2018-08-4', '%Y-%m-%d'),1123),
                                                                                (3,"Shipped",STR_TO_DATE('2018-08-4', '%Y-%m-%d'),1111),
                                                                                (3,"Initial",STR_TO_DATE('2018-08-4', '%Y-%m-%d'),4599),
                                                                                (5,"Shipped",STR_TO_DATE('2018-08-3', '%Y-%m-%d'),5999),
                                                                                (7,"Shipped",STR_TO_DATE('2018-08-3', '%Y-%m-%d'),12999),
                                                                                (7,"Initial",CURDATE(),12543),
                                                                                (7,"Shipped",STR_TO_DATE('2018-08-3', '%Y-%m-%d'),1100),
                                                                                (7,"Initial",CURDATE(),1700),
                                                                                (5,"Shipped",STR_TO_DATE('2018-07-31', '%Y-%m-%d'),1800),
                                                                                (6,"Shipped",STR_TO_DATE('2018-07-31', '%Y-%m-%d'),1200),
                                                                                (6,"Shipped",STR_TO_DATE('2018-07-31', '%Y-%m-%d'),1500),
                                                                                (6,"Initial",CURDATE(),1700),
                                                                                (1,"Shipped",STR_TO_DATE('2018-07-29', '%Y-%m-%d'),1000),
                                                                                (4,"Shipped",STR_TO_DATE('2018-07-29', '%Y-%m-%d'),1400),
                                                                                (2,"Shipped",STR_TO_DATE('2018-07-14', '%Y-%m-%d'),1400),
                                                                                (2,"Shipped",STR_TO_DATE('2018-07-4', '%Y-%m-%d'),1000),
                                                                                (2,"Shipped",STR_TO_DATE('2018-07-4', '%Y-%m-%d'),10000),
                                                                                (7,"Initial",STR_TO_DATE('2018-07-2', '%Y-%m-%d'),1100),
                                                                                (3,"Shipped",STR_TO_DATE('2018-07-2', '%Y-%m-%d'),1100),
                                                                                (3,"Initial",STR_TO_DATE('2018-07-2', '%Y-%m-%d'),1010),
                                                                                (3,"Shipped",STR_TO_DATE('2018-07-2', '%Y-%m-%d'),190);
                                                                                
INSERT INTO `ordered_product` (`OrderID`,`ProductID`,`Product_Status`,`Order_Price`) VALUES (1,1,"Shipped",500),
                                                                                        (1,2,"Initial",500),
                                                                                        (2,1,"Shipped",200),
                                                                                        (2,2,"Shipped",100),
                                                                                        (43,1,"Shipped",500),
                                                                                        (43,2,"Initial",500),
                                                                                        (43,1,"Shipped",500),
                                                                                        (44,1,"Initial",200),
                                                                                        (45,1,"Shipped",500),
                                                                                        (46,5,"Shipped",500),
                                                                                        (46,1,"Initial",500),
                                                                                        (47,1,"Shipped",500),
                                                                                        (47,1,"Shipped",500),
                                                                                        (47,1,"Shipped",500),
                                                                                        (48,1,"Initial",500),
                                                                                        (48,1,"Shipped",500),
                                                                                        (49,5,"Shipped",1500),
                                                                                        (49,3,"Shipped",500),
                                                                                        (50,1,"Initial",500),
                                                                                        (50,1,"Shipped",500),
                                                                                        (51,1,"Shipped",500),
                                                                                        (51,1,"Shipped",500);

INSERT INTO `product` (`ProductName`,`Price`) VALUES ("Pen",20),
                                                     ("Eraser",25),
                                                     ("PencilBox",30),
                                                     ("Sharpener",40);
                                                     
INSERT INTO `order` (`Status`,`Date`,`Total_Price`,`ShopperID`) VALUES ("Initial",CURDATE(),50,1);
                            
INSERT INTO `ordered_product` (`OrderID`,`ProductID`,`Order_Price`,`Product_Status`) VALUES (63,17,20,"Shipped"),
                                                                                            (63,18,25,"Initial"),
                                                                                            (63,19,30,"Shipped"),
                                                                                            (63,20,40,"Shipped");
                                                                                            