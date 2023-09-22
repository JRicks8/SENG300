package stacks;

class Palindrome {
	
	static boolean isPalindrome(String s) {
		s = s.replaceAll("[^a-zA-Z]", "");
		s = s.toLowerCase();
		
		int length = s.length();
		int i, middle = length / 2;
		
		CharStack stack = new CharStack();
		for (i = 0; i < middle; i++) {
			stack.push(s.charAt(i));
		}
		
		if (length % 2 != 0) i++;
		
		while (!stack.isEmpty()) {
			//System.out.println("Comparing '" + stack.top() + "' and '" + s.charAt(i) + "'");
			//System.out.println(stack.top() == s.charAt(i));
			if (!(stack.top() == s.charAt(i))) return false;
			stack.pop();
			i++;
		}
		
		return true;
	}
}