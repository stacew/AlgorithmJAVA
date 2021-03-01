package leetcode.hash;

import java.util.HashMap;
import java.util.HashSet;

// 1, 1, 1 _ 2 => 2
// 1, 2, 3 _ 3 => 2
// 1,-1, 0 _ 0 => 3

public class SubarraySumEqualsK_560 {

	public int subarraySum(int[] nums, int k) {

		for (int i = 1; i < nums.length; i++)
			nums[i] = nums[i - 1] + nums[i]; // cumulative, 누적합 정보 생성

		HashMap<Integer, Integer> hm = new HashMap<>();// key value : 누적합, 누적합 개수
		hm.put(0, 1); // 0 base

		int subArrayCount = 0;
		for (int i = 0; i < nums.length; i++) {
			subArrayCount += hm.getOrDefault(nums[i] - k, 0); // find : nums[i] - k
			hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
		}

		return subArrayCount;
	}
}
