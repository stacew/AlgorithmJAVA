package leetcode.stack;

import java.util.Stack;

public class BasicCalculatorII_227 {

	void calc(Stack<Integer> stk, int num, char prevOp) {
		if (prevOp == '+')
			stk.push(num);
		else if (prevOp == '-')
			stk.push(-num);
		else if (prevOp == '*')
			stk.push(stk.pop() * num);
		else if (prevOp == '/')
			stk.push(stk.pop() / num);
	}

	public int calculate(String s) {
		Stack<Integer> stk = new Stack<>();

		char prevOp = '+';
		int num = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isWhitespace(c))
				continue;

			if (Character.isDigit(c)) {
				num *= 10;
				num += c - '0';
			} else {
				calc(stk, num, prevOp);
				prevOp = c;
				num = 0;
			}

		}
		calc(stk, num, prevOp);

		int ret = 0;
		while (stk.isEmpty() == false) {
			ret += stk.pop();
		}

		return ret;
	}
}
