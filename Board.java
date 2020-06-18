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
	
	public boolean canGoLeft(int row, int col) {
		if(col + 1 - 5 >= 0) {
			return true;
		}
		return false;
	}
	
	public boolean canGoRight(int row, int col) {
		if(col + 1 + 5 <= SIZE) {
			return true;
		}
		return false;
	}
	
	public boolean canGoUp(int row, int col) {
		if(row + 1 - 5 >= 0) {
			return true;
		}
		return false;
	}
	
	public boolean canGoDown(int row, int col) {
		if(row + 1 + 5 <= SIZE) {
			return true;
		}
		return false;
	}
	
	public boolean canGoUpLeft(int row, int col) {
		if(canGoLeft(row, col) && canGoUp(row, col)) {
			return true;
		}
		return false;
	}
	
	public boolean canGoUpRight(int row, int col) {
		if(canGoUp(row, col) && canGoRight(row, col)) {
			return true;
		}
		return false;
	}
	
	public boolean canGoDownLeft(int row, int col) {
		if(canGoDown(row, col) && canGoLeft(row, col)) {
			return true;
		}
		return false;
	}
	
	public boolean canGoDownRight(int row, int col) {
		if(canGoDown(row, col) && canGoRight(row, col)) {
			return true;
		}
		return false;
	}
	
	public boolean hasFive(int row, int col, int val) {

		return false;
	}
	
	public boolean checkWin(char val) {
		for(int a = 0; a < SIZE; a++) {
			for(int b = 0; b < SIZE; b++) {
				if(arrayRep[a][b] == val) {
					if(hasFive(a, b, val)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
}