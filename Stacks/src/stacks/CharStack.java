package stacks;

import java.util.LinkedList;

public class CharStack {
	
	public LinkedList<Character> data = new LinkedList<Character>();
	public int currentIndex = -1;
	
	public void push(Character x) {
		data.add(x);
		currentIndex++;
	}
	
	public Character pop() {
		if (currentIndex < 0) return null;
		
		currentIndex--;
		return data.remove(currentIndex + 1);
	}
	
	public Character top() {
		if (currentIndex < 0) return null;
		
		return data.get(currentIndex);
	}
	
	public boolean isEmpty() {
		return currentIndex == -1;
	}
}