public class Board {
	final static int SIZE = 19;
	final static int WINSIZE = 5;
	public char[][] arrayRep = new char[SIZE][SIZE];
	
	public boolean setChar(int row, int col, char val) {
		if(val != 'X' && val != 'O') {
			return false;
		}
		if(row >= 0 && row <= SIZE - 1 && col >= 0 && col <= SIZE - 1) {
			if(arrayRep[row][col] != 0) {
				return false;
			}
			arrayRep[row][col] = val;
			return true;
		}
		return false;
	}
	
	public boolean canGoLeft(int row, int col) {
		if(col + 1 - WINSIZE >= 0) {
			return true;
		}
		return false;
	}
	
	public boolean canGoRight(int row, int col) {
		if(col + 1 + WINSIZE <= SIZE) {
			return true;
		}
		return false;
	}
	
	public boolean canGoUp(int row, int col) {
		if(row + 1 - WINSIZE >= 0) {
			return true;
		}
		return false;
	}
	
	public boolean canGoDown(int row, int col) {
		if(row + 1 + WINSIZE <= SIZE) {
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
	
	public boolean leftWin(int row, int col, char val) {
		for(int a = 0; a < WINSIZE; a++) {
			if(arrayRep[row][col - 1] != val) {
				return false;
			}
		}
		return true;
	}
	
	public boolean rightWin(int row, int col, char val) {
		for(int a = 0; a < WINSIZE; a++) {
			if(arrayRep[row][col + a] != val) {
				return false;
			}
		}
		return true;
	}
	
	public boolean upWin(int row, int col, char val) {
		for(int a = 0; a < WINSIZE; a++) {
			if(arrayRep[row - a][col] != val) {
				return false;
			}
		}
		return true;
	}
	
	public boolean downWin(int row, int col, char val) {
		for(int a = 0; a < WINSIZE; a++) {
			if(arrayRep[row + a][col] != val) {
				return false;
			}
		}
		return true;
	}
	
	public boolean upLeftWin(int row, int col, char val) {
		for(int a = 0; a < WINSIZE; a++) {
			if(arrayRep[row - a][col - a] != val) {
				return false;
			}
		}
		return true;
	}
	
	public boolean upRightWin(int row, int col, char val) {
		for(int a = 0; a < WINSIZE; a++) {
			if(arrayRep[row - a][col + a] != val) {
				return false;
			}
		}
		return true;
	}
	
	public boolean downLeftWin(int row, int col, char val) {
		for(int a = 0; a < WINSIZE; a++) {
			if(arrayRep[row + a][col - a] != val) {
				return false;
			}
		}
		return true;
	}
	
	public boolean downRightWin(int row, int col, char val) {
		for(int a = 0; a < WINSIZE; a++) {
			if(arrayRep[row + a][col + a] != val) {
				return false;
			}
		}
		return true;
	}
	
	public boolean hasWin(int row, int col, char val) {
		if(canGoLeft(row, col)) {
			if(leftWin(row, col, val)) {
				return true;
			}
		}
		if(canGoUp(row, col)) {
			if(upWin(row, col, val)) {
				return true;
			}
		}
		if(canGoRight(row, col)) {
			if(rightWin(row, col, val)) {
				return true;
			}
		}
		if(canGoDown(row, col)) {
			if(downWin(row, col, val)) {
				return true;
			}
		}
		if(canGoUpLeft(row, col)) {
			if(upLeftWin(row, col, val)) {
				return true;
			}
		}
		if(canGoUpRight(row, col)) {
			if(upRightWin(row, col, val)) {
				return true;
			}
		}
		if(canGoDownRight(row, col)) {
			if(downRightWin(row, col, val)) {
				return true;
			}
		}
		if(canGoDownLeft(row, col)) {
			if(downLeftWin(row, col, val)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean checkWin(char val) {
		for(int a = 0; a < SIZE; a++) {
			for(int b = 0; b < SIZE; b++) {
				if(arrayRep[a][b] == val) {
					if(hasWin(a, b, val)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
}