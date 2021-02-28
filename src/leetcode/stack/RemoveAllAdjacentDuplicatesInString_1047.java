package leetcode.stack;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString_1047 {
	public String removeDuplicates(String S) {
		Stack<Character> stk = new Stack<>();
		for (int i = 0; i < S.length(); i++) {
			if (stk.isEmpty() == false)
				if (stk.peek() == S.charAt(i)) {
					stk.pop();
					continue;
				}

			stk.push(S.charAt(i));
		}
		
		StringBuilder sb = new StringBuilder();
		while( stk.isEmpty() == false ) {
			sb.append(stk.pop());
		}
		
		return sb.reverse().toString();
	}
}
