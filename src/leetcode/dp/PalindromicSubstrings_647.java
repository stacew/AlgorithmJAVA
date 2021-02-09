package leetcode.dp;
public class PalindromicSubstrings_647 {
	public int countSubstrings(String s) {
		int len = s.length();
		int[][] dp = new int[len][len];

		// 1
		for (int c = 0, r = 0; r < len; r++) {
			int col = c + r;
			dp[r][col] = (s.charAt(r) == s.charAt(col)) ? 1 : 0;
		}
		// 2

		for (int c = 1, r = 0; r < len - c; r++) {
			int col = c + r;
			dp[r][col] = (s.charAt(r) == s.charAt(col)) ? 2 : 0;
		}

		// check
		for (int c = 2; c < len; c++) {
			for (int r = 0; r < len - c; r++) {
				int col = c + r;
				if (s.charAt(r) != s.charAt(col) || dp[r + 1][col - 1] == 0) {
					dp[r][col] = 0;
					continue;
				}
				dp[r][col] = col - r + 1;
			}
		}

		int ret = 0;
		for (int c = 0; c < len; c++) {
			for (int r = 0; r < len - c; r++) {
				int col = c + r;
				if (dp[r][col] != 0)
					ret++;
			}
		}

		return ret;
	}
}