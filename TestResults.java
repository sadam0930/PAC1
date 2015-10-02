import.java.Scanner;

public class TestResults {
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		int numFail = 0;
		int numPass = 0;

		while((numPass + numFail) <= 10){
			num++;
			System.out.print("Enter result: ");
			int tmp = sc.nextInt();

			if(tmp == 1){
				numPass++;
			} else {
				numFail++;
			};
		}

		if(numPass >= 8){
			System.out.println("Raise Tuition");
		}

	}
}