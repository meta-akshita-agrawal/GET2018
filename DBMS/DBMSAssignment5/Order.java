package jdbc;

import java.util.Date;

//POJO ORDER
public class Order {

	int orderID;
	String status;
	Date date;
	float totalPrice;
	int shopperID;
	
	Order(int orderID,Date date, float totalPrice){
		this.orderID = orderID;
		this.date = date;
		this.totalPrice = totalPrice;
	}
	
	public int getOrderID() {
		return orderID;
	}

	public String getStatus() {
		return status;
	}

	public Date getDate() {
		return date;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public int getShopperID() {
		return shopperID;
	}
}