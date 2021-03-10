package leetcode.dp;

import java.util.HashMap;

public class CoinChange_322 {

	// 142ms
	public int coinChange_HashMap(int[] coins, int amount) {

		// key : amount, value : min Cases
		HashMap<Integer, Integer> amountMinCases = new HashMap<>();
		amountMinCases.put(0, 0);// 0원을 coin 0개로 만들 수 있음.

		for (int am = 1; am <= amount; am++) {

			int min = Integer.MAX_VALUE;
			for (int c = 0; c < coins.length; c++) {

				int prevAmount = am - coins[c];
				if (amountMinCases.containsKey(prevAmount) == false)
					continue;

				min = Math.min(amountMinCases.get(prevAmount), min);
			}

			if (min != Integer.MAX_VALUE) {
				amountMinCases.put(am, min + 1);
			}

		}

		if (amountMinCases.containsKey(amount) == false)
			return -1;

		return amountMinCases.get(amount);
	}

	// 12ms : 1차원
	public int coinChange_DP1(int[] coins, int amount) {

		int[] amountMinCases = new int[amount + 1];
		for (int am = 1; am < amountMinCases.length; am++)
			amountMinCases[am] = Integer.MAX_VALUE;

		amountMinCases[0] = 0; // 0원을 coin 0개로 만들 수 있음.

		for (int am = 1; am < amountMinCases.length; am++) {

			for (int c = 0; c < coins.length; c++) {

				int prevAmount = am - coins[c];
				if (prevAmount < 0 || amountMinCases[prevAmount] == Integer.MAX_VALUE)
					continue;

				amountMinCases[am] = Math.min(amountMinCases[am], amountMinCases[prevAmount] + 1);
			}

		}

		if (amountMinCases[amount] == Integer.MAX_VALUE)
			return -1;

		return amountMinCases[amount];
	}
}
