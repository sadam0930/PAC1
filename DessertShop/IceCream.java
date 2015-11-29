/*
Name: Steven Adam
Class: PAC 1
This package represents a shop that sells desserts by the pound.
*/

public class IceCream extends DessertItem {
	private int price;

	public IceCream(String name, int price){
		super(name);
		this.price = price;
	}

	public int getCost(){
		return price;
	}

	public String toString(){
		String message = Checkout.spacesForReceipt(name, DessertShoppe.cents2dollarsAndCents(getCost()));

		return message;
	}	

}