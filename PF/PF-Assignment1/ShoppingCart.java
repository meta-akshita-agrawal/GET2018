package assignment1;

import java.util.HashMap;
import java.util.Map;
public class ShoppingCart {
	
	//display the whole cart with items and their respective prices
	public void show(Map<String, Integer> cart){
	    System.out.println(cart);
	}
	
	
	//stores item in the cart
	public void add(Map<String, Integer> cart, String item, int price){
	    cart.put(item,price);
	}
	
	//updates price of an item in the cart.
	public void update(Map <String, Integer> cart, String item, int price){
	    cart.put(item,price);
	}
	
	//remove items from the cart.
	public void remove(Map<String, Integer> cart, String item){
	    cart.remove(item);
	}
	
	//returns the total bill of the items in cart
	public int bill(Map<String, Integer> cart) {
		int total = 0;
		for(int price: cart.values()) {
			total += price;
		}
		return total;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> cart = new HashMap<>();
		ShoppingCart s = new ShoppingCart();
		s.add(cart,"toothpaste",30);
		s.add(cart,"juice",80);
		s.remove(cart,"juice");
		s.add(cart,"toothpaste",40);
		s.add(cart,"brush", 20);
		s.show(cart);
		System.out.println(s.bill(cart));
	}

}