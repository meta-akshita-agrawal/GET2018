

import java.sql.Date;

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

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public void setShopperID(int shopperID) {
		this.shopperID = shopperID;
	}
}
