import java.util.Scanner;

public class TimeDifference {
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		//assume inputs are integers of format HHMMSS
		System.out.print("Enter first time: ");
		int time1 = sc.nextInt();

		System.out.print("Enter second time: ");
		int time2 = sc.nextInt();

		int hr1 = time1/10000;
		int min1 = (time1/100)%100;
		int sec1 = time1%100;

		//System.out.println("hr1=" + hr1);
		//System.out.println("min1=" + min1);
		//System.out.println("sec1=" + sec1);

		int hr2 = time2/10000;
		int min2 = (time2/100)%100;
		int sec2 = time2%100;

		//System.out.println("hr2=" + hr2);
		//System.out.println("min2=" + min2);
		//System.out.println("sec2=" + sec2);

		int totalsec1 = hr1*3600 + min1*60 + sec1;
		int totalsec2 = hr2*3600 + min2*60 + sec2;

		//System.out.println("totalsec1=" + totalsec1);
		//System.out.println("totalsec2=" + totalsec2);

		int difference = totalsec1 - totalsec2;

		//System.out.println("difference=" + difference);

		int difhr = difference/3600;
		int difmin = (difference%3600)/60;
		int difsec = (difference%3600)%60;

		//System.out.println("difhr=" + difhr);
		//System.out.println("difmin=" + difmin);
		//System.out.println("difsec=" + difsec);

		int newtime = difhr*10000 + difmin*100 + difsec;

		System.out.println("Time difference: " + newtime);
	}
}