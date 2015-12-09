/**
* Steven Adam
* PAC 1
* This class evaluates an infix expression by converting to postfix and using a stack to evaluate
**/

import java.util.Stack;
import java.util.Scanner;

public class Calculator {
	public static double evaluate(String expression) throws PostFixException {
		double result =	 0;
		
		Stack<Double> intStack = new Stack<Double>();

		Converter converter = new Converter(expression);
		String postfix = converter.toPostFix(); 
		System.out.println("converted to postfix: " + postfix);
		Scanner tokenizer = new Scanner(postfix);
		
		String operator;
		double op1, op2;

		while(tokenizer.hasNext()){
			if(tokenizer.hasNextInt()){
				double aNumber = tokenizer.nextInt();
				intStack.push(aNumber);
			} else {
				operator = tokenizer.next();

				if(intStack.empty()){
					throw new PostFixException("Not enough operands - stack underflow");
				}
				op2 = intStack.pop();

				if(intStack.empty()){
					throw new PostFixException("Not enough operands - stack underflow");
				}
				op1 = intStack.pop();

				if(converter.isOperator(operator.charAt(0))){
					result = operate(operator, op1, op2);	
				} else {
					throw new PostFixException("Illegal symbol: " + operator);
				}
				intStack.push(result);
			}
		}

		//Obtain final result from stack
		if(intStack.empty()){
			throw new PostFixException("Not enough operands - stack underflow");
		}
		result = intStack.pop();

		//Stack should now be empty
		if(!intStack.empty()){
			throw new PostFixException("Too many operands - operands left over");
		}

		return result;
	}

	private static double operate(String operator, double op1, double op2){
		switch(operator){
			case "+":
				return op1 + op2;
			case "-":
				return op1 - op2;
			case "*":
				return op1 * op2;
			case "/":
				return op1 / op2;
			case "^":
				return Math.pow(op1,op2);
			default:
				return -1; //something messed up, this should never happen
		}
	}

	public static class PostFixException extends Exception {
		public PostFixException(String message){
			super(message);
		}
	}

	public static void main(String[] args){
		String infix;
		String more;
		
		Scanner input = new Scanner(System.in);

		do {
			System.out.println("type your infix expression");
			infix = input.nextLine();
			System.out.println();
			
			try {
				double result = evaluate(infix);
				System.out.println();
				System.out.println("answer is " + result);
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