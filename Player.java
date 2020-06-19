public class Player {
	
	private static int SIZE;
	private static int WINSIZE;
	public char[][] arrayRep;
	
	private Player() {};
	
	private Player(int size, int winsize) {
		this.SIZE = size;
		this.WINSIZE = winsize;
		arrayRep = new char[SIZE][SIZE];
	}
	
	
}