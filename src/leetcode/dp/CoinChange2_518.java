package leetcode.dp;
//DP(개수-1,S) + DP(개수-1, S-해당코인)
//푼 방식
//DP(개수,S) =
//while(S-해당코인이 0이상인 경우 계속 시도){
//	DP(개수, S) += DP(개수-1, S-해당코인);
//	}
//
//더 빠른 점화식
//DP(개수,S) =
//DP(개수-1,S) + DP(개수-1, S-해당코인)

public class CoinChange2_518 {
	public int change(int amount, int[] coins) {
		int dp[][] = new int[coins.length][amount + 1];
		for (int c = 0; c <= amount; c++) {
			dp[0][c] = (c % coins[0] == 0) ? 1 : 0;
		}

		for (int r = 1; r < coins.length; r++) {
			for (int c = 0; c <= amount; c++) {
				int tempC = c;
				while (tempC >= 0) {
					dp[r][c] += dp[r - 1][tempC];
					tempC -= coins[r];
				}
			}
		}

		return dp[coins.length - 1][amount];
	}
}
