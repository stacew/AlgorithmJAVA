package leetcode.stack;

import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses_1249 {
	public String minRemoveToMakeValid(String s) {
		int lpCount = 0;
		int rpCount = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ')')
				rpCount++;
			else if (s.charAt(i) == '(')
				lpCount++;
			
			if( rpCount > lpCount )
				rpCount = lpCount;
			else
				sb.append(s.charAt(i));
		}
		
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) == '(') {
				lpCount--;
				if( lpCount < 0 )
					sb.deleteCharAt(i--);
			}
		}
		
		return sb.toString();
	}

	public String minRemoveToMakeValid_Stack(String s) {
		Stack<Character> stk = new Stack<>();

		int lpCount = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ')') {
				if (lpCount == 0)
					continue;

				lpCount--;
			} else if (s.charAt(i) == '(')
				lpCount++;

			stk.push(s.charAt(i));
		}

		StringBuilder sb = new StringBuilder();
		lpCount = 0;
		while (stk.isEmpty() == false) {
			if (stk.peek() == ')') {
				lpCount--;
			} else if (stk.peek() == '(') {
				if (lpCount == 0) {
					stk.pop();
					continue;
				}

				lpCount++;
			}

			sb.append(stk.pop());
		}

		return sb.reverse().toString();
	}
}
