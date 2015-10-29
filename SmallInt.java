/**
* PAC 1
* Steven Adam
**/

public class SmallInt {
	private int value = 0;
	public static int MAXVALUE = 1000;

	public SmallInt(int input){
		setDec(input);
	}

	public String getDec(){
		return "" + this.value;
	}

	public void setDec(int input){
		if(input < 0 || input > MAXVALUE){
			System.out.println("Invalid input. Assigning value as zero.");
			//value initialized as zero by default
		} else {
			this.value = input;
		}
	}

	/**
	* This method takes decimal value and converts it into binary by looping through
	* the value and using modulo 2 to get each bit from right to left. 
	* ex: 
	* 100 in dec is represented as 1100100 in binary
	* (right most bit) 100%2 = 0; 
	* (what's left over) 100/2 = 50;
	* (second to right most bit) 50%2 = 0;
	* (what's left over) 50/2 = 25;
	* (third to right most bit) 25%2 = 1;
	* (what's left over) 25/2 = 12;
	* (fourth from right most bit) 12%2 = 0;
	* (what's left over) 12/2 = 6;
	* (fifth to right most bit) 6%2 = 0;
	* (what's left over) 6/2 = 3;
	* (sixth from right most bit) 3%2 = 1;
	* (what's left over) 3/2 = 1;
	* (seventh from right most bit) 1%2 = 1;
	* (what's left over) 1/2 = 0;
	* When nothing is left over the loop ends.
	**/
	public String getBin(){
		String bin = "";
		int leftover = this.value;
		
		do{
			//first bit value is the remainder after dividing by 2
			int bit = leftover % 2;
			//quotient is what is left over after getting the first bit value
			int quo = leftover / 2;
			//place bit in leftmost position
			bin = bit + bin; 
			//reduce the left over dec value remaining
			leftover = quo;
		} while(leftover > 0);

		return bin;
	}

	/**
	* This method takes decimal value and converts it into hexadecimal by looping through
	* the value and using modulo 16 to get each bit from right to left. 
	* ex: 
	* 740 in dec is represented as 1100100 in hexadecimal
	* (right most bit) 740%16 = 4; 
	* (convert to hex) 4 -> 4;
	* (what's left over) 740/16 = 46;
	* (second to right most bit) 46%16 = 14;
	* (convert to hex) 14 -> e;
	* (what's left over) 46/16 = 2;
	* (third to right most bit) 2%16 = 2;
	* (convert to hex) 2 -> 2;
	* (what's left over) 2/16 = 0;
	* When nothing is left over the loop ends.
	**/
	public String getHex(){
		String hex = "";
		
		int leftover = this.value;
		
		do{
			//first bit value is the remainder after dividing by 16
			int tmp = leftover % 16;

			//convert the tmp bit to hex value
			char bit;
			switch(tmp){
				case 10:
					bit = 'a';
					break;
				case 11:
					bit = 'b';
					break;
				case 12:
					bit = 'c';
					break;
				case 13:
					bit = 'd';
					break;
				case 14:
					bit = 'e';
					break;
				case 15:
					bit = 'f';
					break;
				default:
					bit = (char)(tmp + '0'); //adjust int to char ASCII offset
					break;
			}

			//quotient is what is left over after getting the first bit value
			int quo = leftover / 16;
			//place bit in leftmost position
			hex = bit + hex; 
			//reduce the left over dec value remaining
			leftover = quo;
		} while(leftover > 0);

		return hex;
	}

}