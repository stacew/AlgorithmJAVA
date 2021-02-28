package leetcode.stack;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInStringII_1209 {
	class pair {
		char c;
		int count;

		pair(char _c, int _count) {
			c = _c;
			count = _count;
		}
	}

	public String removeDuplicates(String s, int k) {

		Stack<pair> stk = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (stk.isEmpty()) {
				stk.push(new pair(s.charAt(i), 1));
				continue;
			}

			if (stk.peek().c != s.charAt(i)) {
				stk.push(new pair(s.charAt(i), 1));
				continue;	
			}
			
			stk.peek().count++;
			if (stk.peek().count == k) {
				stk.pop();
			}			
		}

		StringBuilder sb = new StringBuilder();
		while (stk.isEmpty() == false) {
			pair data = stk.pop();
			while (data.count-- > 0) {
				sb.append(data.c);
			}
		}

		return sb.reverse().toString();
	}
}
