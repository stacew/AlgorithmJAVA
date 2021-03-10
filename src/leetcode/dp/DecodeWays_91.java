package leetcode.dp;

public class DecodeWays_91 {

	private int[] dp;

	public int numDecodings(String s) {

		dp = new int[s.length()]; // 슬라이딩으로 3개로 가능하다.

		// 1. 1ms
		// return BU(s);

		// 2. 1ms -> If don't memoization, time limit exceeded.
		for (int i = 0; i < dp.length; i++)
			dp[i] = -1;
		return recursion(s, 1) + recursion(s, 2);
	}

	private int recursion(String s, int index) {

		// 1. check
		if (s.charAt(0) == '0' || s.length() < index)
			return 0;

		String checkStr = s.substring(0, index);

		// try {
		int alphaNum = Integer.parseInt(checkStr) - 1; // -1 => a(0) ~ z(25) index
		if (alphaNum < 'a' - 'a' || 'z' - 'a' < alphaNum)
			return 0;
		// } catch (NumberFormatException e) { // parseInt("02") not exception...
		// return 0;
		// }

		// 2. recursive
		String subStr = s.substring(index, s.length());
		int subLen = subStr.length();
		if (subLen == 0)
			return 1;

		if (dp[subLen] >= 0) // opti : memoization
			return dp[subLen];

		return dp[subLen] = recursion(subStr, 1) + recursion(subStr, 2);
	}

	private int BU(String s) {

		int num = s.charAt(0) - '0';
		if (num >= 1 && num <= 9)// 1~9
			dp[0] = 1;

		for (int i = 1; i < s.length(); i++) {

			num = s.charAt(i) - '0';
			if (1 <= num && num <= 9) // 1~9
				dp[i] += dp[i - 1];

			int numPrev = s.charAt(i - 1) - '0';
			num = numPrev * 10 + num;
			if (10 <= num && num <= 26) // 10 ~ 26
				dp[i] += (i - 2 >= 0) ? dp[i - 2] : 1;
		}

		return dp[s.length() - 1];
	}
}
