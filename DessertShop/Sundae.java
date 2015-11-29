/*
Name: Steven Adam
Class: PAC 1
This package represents a shop that sells desserts by the pound.
*/

public class Sundae extends IceCream {
	private String topping;
	private int toppingPrice;

	public Sundae(String iceCreamName, int iceCreamPrice, String topping, int toppingPrice){
		super(iceCreamName, iceCreamPrice);
		this.topping = topping;
		this.toppingPrice = toppingPrice;
	}

	public int getCost(){
		return super.getCost() + toppingPrice;
	}

	public String toString(){
		String message = topping + " Sundae with\n"
			+ Checkout.spacesForReceipt(name, DessertShoppe.cents2dollarsAndCents(getCost()));

		return message;
	}	

}