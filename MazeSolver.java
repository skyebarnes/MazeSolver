package pkg;

import java.util.ArrayList;
import java.util.List;

public abstract class MazeSolver {

	Maze maze;

	boolean solvable;
	boolean notYetSolved = true;

	MazeSolver(Maze maze) {
		this.maze = maze;
		makeEmpty();
		add(maze.getStart());
	}

	abstract void makeEmpty();

	abstract boolean isEmpty();

	abstract void add(Square s);

	abstract Square next();

	boolean isSolved() {
		return solvable;
	}

	void step() {
		if (!isEmpty()) {
			Square next = next();
			if (next.getType() == 3) {
				solvable = true;
			} else {
				List<Square> neighbors = maze.getNeighbors(next);
				for (Square s : neighbors) {
					if (s.getStatus() != '.')
						add(s);
				}

			}
			next.setStatus('.');
		}
	}

	String getPath() {
		if (notYetSolved)
			return "Not yet solved";
		else if (solvable)
			return "Solved";
		return "unsolvable";
	}

	void solve() {
		while (!solvable)
			step();
	}
}
