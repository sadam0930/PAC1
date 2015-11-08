/*
Name: Steven Adam
Class: PAC 1
This class simulates interacting with numerous cars using user input.
Cars are trapped on a 20x20 grid and cannot be painted.
*/

import java.util.Random;
import java.util.Scanner;

public class CarClass { //I already have a class named car in this directory from a previous assignment
	private Random rand = new Random();
	private boolean ignition; //default is off
	private char color;
	//store the position as x and y coordinates
	private int xcoordinate;
	private int ycoordinate;

	public CarClass(){
		this.ignition = false; //default is off
		this.color = colorAssignment();
		//store the position as x and y coordinates
		this.xcoordinate = randomPosition();
		this.ycoordinate = randomPosition();
	}

	//randomly select from array of colors and assign to each car
	private char colorAssignment(){
		char[] colors = {'R', 'G', 'B', 'W', 'S'};
		return colors[rand.nextInt(5)];
	};

	private String getColor(){
		String notSoSecret = "";

		//let's switch it up
		switch (this.color) {
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
	private int randomPosition(){
		return rand.nextInt((20-1)+1) + 1;
	};

	public void changeIgnition(){
		if(this.ignition == true){
			this.ignition = false;
		} else { //if it's not on then it's off
			//so turn it on
			this.ignition = true;
		};
	};

	//translate the boolean into a human readable string
	private String getIgnitionStatus(){
		String returnMessage = "";

		if(this.ignition){
			returnMessage = "on";
		} else {
			returnMessage = "off";
		};

		return returnMessage;
	};

	public int getX() {
		return this.xcoordinate;
	}

	public int getY(){
		return this.ycoordinate;
	}

	//for those following along this method helps this dude find his car
	public String toString(){
		String message = "Car Information\n"; //car facts
		message += "Color: " + getColor() + "\n";
		message += "Ignition: " + getIgnitionStatus() + "\n";
		message += "Location: (" + getX() + ", " + getY() + ")\n";
		
		for(int gridY = 1; gridY <= 20; gridY++){
			for(int gridX = 1; gridX <= 20; gridX++){
				if(getX() == gridX && getY() == gridY){
					message += this.color;
				} else {
					message += "-";
				};
			};
			//end one row
			message += "\n";
		};

		return message;
	};

	public void moveUpOrDown(String distanceToMove){
		int newY;

		if(this.ignition){
			//assume that the user's response was an integer and they're not actually drunk
			int whereAreWeNow = this.ycoordinate + Integer.parseInt(distanceToMove);
			if(whereAreWeNow <= 20 && whereAreWeNow >= 1){
				this.ycoordinate = whereAreWeNow;
			} else {
				System.out.println("Movement out of bounds.");
			};
		} else {
			System.out.println("You have to turn the car on first. Go home. You're drunk.");
		};
	};

	public void moveRightOrToYourOtherRight(String distanceToMove){
		int newX;

		if(this.ignition){
			//assume that the user's response was an integer and they're not actually drunk
			int whereAreWeNow = this.xcoordinate + Integer.parseInt(distanceToMove);
			if(whereAreWeNow <= 20 && whereAreWeNow >= 1){
				this.xcoordinate = whereAreWeNow;
			} else {
				System.out.println("Movement out of bounds.");
			};
		} else {
			System.out.println("You have to turn the car on first. Seriously, you should just take the bus.");
		};
	};

	public static void main(String[] args){
		final int NUMCARS = 10;
		CarClass[] carArr = new CarClass[NUMCARS];

		for(int i=0; i<NUMCARS; i++){
			carArr[i] = new CarClass();
		}

		Scanner imWatchingYou = new Scanner(System.in);
		boolean runProgram = true;

		while(runProgram){
			System.out.println("Which car would you like to use next (1-10)?");
			System.out.println("Or Select Q to quit");

			String carChoice = imWatchingYou.next();

			if(carChoice.equalsIgnoreCase("1") || carChoice.equalsIgnoreCase("2") ||
				carChoice.equalsIgnoreCase("3") || carChoice.equalsIgnoreCase("4") ||
				carChoice.equalsIgnoreCase("5") || carChoice.equalsIgnoreCase("6") ||
				carChoice.equalsIgnoreCase("7") || carChoice.equalsIgnoreCase("8") ||
				carChoice.equalsIgnoreCase("9") || carChoice.equalsIgnoreCase("10")) {

				CarClass car = carArr[Integer.parseInt(carChoice)-1];

				System.out.println("What would you like to do next " +
					"(1 - change ignition; 2 - change position of car; 3 - quit this program)?");

				String response = imWatchingYou.next();

				if(response.equalsIgnoreCase("3")){
					runProgram = false;
				} else if(response.equalsIgnoreCase("2")){
					System.out.println("What direction would you like to move the car " +
						"(1 - horizontal; 2 - vertical)?");

					response = imWatchingYou.next();

					if(response.equalsIgnoreCase("1")){
						System.out.print("How far (negative value to move left)?");
						response = imWatchingYou.next();
						car.moveRightOrToYourOtherRight(response);
					} else if(response.equalsIgnoreCase("2")){
						System.out.print("How far (negative value to move up)?");
						response = imWatchingYou.next();
						car.moveUpOrDown(response);
					} else {
						System.out.println("Invalid command");
					}

				} else if(response.equals("1")){
					car.changeIgnition();
				} else {
					System.out.println("Invalid command");
				}

				System.out.println(car);
			} else if(carChoice.equalsIgnoreCase("Q")){
				runProgram = false;
			} else {
				System.out.println("Invalid command");
			}
		}
	}
}