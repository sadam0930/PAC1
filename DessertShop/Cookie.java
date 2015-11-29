/*
Name: Steven Adam
Class: PAC 1
This package represents a shop that sells desserts by the pound.
*/

public class Cookie extends DessertItem {
	private int numCookies;
	private int pricePerDozen;

	public Cookie(String name, int numCookies, int pricePerDozen){
		super(name);
		this.numCookies = numCookies;
		this.pricePerDozen = pricePerDozen;
	}

	public int getCost(){
		return (int)Math.round(numCookies*(pricePerDozen/12.0));
	}

	public String toString(){
		String message = "" + numCookies + " @ " 
			+ DessertShoppe.cents2dollarsAndCents(pricePerDozen) + " /dz.\n" 
			+ Checkout.spacesForReceipt(name, DessertShoppe.cents2dollarsAndCents(getCost()));

		return message;
	}	

}