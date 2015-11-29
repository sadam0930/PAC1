public class Checkout {
	private final int MAXCARTSIZE = 100;
	private DessertItem[] cart;
	private int numberOfItems;

	public Checkout(){
		this.cart = new DessertItem[MAXCARTSIZE];
		this.numberOfItems = 0;
	}

	public int numberOfItems(){
		return numberOfItems;
	}

	public void enterItem(DessertItem item){
		cart[numberOfItems] = item;
		numberOfItems++;
	}

	public void clear(){
		cart = new DessertItem[MAXCARTSIZE];
		numberOfItems = 0;
	}

	public int totalCost(){
		int totalCost = 0;

		for(int i=0; i < MAXCARTSIZE; i++){
			DessertItem item = cart[i];
			if(item != null){
				totalCost += item.getCost();
			}
		}

		return totalCost;
	}

	public int totalTax(){
		int totalTax = (int)Math.round(totalCost() * DessertShoppe.TAX_RATE/100);
		return totalTax;
	}

	public String toString(){
		String message = "\n     " + DessertShoppe.STORE_NAME + "\n"
			+ "     --------------------\n"
			+ "\n";
		
		for(int i=0; i<MAXCARTSIZE; i++){
			DessertItem item = cart[i];
			if(item != null){
				message += item.toString();
			}
		}

		message += "\n";
		message += spacesForReceipt("Tax", DessertShoppe.cents2dollarsAndCents(totalTax()));
		message += spacesForReceipt("Total Cost", DessertShoppe.cents2dollarsAndCents(totalCost() + totalTax()));

		return message;
	}

	/*
		This method prints out an evenly spaced line beginning with a name and ending with the cost
	*/
	public static String spacesForReceipt(String itemName, String itemCost){
		String spaces = itemName;
		
		//calculate number of spaces to make receipt consistent
		String currentSpace = itemName + itemCost;
		int numSpaces = DessertShoppe.MAX_ITEM_NAME_SIZE + DessertShoppe.COST_WIDTH - currentSpace.length();
		for(int i=0; i<numSpaces; i++){
			spaces += " ";
		}

		spaces += itemCost + "\n";

		return spaces;
	}
}