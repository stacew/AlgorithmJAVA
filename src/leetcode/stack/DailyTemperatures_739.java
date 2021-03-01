package leetcode.stack;

import java.util.Stack;

public class DailyTemperatures_739 {
	class pair {
		int T;
		int diff;

		pair(int _T, int _diff) {
			T = _T;
			diff = _diff;
		}
	}

	//2. stack index만 저장 17ms
	public int[] dailyTemperatures(int[] T) {
		Stack<pair> stk = new Stack<>();
		for (int i = T.length - 1; i >= 0; i--) {
			int temp = T[i];

			while (stk.empty() == false && stk.peek().T <= temp)
				stk.pop();

			if (stk.empty())
				T[i] = 0;
			else if (T[i] < stk.peek().T)
				T[i] = stk.peek().diff - i; // diff -> index 사용

			stk.push(new pair(temp, i));
		}

		return T;
	}

	//3. use day result index ( 2ms )
	public int[] dailyTemperatures_usIndex(int[] T) {
		int[] result = new int[T.length];
		int rightMax = Integer.MIN_VALUE;

		for (int i = T.length - 1; i >= 0; i--) {
			if (T[i] >= rightMax) {
				rightMax = T[i];
			} else {
				int day = 1;

				while (T[i] >= T[i + day]) {
					day += result[i + day];
				}

				result[i] = day;
			}
		}

		return result;
	}

	//1. stack ( 20ms )
	public int[] dailyTemperatures_stack(int[] T) {

		Stack<pair> stk = new Stack<>();
		for (int i = T.length - 1; i >= 0; i--) {
			int diffCount = 1;
			while (stk.empty() == false && stk.peek().T < T[i]) {
				diffCount += stk.pop().diff;
			}

			if (stk.isEmpty())
				stk.push(new pair(T[i], 0));
			else if (T[i] < stk.peek().T)
				stk.push(new pair(T[i], diffCount));
			else if (stk.peek().T == T[i]) {
				pair data = stk.pop();
				if (data.diff == 0)
					stk.push(new pair(T[i], 0));
				else
					stk.push(new pair(T[i], data.diff + diffCount));
			}

			T[i] = stk.peek().diff;
		}

		return T;
	}
}
