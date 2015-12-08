/**
* Steven Adam
* PAC 1
* This class evaluates an infix expression by converting to postfix and using a stack to evaluate
**/

import java.util.Stack;
import java.util.Scanner;

public class Calculator {
	public static int evaluate(String expression) throws PostFixException {
		double result =  = 0;
		
		Stack<Integer> intStack = new Stack<Integer>();

		Converter converter = new Converter(expression);
		String postfix = converter.toPostFix(); 
		Scanner tokenizer = new Scanner(postfix);
		
		String operator;
		double op1, op2;

		while(tokenizer.hasNext()){
			if(tokenizer.hasNextInt()){
				int aNumber = tokenizer.nextInt();
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
		if(stack.empty()){
			throw new PostFixException("Not enough operands - stack underflow");
		}
		result = stack.pop();

		//Stack should now be empty
		if(!stack.empty()){
			throw new PostFixException("Too many operands - operands left over");
		}

		return result;
	}

	private operate(String operator, double op1, double op2){
		switch(operator){
			case "+":
				return op1 + op2;
				break;
			case "-":
				return op1 - op2;
				break;
			case "*":
				return op1 * op2;
				break;
			case "/":
				return op1 / op2;
				break;
			case "^":
				return Math.pow(op1,op2);
				break;
		}
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