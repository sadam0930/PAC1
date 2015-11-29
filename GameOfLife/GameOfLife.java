import java.util.Scanner;
import java.io.File;

public class GameOfLife {
	private static final int M = 25 + 2; //number of rows + border
	private static final int N = 75 + 2; //numbr of columns + border

	private static char[][] map = new char[M][N];
	private static char[][] oldmap = new char[M][N];
	private static int generation = 0;

	private static void readFile(){
		Scanner consoleInput = new Scanner(System.in);

		System.out.print("Which file wdo you want to open?");
		String filename = consoleInput.next();
		File file = new File(filename);
		Scanner fileReader = null;

		try{
			fileReader = new Scanner(file);
		} catch (Exception e){
			System.out.println("file " + file + " does not exist");
			System.exit(0);
		}

		String line;
		char[] tmp;
		for(int i=1; i<=M-2;i++){
			line = fileReader.nextLine();
			tmp = line.toCharArray();
			for(int j=1; j<=N-2;j++){
				map[i][j] = tmp[j-1];
			}
		}
	}

	public static int getGeneration(){
		return generation;
	}

	public static void printMap(){
		System.out.println("Generation " + getGeneration());
		for(int i=1;i<=M-2;i++){
			for(int j=1;j<=N-2;j++){
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

	public static void archiveLastGen(){
		for(int i=1; i<=M-2;i++){
			for(int j=1;j<=N-2;j++){
				oldmap[i][j] = map[i][j];
			}
		}
	}

	public static void nextGen(){
		archiveLastGen();
		generation++;
		for(int i=1; i<=M-2;i++){
			for(int j=1;j<=N-2;j++){
				//point you're looking at (i,j)
				char center = oldmap[i][j];
				int numNeighbors = getNumberNeighbors(oldmap, i, j);
				//mutation logic
				if(center == 'X' && (numNeighbors < 2 || numNeighbors > 3)){
					map[i][j] = '.';
				} else if(center == '.' && numNeighbors == 3) {
					map[i][j] = 'X';
				} else {
					//no change
				}
			}
		}
	}

	public static int getNumberNeighbors(char[][] somemap, int i, int j){
		int numNeighbors = 0;
		//loop around this point
		for(int m=i-1;m<=i+1;m++){
			for(int n=j-1;n<=j+1;n++){
				if(somemap[m][n] == 'X' && !(m == i && n == j)){
					numNeighbors++;
				}
			}
		}//end loop around center
		return numNeighbors;
	}

	public static boolean mapIsEmpty(char[][] somemap){
		boolean mapIsEmpty = true;
		for(int i=1;i<=M-2;i++){
			for(int j=1;j<=N-2;j++){
				if(somemap[i][j] == 'X'){
					mapIsEmpty = false;
				}
			}
		}
		return mapIsEmpty;
	}

	public static boolean isThisTheSameDamnArray(){
		boolean isTheSame = true;
		for(int i=1;i<=M-2;i++){
			for(int j=1;j<=N-2;j++){
				if(oldmap[i][j] != map[i][j]){
					isTheSame = false;
				}
			}
		}
		return isTheSame;
	}

	public static void main(String[] args){
		boolean runProgram = true;
		readFile();
		
		Scanner sc = new Scanner(System.in);
		do {
			printMap();
			System.out.println("Type any key to see the next generation. Enter 'q' to quit.");
			String response = sc.next();

			if(response.equals("q")){
				runProgram = false;
			} else {
				nextGen();
				if(mapIsEmpty(map)){
					printMap();
					runProgram = false;
					System.out.println("This world is devoid of life just like your soul.");
				}
				if(isThisTheSameDamnArray()){
					printMap();
					runProgram = false;
					System.out.println("Nothing has changed and nothing ever will.");
				}
			}

		} while(runProgram);
	
	}
}