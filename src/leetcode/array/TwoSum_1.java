package leetcode.array;

//return while initializing new array.
import java.util.HashMap;

public class TwoSum_1 {
	// 1. hash : O(N) time, O(N) space
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (hm.containsKey(target - nums[i])) {
				return new int[] { i, hm.get(target - nums[i]) };
			} else {
				hm.put(nums[i], i);
			}
		}
		return null;
	}

	// 2. sort, two pointer : O(NlogN + N) time, O(1) space
	// + sort : value limit ->  Counting Sort : O(N) time, O(N) space 
	// + sorted : ** two Pointer
}
