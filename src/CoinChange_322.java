class CoinChange_322 {
	
	//2차원으로 점화식을 그렸는데,,, 1차원으로 기록 가능했다... 확인
	public int coinChange(int[] coins, int amount) {
		int[] dpCases = new int[amount + 1];
		dpCases[0] = 0;

		for (int v = 1; v < dpCases.length; v++) {
			dpCases[v] = -1;
			
			for (int c = 0; c < coins.length; c++) {
				int toV = v - coins[c];
				if (toV < 0 || dpCases[toV] == -1) {
					continue;
				}
				
				if (dpCases[v] == -1)
					dpCases[v] = dpCases[toV] + 1;
				else
					dpCases[v] = Math.min(dpCases[v], dpCases[toV] + 1);
			}
		}

		return dpCases[amount];
	}


	public int coinChangeDP2(int[] coins, int amount) {
		int[][] dpCases = new int[amount + 1][coins.length]; // 0도 포함 시켜 amount + 1로 세팅함.
		for (int c = 0; c < coins.length; c++)
			dpCases[0][c] = 0;

		for (int v = 1; v <= amount; v++) {
			for (int c = 0; c < coins.length; c++) {
				int toV = v - coins[c];
				if (toV <= 0) {
					dpCases[v][c] = (toV == 0) ? 1 : -1;
					continue;
				}

				int minCases = -1; // 초기값
				for (int c2 = 0; c2 < coins.length; c2++) {
					if (dpCases[toV][c2] == -1)
						continue;

					if (minCases == -1)
						minCases = dpCases[toV][c2];
					else
						minCases = Math.min(minCases, dpCases[toV][c2]);
				}

				dpCases[v][c] = (minCases == -1) ? -1 : minCases + 1;
			}
		}

		int retMin = -1; // 초기값
		for (int c = 0; c < coins.length; c++) {
			if (dpCases[amount][c] == -1)
				continue;

			if (retMin == -1)
				retMin = dpCases[amount][c];
			else
				retMin = Math.min(retMin, dpCases[amount][c]);
		}

		return retMin;
	}
}
