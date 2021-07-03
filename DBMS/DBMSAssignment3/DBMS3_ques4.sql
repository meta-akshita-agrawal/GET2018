/*Creates a database table having zip codes with associated state and city*/
CREATE TABLE ADDRESS_DATABASE(
	ZipCodePrefix int(2) NOT NULL unique,
    State varchar(45) NOT NULL,
    City varchar(45) NOT NULL,
	PRIMARY KEY(ZipCodePrefix)
);

/*Creates a from table with foreign key of beginning 3 digits of zip code*/
CREATE TABLE User_form(
	UserID int(11) NOT NULL UNIQUE AUTO_INCREMENT,
    FirstName varchar(45) NOT NULL,
    SurName varchar(45),
    ZipCodePrefix int(2) NOT NULL,
    ZipCodeSuffix int(4) NOT NULL,
    Street varchar(45) NOT NULL,
    PRIMARY KEY(`UserID`),
    CONSTRAINT zipcode_addressdb FOREIGN KEY(`ZipCodePrefix`) REFERENCES `address_database` (`ZipCodePrefix`)
);


INSERT INTO `address_database` (ZipCodePrefix,State,City) VALUES (30,"Rajasthan","Jaipur"),
																 (40,"Maharashtra","Mumbai"),
                                                                 (11,"Haryana","Delhi"),
                                                                 (56,"Karnataka","Bengaluru"),
                                                                 (41,"Maharashtra","Pune");

INSERT INTO `user_form` (FirstName,ZipCodePrefix,ZipCodeSuffix,Street) VALUES ("Akshita",30,2002,"Amer Road"),
																			  ("Komal",30,2022,"Sitapura Industrial Area"),
                                                                              ("Aayushi",40,0701,"Ghansoli");
                                                                              
/* query that returns a Resultset containing Zip Code, City Names and
         States ordered by State Name and City Name.
*/                                                                              
SELECT * FROM `address_database`
ORDER BY `State`,`City`;