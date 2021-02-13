package leetcode.array;
//array sort(graph), *** usabilty 

//if you only sort this subarray in ascending order,
//then the whole array will be sorted in ascending order.
//Return the shortest such subarray and output its length.
//O(n) time.
//1 <= nums.length
public class ShortestUnsortedContinuousSubarray_581 {

	public int findUnsortedSubarray(int[] nums) {
		int end = -1;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < max) {
				end = i;
			}
			max = Math.max(max, nums[i]);
		}

		if (end == -1) //check
			return 0;

		int begin = -1;
		int min = Integer.MAX_VALUE;
		// *** reverse
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] > min) {
				begin = i;
			}
			min = Math.min(min, nums[i]);
		}

		return end - begin + 1;
	}

//	static final int MAX_VALUE = 100001;
//	static final int MIN_VALUE = -100001;
//
//	public int findUnsortedSubarray(int[] nums) {
//		int minPeakValue = MAX_VALUE;
//		for (int i = 1; i < nums.length; i++) {
//			if (nums[i - 1] > nums[i])
//				minPeakValue = Math.min(minPeakValue, nums[i]);
//		}
//		// check
//		if (minPeakValue == MAX_VALUE)
//			return 0;
//
//		int maxPeakValue = MIN_VALUE;
//		for (int i = nums.length - 2; i >= 0; i--) {
//			if (nums[i] > nums[i + 1])
//				maxPeakValue = Math.max(maxPeakValue, nums[i]);
//		}
//
//		int lpos = nums.length - 1;
//		for (int i = 0; i < nums.length; i++) {
//			if (nums[i] > minPeakValue) {
//				lpos = i;
//				break;
//			}
//		}
//		int rpos = 0;
//		for (int i = nums.length - 1; i >= 0; i--) {
//			if (nums[i] < maxPeakValue) {
//				rpos = i;
//				break;
//			}
//		}
//
//		return rpos - lpos + 1;
//	}
}
