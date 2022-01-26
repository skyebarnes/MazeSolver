package pkg;

public class MazeSolverStack extends MazeSolver {

	MyStack stack;

	MazeSolverStack(Maze maze) {
		super(maze);
	}

	@Override
	void makeEmpty() {
		stack = new MyStack();
	}

	@Override
	boolean isEmpty() {
		if (stack.size == 0)
			return true;
		return false;
	}

	@Override
	void add(Square s) {
		stack.push(s);
	}

	@Override
	Square next() {
		return stack.pop();
	}

}
