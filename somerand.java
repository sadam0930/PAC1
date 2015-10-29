public class Somerand {
	public static void main (String [] args){
		int num = (int) (Math.random() * (10000-0)) + 1;
		int numDig = numDig(num);

		System.out.println(num);
		System.out.println(numDig);
	}

	public static int numDig(int num){
		int numDig = 1;
		for(int i=10; i<=10000; i*=10){
			if(num/i != 0){
				numDig++;
			}
		}
		return numDig;
	}
}