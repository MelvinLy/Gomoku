public class Board {
	final static int SIZE = 19;
	private char[][] arrayRep = new char[SIZE][SIZE];
	
	public boolean setChar(int row, int col, char val) {
		if(val != 'X' || val != 'O') {
			return false;
		}
		if(row >= 0 && row <= 18 && col >= 0 && col <= 18) {
			if(arrayRep[row][col] != 0) {
				return false;
			}
			arrayRep[row][col] = val;
			return true;
		}
		return false;
	}
	
	
	
}