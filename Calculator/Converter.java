/**
* Steven Adam
* PAC 1
* This class converts infix to postfix notation using a stack
**/
import java.util.Stack;
import java.util.Scanner;

public class Converter {
	public static String expression;

	public Converter(String expression){
		this.expression = expression;
	}

	public String toPostFix() throws Calculator.PostFixException{
		Stack<Character> operatorStack = new Stack<Character>();
		String output = "";

		for(int i=0; i<expression.length();i++){
			char token = expression.charAt(i);

			if(token == ' '){
				//do nothing
			} else if(token == '('){
				operatorStack.push(token);
			} else if(token == ')'){
				while(!operatorStack.empty() && operatorStack.peek() != '('){
					output += " ";
					output += operatorStack.pop();
				}
				if(operatorStack.empty()){
						throw new Calculator.PostFixException("Opening parenthesis not found - stack underflow");
				} else {
					//throw away parenthesis
					operatorStack.pop(); 
				}
			} else if(isOperator(token)){
					while(!operatorStack.empty() && !isLowerPrecedence(token, operatorStack.peek())) {
						output += " ";
						output += operatorStack.pop();
					}
				output += " ";
				operatorStack.push(token);
			} else { //assume numeric input
				output += token;
			}
		}

		while(!operatorStack.empty()){
			output += " ";
			output += operatorStack.pop();
		}

		return output;
	}

	//test if operator on top of stack is of lower precendence than the given operator
	private boolean isLowerPrecedence(char op, char topStack){
		boolean stackIsLower;
		if(topStack == '('){
			stackIsLower = true;
		} else if((op == '*' || op == '/') && !(topStack == '^' || topStack == '*' || topStack == '/')) {
			stackIsLower = true;
		} else if(op == '^' && topStack != '^') {
			stackIsLower = true;
		} else {
			stackIsLower = false;
		} 
		return stackIsLower;
	}

	public boolean isOperator(char o){
		if(o == '+' || o == '-' || o == '*' || o == '/' || o == '^'){
			return true;
		} else {
			return false;
		}
	}
}