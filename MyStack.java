package pkg;

import java.util.*;

public class MyStack {
	Square[] stack;
	int size;

	public MyStack() {
		stack = new Square[size];
	}

	public MyStack(int initCap) {
		size = initCap;
	}

	public boolean isEmpty() {
		if (size == 0)
			return true;
		else
			return false;
	}

	public Square peek() throws EmptyStackException {
		return stack[size - 1];
	}

	public Square pop() throws EmptyStackException {

		Square popped = stack[size - 1];
		stack[size - 1] = null;
		size--;
		return popped;
	}

	public void push(Square item) {
		if (size >= stack.length)
			doubleCapacity();

		stack[size] = item;

		size++;
	}

	public void doubleCapacity() {
		Square[] newStack = new Square[stack.length * 2];
		for (int i = 0; i < size; i++)
			newStack[i] = stack[i];

		stack = newStack;
		if (stack.length == 0)
			stack = new Square[1];
	}

	public String toString() {

		String printed = "" + stack[size - 1] + "  <----- TOP\n";

		for (int i = size - 2; i >= 0; i--) {
			printed += stack[i] + "\n";
		}

		printed += "-----------";

		return printed;
	}

}
