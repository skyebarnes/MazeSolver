package pkg;

public class Square {

	public static final int SPACE = 0;
	public static final int WALL = 1;
	public static final int START = 2;
	public static final int EXIT = 3;

	public final static char WORKING = 'o';
	public final static char EXPLORED = '.';
	public final static char ON_EXIT_PATH = 'x';
	public final static char UNKNOWN = '_';

	private int row, col;
	private int type;
	private char status;

	public Square(int row, int col, int type) {
		this.row = row;
		this.col = col;
		this.type = type;
	}

	public String toString() {
		if (type == SPACE) {
			switch(status) {
			case WORKING:
				return "" + WORKING;
			case EXPLORED:
				return "" + EXPLORED;
			case ON_EXIT_PATH:
				return "" + ON_EXIT_PATH;
			default:
				return "_";
				
			}
		} else if (type == WALL) {
			return "#";
		} else if (type == START) {
			return "S";
		} else if (type == EXIT) {
			return "E";
		}

		return "";

	}

	public boolean equals(Object obj) {
		return true;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public int getType() {
		return type;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char s) {
		status = s;
	}

}
