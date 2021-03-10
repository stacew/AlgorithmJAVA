package leetcode.dp;

class ClimbingStairs_70 {

	int[] dp;

	public int climbStairs(int n) {
		dp = new int[3];

		// return climbStairs_BU(n);
		return climbStairs_memo(n);
	}

	// bottom up
	private int climbStairs_BU(int n) {
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= n; i++)
			dp[i % 3] = dp[(i - 1) % 3] + dp[(i - 2) % 3];

		return dp[n % 3];
	}

	private int climbStairs_memo(int n) {
		if (n <= 2)
			return n; // 1 or 2
		else if (dp[n % 3] != 0)
			return dp[n % 3];

		//순서 있음
		dp[(n - 1) % 3] = climbStairs_memo(n - 1);	//1
		dp[(n - 2) % 3] = climbStairs_memo(n - 2);	//2

		dp[n % 3] = dp[(n - 1) % 3] + dp[(n - 2) % 3];
		return dp[n % 3];
	}

}
