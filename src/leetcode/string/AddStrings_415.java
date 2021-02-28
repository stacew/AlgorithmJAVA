package leetcode.string;

import java.util.Stack;

public class AddStrings_415 {
	// reverse
	public String addStrings(String num1, String num2) {
		StringBuilder ret = new StringBuilder();
		int back1 = num1.length() - 1;
		int back2 = num2.length() - 1;
		int carry = 0;
		while (back1 >= 0 || back2 >= 0) {
			int n1 = back1 >= 0 ? num1.charAt(back1--) - '0' : 0;
			int n2 = back2 >= 0 ? num2.charAt(back2--) - '0' : 0;
			int sum = n1 + n2 + carry;
			carry = sum / 10;
			ret.append(sum % 10);
		}
		if (carry > 0)
			ret.append(carry);

		return ret.reverse().toString();
	}

	// stack
	public String addStrings_stack(String num1, String num2) {

		int back1 = num1.length() - 1;
		int back2 = num2.length() - 1;
		int carry = 0;

		Stack<Integer> stk = new Stack<>();
		while (back1 >= 0 || back2 >= 0) {
			int n1 = back1 >= 0 ? num1.charAt(back1--) - '0' : 0;
			int n2 = back2 >= 0 ? num2.charAt(back2--) - '0' : 0;
			int sum = n1 + n2 + carry;
			carry = sum / 10;
			stk.push(sum % 10);
		}
		if (carry > 0)
			stk.push(carry);

		StringBuilder ret = new StringBuilder();
		while (stk.isEmpty() == false) {
			ret.append(stk.pop());
		}

		return ret.toString();
	}
}
