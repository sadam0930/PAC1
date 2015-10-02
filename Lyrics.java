/**This program prints out a portion 
of the lyrics to the song "alive" by P.O.D
**/

public class Lyrics {
	public static void main (String args[]) {
		String lyric1 = "\"I FEEL SO ALIVE\n";
		String lyric2 = "For the very first time\"";

		singSong(lyric1);
		singSong(lyric2);
	};
	
	public static void singSong(String lyric) {
		System.out.print(lyric);
	};
};