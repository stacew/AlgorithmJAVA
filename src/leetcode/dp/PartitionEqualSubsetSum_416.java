package leetcode.dp;
import java.util.Arrays;
//dp(Array(n), target) = dp( Array(n-1), target - nums[n] ) || dp(Array(n-1), target)

public class PartitionEqualSubsetSum_416 {
	public boolean canPartition(int[] nums) {
		int sum = Arrays.stream(nums).sum();
		if (sum % 2 == 1)
			return false;

		int target = sum / 2;
		boolean[] dp = new boolean[target + 1];
		// init
		dp[0] = true;

		// dp
		for (int r = 0; r < nums.length; r++) {
			for (int c = target; c >= nums[r]; c--) {
				dp[c] = dp[c] || dp[c - nums[r]];
			}
		}

		return dp[target];
	}
	/*
	 * public boolean canPartition(int[] nums) { int sum = 0; for (int n : nums) sum
	 * += n;
	 * 
	 * if (sum % 2 == 1) return false;
	 * 
	 * int target = sum / 2; boolean[][] dp = new boolean[nums.length + 1][target +
	 * 1]; // init dp[0][0] = true; for (int c = 1; c < target + 1; c++) { dp[0][c]
	 * = false; }
	 * 
	 * //dp for( int r = 1; r < nums.length + 1; r++) { for( int c = 0; c < target +
	 * 1; c++) { int elseTarget = c - nums[r-1]; dp[r][c] = dp[r-1][c] || (
	 * elseTarget >= 0 ? dp[r-1][elseTarget] : false ) ; } }
	 * 
	 * return dp[nums.length][target]; }
	 */
}
