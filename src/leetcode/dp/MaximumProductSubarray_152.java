package leetcode.dp;

public class MaximumProductSubarray_152 {

	// 0ms. idea : 좌측으로 진행하며 max구하고, 우측 진행하며 max 구하기.
	// maxSubArray의 처음이나 끝 부분의 음수 하나로 최대 값이 안 될 수 있기 때문에 양 방향 진행
	public int maxProduct(int[] nums) {
		int retMax = Integer.MIN_VALUE;
		int n = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0)
				n = 0;
			else
				n = (n == 0) ? nums[i] : n * nums[i];

			retMax = Math.max(retMax, n);
		}

		n = 0;
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] == 0)
				n = 0;
			else
				n = (n == 0) ? nums[i] : n * nums[i];

			retMax = Math.max(retMax, n);
		}

		return retMax;
	}

	// 2ms. dp
	// dp 음수 * 음수 최대값이 발생할 수 있기 때문에 min 값도 저장하면서 진행
	public int maxProductDP(int[] nums) {
		int[] maxdp = new int[nums.length];
		int[] mindp = new int[nums.length];
		int retMax = maxdp[0] = mindp[0] = nums[0];

		for (int i = 1; i < nums.length; i++) {
			int a = nums[i];
			int b = nums[i] * maxdp[i - 1];
			int c = nums[i] * mindp[i - 1];

			maxdp[i] = Math.max(a, Math.max(b, c));
			mindp[i] = Math.min(a, Math.min(b, c));

			retMax = Math.max(retMax, maxdp[i]);
		}

		return retMax;
	}

}
