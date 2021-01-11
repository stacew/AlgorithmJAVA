
class MinCostClimbingStairs_746 {

	public int minCostClimbingStairs_memo(int[] cost) {
		return 0;
	}

	public int minCostClimbingStairs(int[] cost) {
		return minCostClimbingStairs_BU(cost);
	}

	public int minCostClimbingStairs_BU(int[] cost) {
		for (int i = 2; i < cost.length; i++) {
			cost[i] = Math.min(cost[i] + cost[i - 1], cost[i] + cost[i - 2]);
		}
		return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
	}
}
