package assignment1;
import java.util.ArrayList;
import java.util.Scanner;
//import java.time.format.DateTimeFormatter;  
//import java.time.LocalDateTime;  
//import java.util.List;

class Item{
	int id;
	String ItemName;
	double price;
	int quantity;
	
	//Constructor
	public Item(int id, String ItemName, double price, int quantity){
		this.id = id;
		this.ItemName = ItemName;
		this.price = price;
		this.quantity = quantity;
	}
	
	//Returns quantity of the specified item.
	public int getQuantity(){
		return this.quantity;
	}
	
	//Set the value of quantity 
	public void setQuantity(int quantity){
		this.quantity = quantity;
	}
	
	//Returns the name of the item of the specified id of an item.
	public String getItemName(){
		return this.ItemName;
	}
	
	//Returns the price of specified id of an item.
	public double getPrice(){
		return this.price;
	}
	
	//Returns id
	public int getId(){
		return this.id;
	}
	
}


//Store contains the items and their details available
class Store{
	public static ArrayList<Item> Items = new ArrayList<Item>();
	
	//Initializes all items in the store.
	public static void Initialize(){
		Items = new ArrayList<Item>();
		Items.add(new Item(1,"flour",30.00,7));
		Items.add(new Item(2,"brush",20.00,10));
		Items.add(new Item(3,"bag",150.50,8));
		Items.add(new Item(4,"juice",50.25,20));
		Items.add(new Item(5,"bottle",80.05,10));
	}
	
	//Displays all store items
	public static void displayStore(){
		System.out.println("----------------STORE-----------------");
		System.out.println("ID\tNAME\t\tPRICE\tQUANTITY");
		System.out.println("--------------------------------------");
		for(Item s: Items){
			System.out.println(s.id + "\t" + s.ItemName + "\t" + s.price + "\t" + s.quantity);
		}
		System.out.println("--------------------------------------");
	}
	
	//Change according to quantity added in the cart.
	public static void LeftQuantity(int id,int quantity){
		int availableQuantity= Items.get(getIndexStore(id)).getQuantity() - quantity;
		Items.get(getIndexStore(id)).setQuantity(availableQuantity);
		if(availableQuantity==0){
			Items.remove(getIndexStore(id));//Deletes item from store if quantity becomes 0.		
	
		}
	}
	
	//Returns bill for one item.
	public static double itemPrice(double price,int quantity){
		double itemPrice = price * quantity;
		return itemPrice;
	}
	
	//returns the index of id item.
	public static int getIndexStore(int id){
			for (int i = 0; i < Store.Items.size(); i++) {
	        Item index = (Item) Store.Items.get(i);
	        if (id == index.getId()) {
	            return i;
	        }
	    }
	    System.out.println("\n" + "Item " + id + " wasn't found in the store.");
	    return -1;
	}
	
	//Checks if store contains a particular item.
	public static boolean storeContains(int id){

	    for (int i = 0; i < Store.Items.size(); i++) {
	        Item index = (Item) Store.Items.get(i);
	        if (id == index.getId()) {
	            return true;
	        }
	    }
	    return false;
	}

}

class ShoppingCart{
	

	public static ArrayList<Item> CartItems = new ArrayList<Item>();
	
	//Adds id item  in the cart with needed quantity. 
	public boolean add(int id, int quantity){
		CartItems.add(new Item(id,Store.Items.get(Store.getIndexStore(id)).getItemName(), Store.Items.get(Store.getIndexStore(id)).getPrice(), quantity));
		Store.LeftQuantity(id, quantity);
		return true;
	}
	
	//Removes Item from the Cart.
	public void remove(int id, int quantity){
		if(Store.storeContains(id)){
			int updatedQuantity = Store.Items.get(Store.getIndexStore(id)).getQuantity() + quantity;
			Store.Items.get(Store.getIndexStore(id)).setQuantity(updatedQuantity);
		}
		else{
			Store.Items.add(new Item(id,CartItems.get(getIndexCart(id)).getItemName(), CartItems.get(getIndexCart(id)).getPrice(), quantity));
		}
		CartItems.get(getIndexCart(id)).setQuantity(CartItems.get(getIndexCart(id)).getQuantity() - quantity);
		if(CartItems.get(getIndexCart(id)).getQuantity() == 0){
			CartItems.remove(getIndexCart(id));
		}
	}
	
	//Returns index of the item in cart.
	public static int getIndexCart(int id){
			for (int i = 0; i < ShoppingCart.CartItems.size(); i++) {
	        Item index = (Item) ShoppingCart.CartItems.get(i);
	        if (id == index.getId()) {
	            return i;

	        }
	    }
	    System.out.println("\n" + "Item " + id + " wasn't found in the cart.");
	    return -1;
	}
	
	//Display the items in the cart.
	public void displayCart(){
		System.out.println("----------------CART-----------------");
		System.out.println("ID\tNAME\t\tPRICE\tQUANTITY");
		System.out.println("--------------------------------------");
		for(Item s: CartItems){
			System.out.println(s.id + "\t" + s.ItemName + "\t" + s.price + "\t" + s.quantity);
		}
		System.out.println("--------------------------------------");
	}
	
	//Generates bill for whole cart.
	public double bill(){
		double total=0;
		for(Item i: CartItems){
			total += Store.itemPrice(i.price,i.quantity);
		}
		return total;
	}
}

/*class PromotionEnum{
	String ItemName;
	String code;
	String startDate;
	String endDate;
	
}

interface Promotion{
	
	ShoppingCart shca = new ShoppingCart();
	double getMinimumPrice();
	void setMinimumPrice(double price);
	double getFixedDiscount();
	void setFixedDiscount(double discount);
	boolean isPromotionApplicable();
	
}

class FixedProductPromotion implements Promotion{
 
	double minimumPrice;
	double discount;
	
	public ArrayList<String> PromotionItems = new ArrayList<String>();
	
	public double getMinimumPrice() {
		return minimumPrice;
	}
	
	public void setMinimumPrice(double price) {
		minimumPrice= price;
	}
	
	public double getFixedDiscount() {
		return discount;
	}
	
	public void setFixedDiscount(double discount) {
		this.discount = discount;
	}
	public boolean isPromtionApplicable(){
		if (shca.CartItems.contains(shca.getIndexCart()))
	}
	
}

class FixedOrderPromotion implements Promotion{
 
	double minimumPrice;
	double discount;
	public double getMinimumPrice() {
		return minimumPrice;
	}
	
	public void setMinimumPrice(double price) {
		minimumPrice= price;
	}
	
	public double getFixedDiscount() {
		return discount;
	}
	
	public void setFixedDiscount(double discount) {
		this.discount = discount;
	}
	public boolean isPromtionApplicable(){
		if(get)
	}
	
}
*/


class Program{
		public static void main(String[] args){
			ShoppingCart dc = new ShoppingCart();
			Store.Initialize();
			
			/*FixedProductPromotion fp = new FixedProductPromotion();
			
			fp.PromotionItems.add("brush");
			fp.PromotionItems.add("flour");
			fp.PromotionItems.add("juice");
			fp.setMinimumPrice(300);
			fp.setFixedDiscount(40);*/
			

			
			
			
			
			
			Scanner sc = new Scanner(System.in);
			char ch;
			do{
				System.out.println("1.Display the Store.");
				System.out.println("2.Display the Cart");
				System.out.println("3.Add an item in the cart.");
				System.out.println("4.Remove item from the cart.");
				System.out.println("5.Genrate bill.");
				System.out.println("6.Apply promo code");
				
				
				
				System.out.println("Enter your choice");
				
				
				int choice = sc.nextInt();
				
				switch(choice){
				
					case 1:
						Store.displayStore();
						break;
					case 2:
						dc.displayCart();
						break;
					case 3:
						System.out.println("Enter id and quantity of ihe item you want to add.");
						int addId = sc.nextInt();
						int addQuantity = sc.nextInt();
						dc.add(addId, addQuantity);
						break;
					case 4:
						System.out.println("Enter id and quantity you want to remove.");
						int removeId = sc.nextInt();
						int removeQuantity = sc.nextInt();
						dc.remove(removeId, removeQuantity);
						break;
					case 5:
						System.out.println("Your current bill is " + dc.bill());
						break;
					case 6:
						
						
					default: 
						System.out.println("Wrong choice");
						break;
				}
						System.out.println("Enter y if you want to continue");
						ch = sc.next().charAt(0);
				
			}while (ch =='Y' || ch =='y');
			sc.close();
	}
		
	
}

	

