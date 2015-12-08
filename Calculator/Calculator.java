/**
* Steven Adam
* PAC 1
* This class evaluates an infix expression by converting to postfix and using a stack to evaluate
**/

import java.util.Stack;
import java.util.Scanner;

public class Calculator {
	public static int evaluate(String expression) throws PostFixException {
		int result;
		Converter converter = new Converter(expression);
		String postfix = converter.toPostFix(); 

		return result;
	}

	private class PostFixException extends Exception {
		public PostFixException(String message){
			super(message);
		}
	}

	public static void main(String[] args){
		String infix;
		String more;
		
		Scanner input = new Scanner(System.in);

		do {
			System.out.print("Enter an infix expression to be evaluated: ");
			infix = input.nextLine();

			try {
				int result = evaluate(infix);
				System.out.println();
				System.out.println("Result = " + result);
			} catch(PostFixException e){
				System.out.println();
				System.out.println("Error in expression - " + e.getMessage());
			}

			System.out.println();
			System.out.print("Evaluate another expression? (Y=Yes): ");
			more = input.nextLine();
			System.out.println();
		} while (more.equalsIgnoreCase("y"));
	}
}