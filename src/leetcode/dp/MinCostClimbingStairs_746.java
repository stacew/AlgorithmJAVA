package leetcode.dp;

class MinCostClimbingStairs_746 {

	public int minCostClimbingStairs_(int[] cost) {

		for (int i = 2; i < cost.length; i++)
			cost[i] = cost[i] + Math.min(cost[i - 1], cost[i - 2]);

		return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
	}
 
	public int minCostClimbingStairs(int[] cost) {

		int[] dp = new int[3];
		dp[0] = cost[0];
		dp[1] = cost[1];

		for (int i = 2; i < cost.length; i++)
			dp[i % 3] = cost[i] + Math.min(dp[(i - 2) % 3], dp[(i - 1) % 3]);

		int n = cost.length - 1;
		return Math.min(dp[n % 3], dp[(n - 1) % 3]); // out of climb
	}
	
}
