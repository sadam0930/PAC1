/*
Name: Steven Adam
Class: PAC 1

This class simulates interacting with a car using user input.
Car is trapped on a 20x20 grid and cannot be painted.
*/

import java.util.Scanner;
import java.util.Random;

public class Car {
	public static void main(String[] args){
		Scanner imWatchingYou = new Scanner(System.in);
		Random kgandthepowerof3 = new Random();
		boolean runProgram = true;

		boolean ignition = false;
		char color = colorAssignment(kgandthepowerof3);
		//store the position as x and y coordinates
		int xcoordinate = randomPosition(kgandthepowerof3);
		int ycoordinate = randomPosition(kgandthepowerof3);


		while(runProgram){
			System.out.println("What would you like to do?");
			System.out.println("1: turn the ignition on/off");
			System.out.println("2: change the position of car");
			System.out.println("Q: quit this program");

			String response = imWatchingYou.next();

			if(response.equalsIgnoreCase("Q")){
				runProgram = false;
			} else if(response.equals("1")){
				ignition = changeIgnition(ignition);
			} else if(response.equals("2")){
				System.out.println("In which direction would you like to move the car?");
				System.out.println("H: horizontal");
				System.out.println("V: vertical");

				response = imWatchingYou.next();

				if(response.equalsIgnoreCase("H")){
					System.out.print("How far (negative value to move left)?");
					response = imWatchingYou.next();
					//do something
				} else if(response.equalsIgnoreCase("V")){
					System.out.print("How far (negative value to move up)?");
					response = imWatchingYou.next();
					//do something
				} else {
					System.out.println("Invalid command");
				}

			} else {
				//you're doing something wrong
				System.out.println("Invalid command");
			};

			dudeWheresMyCar(xcoordinate, ycoordinate, color, ignition);
			
		};
	};

	//randomly select from array of colors
	public static char colorAssignment(Random meangirl){
		char[] colors = {'R', 'G', 'B', 'W', 'S'};
		//mean girl dictates your wardrobe
		char color = colors[meangirl.nextInt(5)];
		return color;
		//there's no pink in these choices. We wear pink on Wednesdays.
	};

	public static String whichColor(char secretCodewithoutPink){
		String notSoSecret = "";

		//let's switch it up
		switch (secretCodewithoutPink) {
			case 'R':
				notSoSecret = "Red";
				break;
			case 'G':
				notSoSecret = "Green";
				break;
			case 'B':
				notSoSecret = "Blue";
				break;
			case 'W':
				notSoSecret = "White";
				break;
			case 'S':
				notSoSecret = "Silver";
				break;
		};

		return notSoSecret;
	};

	//return position on 20x20 grid. Cannot exceed boundaries
	public static int randomPosition(Random britneySpears){
		return britneySpears.nextInt(21);
		//britney is unpredictable
	};

	public static boolean changeIgnition(boolean ignitionState){
		if(ignitionState == true){
			ignitionState = false;
		} else { //if it's not on then it's off
			//so turn it on
			ignitionState = true;
		};
		return ignitionState;
	};

	//translate the boolean into a human readable string
	public static String amIBurningFossilFuels(boolean carIgnition){
		String returnMessage = "";

		if(carIgnition){
			returnMessage = "on";
		} else {
			returnMessage = "off";
		};

		return returnMessage;
	};

	//for those following along this method helps this dude find his car
	public static void dudeWheresMyCar(int x, int y, char color, boolean isItOn){
		System.out.println("Car Information"); //car facts
		System.out.println("Color: " + whichColor(color));
		System.out.println("Ignition: " + amIBurningFossilFuels(isItOn));
		System.out.println("Location: (" + x + ", " + y + ")");
		//do something
	};
};