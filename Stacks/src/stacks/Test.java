package stacks;

import java.util.Stack;

public class Test {
	
	static IntQueue reverseQueue(IntQueue q) {
		
		if (q.isEmpty()) {
            return q;
        }

        Stack<Integer> stack = new Stack<>();
        int X;

        while (!q.isEmpty()) {
            X = q.dequeue();
            stack.push(X);
        }

        while (!stack.isEmpty()) {
            X = stack.pop();
            q.enqueue(X);
        }
		return q;
	}
	
	static IntQueue parseInput(String input) {
		
		if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input string is null or empty.");
        }
		
		input = input.replaceAll("[^0123456789,]", "");
		System.out.println(input);
		
		String[] tokens = input.split(",");
		//for (int i = 0; i < tokens.length; i++) System.out.println(tokens[i]);
		int[] arr = new int[tokens.length];
		
		try {
			for (Integer i = 0; i < tokens.length; i++) {
				arr[i] = Integer.parseInt(tokens[i]);
				//System.out.println(arr[i]);
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Invalid format: Input string contains non-integer values.");
		}
		
		IntQueue q = new IntQueue(arr.length + 1);
		for (int i = 0; i < arr.length; i++) q.enqueue(arr[i]);
		return q;
	}
}