CREATE TABLE `user` (
  `idUser` int(11) NOT NULL UNIQUE AUTO_INCREMENT,
  `UserType` enum('USER','ADMIN') NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `LoginTimeDate` datetime NOT NULL,
  PRIMARY KEY (`idUser`)
);


CREATE TABLE `product` (
  `ProductID` int(11) UNIQUE NOT NULL AUTO_INCREMENT,
  `ProductName` varchar(45) NOT NULL,
  `Price` float NOT NULL,
  PRIMARY KEY (`ProductID`)
);

CREATE TABLE `gallery` (
  `ImageID` int(11) UNIQUE NOT NULL AUTO_INCREMENT,
  `ProductID` int(11) NOT NULL,
  `ImagLocation` varchar(50) NOT NULL,
  PRIMARY KEY (`ImageID`),
  CONSTRAINT `product_ID` FOREIGN KEY (`ProductID`) REFERENCES `product` (`ProductID`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `category` (
  `CategoryID` int(11) UNIQUE NOT NULL AUTO_INCREMENT,
  `Category_Name` varchar(45) NOT NULL,
  `Parent_CategoryID` varchar(45),
  PRIMARY KEY (`CategoryID`)
);

CREATE TABLE `product_category` (
  `Product_CategoryID` int(11) NOT NULL UNIQUE AUTO_INCREMENT,
  `CategoryID` int(11) NOT NULL,
  `ProductID` int(11) NOT NULL,
  PRIMARY KEY (`Product_CategoryID`),
  CONSTRAINT `CategoryID` FOREIGN KEY (`CategoryID`) REFERENCES `category` (`CategoryID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ProductID` FOREIGN KEY (`ProductID`) REFERENCES `product` (`ProductID`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `shopper` (
  `ShopperID` int(11) NOT NULL UNIQUE AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  PRIMARY KEY (`ShopperID`),
  CONSTRAINT `shopperUserId` FOREIGN KEY (`ShopperID`) REFERENCES `user` (`idUser`)
);


CREATE TABLE `address`(
   `AddressID` int(11) NOT NULL UNIQUE AUTO_INCREMENT,
   `ZipCode` varchar(45) NOT NULL,
   `Street` varchar(45) NOT NULL,
   `City` varchar(20) NOT NULL, 
   `ShopperID` int(11) NOT NULL,
   PRIMARY KEY (`AddressID`),
   CONSTRAINT `shopperIDAddress` FOREIGN KEY (`ShopperID`) REFERENCES `shopper` (`ShopperID`)
);

CREATE TABLE `order`(
    `OrderID` int(11) NOT NULL UNIQUE AUTO_INCREMENT,
    `Status` varchar(45) NOT NULL,
    `Date` date NOT NULL,
    `Total_Price` float NOT NULL,
    `ShopperID` int(11) NOT NULL,
    PRIMARY KEY (`OrderID`),
    CONSTRAINT `shopperIDOrder` FOREIGN KEY (`ShopperID`) REFERENCES `shopper` (`ShopperID`)
    
);

CREATE TABLE `ordered_product`(
    `Order_ProductID` int(11) NOT NULL UNIQUE AUTO_INCREMENT,
    `OrderID` int(11) NOT NULL,
    `ProductID` int(11) NOT NULL,
    `Order_Price` float NOT NULL,
    `Product_Status` varchar(45) NOT NULL,
    PRIMARY KEY (`Order_ProductID`),
    CONSTRAINT `OrdIDOrderProd` FOREIGN KEY (`OrderID`) REFERENCES `order` (`OrderID`),
    CONSTRAINT `ShopIDOrderProd` FOREIGN KEY (`ProductID`) REFERENCES `product` (`ProductID`)
);

CREATE TABLE `stock` (
    `ProductID` int(11) NOT NULL,
    `Quantity` int(11) NOT NULL,
    `AddedDate` DATE NOT NULL,
    CONSTRAINT `stockProductID`FOREIGN KEY (`ProductID`) REFERENCES `product` (`ProductID`)
);
