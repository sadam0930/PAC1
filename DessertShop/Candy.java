/*
Name: Steven Adam
Class: PAC 1
This package represents a shop that sells desserts by the pound.
*/

public class Candy extends DessertItem {
	private double weight; //in pounds
	private int pricePerPound; //in cents

	public Candy(String name, double weight, int pricePerPound){
		super(name);
		this.weight = weight;
		this.pricePerPound = pricePerPound;
	}

	public int getCost(){
		return (int)Math.round(weight*pricePerPound);
	}

	public String toString(){
		String message = "" + extraZero(weight) + " lbs. @ " 
			+ DessertShoppe.cents2dollarsAndCents(pricePerPound) + " /lb.\n" 
			+ Checkout.spacesForReceipt(name, DessertShoppe.cents2dollarsAndCents(getCost()));

		return message;
	}

	//just for the sake of formatting
	private String extraZero(double weight){
		String w = "" + weight;
		if(w.length() < 4){
			return w += 0;
		} else {
			return w;
		}
	}

}