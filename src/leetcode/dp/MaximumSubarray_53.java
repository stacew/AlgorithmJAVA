package leetcode.dp;

public class MaximumSubarray_53 {

	// dp 1ms, dp 배열 추가 공간 할당하면 dp[n] = max( arr[n], dp[n - 1] + arr[n] )
	public int maxSubArray_dp(int[] nums) {
		int retMax = nums[0];
		for (int i = 1; i < nums.length; i++) {
			nums[i] = Math.max(nums[i], nums[i - 1] + nums[i]);
			retMax = Math.max(retMax, nums[i]);
		}

		return retMax;
	}

	// 0ms. idea : 음수는 다음 최대 길이를 체크할 필요 없음. 
	public int maxSubArray_arrayEasy(int[] nums) {
		int max = nums[0];
		int sum = max;
		for (int i = 1; i < nums.length; i++) {
			sum = (sum < 0) ? nums[i] : sum + nums[i];
			if (max < sum)
				max = sum;
		}
		return max;
	}
}