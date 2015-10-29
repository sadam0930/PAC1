/**
* PAC 1
* Steven Adam
**/

import java.util.Scanner;

public class TestSmallInt {
	public static void main (String [] args){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Select a number between 0 - " + SmallInt.MAXVALUE + ": ");
		int response = sc.nextInt();

		SmallInt smurf = new SmallInt(response);
		
		System.out.println("Number in decimal: " + smurf.getDec());
		System.out.println("Number in binary: " + smurf.getBin());
		System.out.println("Number in hexadecimal: " + smurf.getHex());
	}
}