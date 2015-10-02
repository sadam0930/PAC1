import java.util.Scanner;

public class Calculator {
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		String operation = "";
		double output;
		double nextInput;

		System.out.print("1st input: ");
		output = sc.nextFloat();

		System.out.print("op: ");
		operation = sc.next();
		
		//runs outside of loop in order to do first computation
		if(operation.equals("c")){
			output = 0.0;
			System.out.println("ans: " + output);
		} else if(operation.equals("x")) {
			//do nothing; system will quit
		} else { //handles all other operations
			System.out.print("2nd input: ");
			nextInput = sc.nextFloat();

			if(operation.equals("+")) {
				output += nextInput;
				System.out.println("ans: " + output);
			} else if(operation.equals("-")) {
				output -= nextInput;
				System.out.println("ans: " + output);
			} else if(operation.equals("*")) {
				output *= nextInput;
				System.out.println("ans: " + output);
			} else if(operation.equals("/")) {
				if(nextInput != 0) {
					output /= nextInput;
					System.out.println("ans: " + output);
				} else {
					System.out.println("Error: division by zero");
				}
			} else {
				System.out.println("Error: Unknown operator " + operation);
			};
		};

		//repeat above steps with new prompt "more input: "
		while(!operation.equals("x")) {
			System.out.print("op: ");
			operation = sc.next();
			
			if(operation.equals("c")){
				output = 0.0;
				System.out.println("ans: " + output);
			} else if(operation.equals("x")) {
				//do nothing; system will quit
			} else { //handles all other operations
				System.out.print("more input: ");
				nextInput = sc.nextFloat();

				if(operation.equals("+")) {
					output += nextInput;
					System.out.println("ans: " + output);
				} else if(operation.equals("-")) {
					output -= nextInput;
					System.out.println("ans: " + output);
				} else if(operation.equals("*")) {
					output *= nextInput;
					System.out.println("ans: " + output);
				} else if(operation.equals("/")) {
					if(nextInput != 0) {
						output /= nextInput;
						System.out.println("ans: " + output);
					} else {
						System.out.println("Error: division by zero");
					}
				} else {
					System.out.println("Error: Unknown operator " + operation);
				};
			};
		};
	}
}