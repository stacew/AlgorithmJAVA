package leetcode.stack;

import java.util.Stack;

public class DecodeString_394 {
	class pair {
		int cnt;
		StringBuilder sb;

		pair(int _cnt) {
			cnt = _cnt;
			sb = new StringBuilder();
		}
	}

	public String decodeString(String s) {
		Stack<pair> stk = new Stack<>();

		int num = 0;
		stk.push(new pair(1));
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
				stk.peek().sb.append(s.charAt(i));
			} else if (s.charAt(i) == ']') {
				pair data = stk.pop();
				for (int c = 0; c < data.cnt; c++)
					stk.peek().sb.append(data.sb);
			} else if (s.charAt(i) == '[') {
				stk.push(new pair(num));
				num = 0;
			} else {// number
				num *= 10;
				num += s.charAt(i) - '0';
			}
		}

		return stk.peek().sb.toString();
	}
}
