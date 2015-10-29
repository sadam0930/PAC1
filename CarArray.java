/*
Name: Steven Adam
Class: PAC 1
This class simulates interacting with numerous cars using user input.
Cars are trapped on a 20x20 grid and cannot be painted.
*/

import java.util.Scanner;
import java.util.Random;

public class CarArray {
	public static void main(String[] args){
		final int numCars = 10;

		Scanner imWatchingYou = new Scanner(System.in);
		Random kgandthepowerof3 = new Random();
		boolean runProgram = true;

		boolean[] ignition = new boolean[numCars]; //default is off
		char[] color = colorAssignment(kgandthepowerof3, numCars);
		//store the position as x and y coordinates
		int[] xcoordinate = randomPosition(kgandthepowerof3, numCars);
		int[] ycoordinate = randomPosition(kgandthepowerof3, numCars);


		while(runProgram){
			System.out.println("Which car would you like to use next (1-10)?");
			System.out.println("Or Select Q to quit");

			String carChoice = imWatchingYou.next();

			if(carChoice.equalsIgnoreCase("1") || carChoice.equalsIgnoreCase("2") ||
				carChoice.equalsIgnoreCase("3") || carChoice.equalsIgnoreCase("4") ||
				carChoice.equalsIgnoreCase("5") || carChoice.equalsIgnoreCase("6") ||
				carChoice.equalsIgnoreCase("7") || carChoice.equalsIgnoreCase("8") ||
				carChoice.equalsIgnoreCase("9") || carChoice.equalsIgnoreCase("10")) {

				System.out.println("What would you like to do next " +
					"(1 - change ignition; 2 - change position of car; 3 - quit this program)?");

				String response = imWatchingYou.next();

				if(response.equalsIgnoreCase("3")){
					runProgram = false;
				} else if(response.equals("1")){
					changeIgnition(ignition, carChoice, numCars);
				} else if(response.equals("2")){
					System.out.println("What direction would you like to move the car " +
						"(1 - horizontal; 2 - vertical)?");

					response = imWatchingYou.next();

					if(response.equalsIgnoreCase("1")){
						System.out.print("How far (negative value to move left)?");
						response = imWatchingYou.next();
						moveRightOrToYourOtherRight(response, xcoordinate, ignition, carChoice, numCars);
					} else if(response.equalsIgnoreCase("2")){
						System.out.print("How far (negative value to move up)?");
						response = imWatchingYou.next();
						moveUpOrDown(response, ycoordinate, ignition, carChoice, numCars);
					} else {
						System.out.println("Invalid command");
					}

				} else {
					//you're doing something wrong
					System.out.println("Invalid command");
				};

				dudeWheresMyCar(xcoordinate, ycoordinate, color, ignition, carChoice, numCars);
			} else if(carChoice.equalsIgnoreCase("Q")){
				runProgram = false;
			} else {
				System.out.println("Invalid command");
			}
			
		};
	};

	//randomly select from array of colors and assign to each car
	public static char[] colorAssignment(Random meangirl, int numCars){
		char[] colors = {'R', 'G', 'B', 'W', 'S'};
		char[] carColors = new char[numCars];
		for(int i=0;i<numCars;i++){
			//mean girl dictates your wardrobe
			carColors[i] = colors[meangirl.nextInt(5)];
		}
		return carColors;
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
	public static int[] randomPosition(Random britneySpears, int numBackupDancers){
		int[] dancePositions = new int[numBackupDancers];
		for(int i=0;i<numBackupDancers;i++){
			//generate random int between 1-20 inclusive
			dancePositions[i] = britneySpears.nextInt((20-1)+1) + 1;
			//britney is unpredictable
		}
		return dancePositions;
	};

	public static void changeIgnition(boolean[] ignitionList, String carChoice, int numCars){
		int whichCar = intifyCarChoice(carChoice);
		for(int i=0;i<numCars;i++){
			if(ignitionList[i] == true){
				ignitionList[i] = false;
			} else { //if it's not on then it's off
				//so turn it on
				ignitionList[i] = true;
			};
		};
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
	public static void dudeWheresMyCar(int[] x, int[] y, char[] color, boolean[] isItOn, String carChoice, int numCars){
		int whichCar = intifyCarChoice(carChoice);

		System.out.println("Car Information"); //car facts
		System.out.println("Color: " + whichColor(color[whichCar]));
		System.out.println("Ignition: " + amIBurningFossilFuels(isItOn[whichCar]));
		System.out.println("Location: (" + x[whichCar] + ", " + y[whichCar] + ")");
		
		for(int gridY = 1; gridY <= 20; gridY++){
			for(int gridX = 1; gridX <= 20; gridX++){
				if(x[whichCar] == gridX && y[whichCar] == gridY){
					System.out.print(color[whichCar]);
				} else {
					System.out.print("-");
				};
			};
			//end one row
			System.out.println();
		};
	};

	public static void moveUpOrDown(String distanceToMove, int[] currentY, boolean[] isTheCarEvenOn, String carChoice, int numCars){
		int newY;
		int whichCar = intifyCarChoice(carChoice);

		if(isTheCarEvenOn[whichCar]){
			//assume that the user's response was an integer and they're not actually drunk
			int whereAreWeNow = currentY[whichCar] + Integer.parseInt(distanceToMove);
			if(whereAreWeNow <= 20 && whereAreWeNow >= 1){
				newY = whereAreWeNow;
			} else {
				System.out.println("Movement out of bounds.");
				newY = currentY[whichCar];
			};
		} else {
			System.out.println("You have to turn the car on first. Go home. You're drunk.");
			newY = currentY[whichCar];
		};

		currentY[whichCar] = newY;
	};

	public static void moveRightOrToYourOtherRight(String distanceToMove, int[] currentX, boolean[] isTheCarEvenOn, String carChoice, int numCars){
		int newX;
		int whichCar = intifyCarChoice(carChoice);

		if(isTheCarEvenOn[whichCar]){
			//assume that the user's response was an integer and they're not actually drunk
			int whereAreWeNow = currentX[whichCar] + Integer.parseInt(distanceToMove);
			if(whereAreWeNow <= 20 && whereAreWeNow >= 1){
				newX = whereAreWeNow;
			} else {
				System.out.println("Movement out of bounds.");
				newX = currentX[whichCar];
			};
		} else {
			System.out.println("You have to turn the car on first. Seriously, you should just take the bus.");
			newX = currentX[whichCar];
		};

		currentX[whichCar] = newX;
	};

	public static int intifyCarChoice(String choice){
		//user choice will be 1 greater than the place in the array
		return Integer.parseInt(choice) - 1;
	};
};