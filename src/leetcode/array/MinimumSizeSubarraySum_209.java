package leetcode.array;
//array, sliding( directonal : positive integer condition )

//return the minimal length of a contiguous subarray
//subarray (sum >= target) 
//If there is no such subarray, return 0 instead.

//1 <= nums.length <= 10^5
//1 <= nums[i] <= 10^5
public class MinimumSizeSubarraySum_209 {

	static final int FAIL_MAX_LEN = (int) Math.pow(10, 5) + 1; // JAVA const XXX

	public int minSubArrayLen(int target, int[] nums) {
		int minLength = FAIL_MAX_LEN;

		int sum = 0;
		int leftIndex = -1;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i]; // for( i : plus directional )

			while (sum >= target) {
				minLength = Math.min(minLength, i - leftIndex);
				sum -= nums[++leftIndex];// while ( leftIndex : minus directional )
			}
		}

		if (minLength == FAIL_MAX_LEN)
			return 0;

		return minLength;
	}
}
