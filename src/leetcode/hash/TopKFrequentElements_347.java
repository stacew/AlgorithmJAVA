package leetcode.hash;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class TopKFrequentElements_347 {
	class pair {
		int nums;
		int count;

		pair(int _nums, int _count) {
			nums = _nums;
			count = _count;
		}

		int getCount() {
			return count;
		}
	}

	public int[] topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++)
			hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);

		List<pair> list = new ArrayList<>();
		for (int key : hm.keySet())
			list.add(new pair(key, hm.get(key)));

		list.sort(Comparator.comparing(pair::getCount).reversed());

		int[] ret = new int[k];
		for (int i = 0; i < k; i++)
			ret[i] = list.get(i).nums;

		return ret;
	}
}
