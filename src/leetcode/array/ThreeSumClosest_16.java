package leetcode.array;
//closest init value, check abs
import java.util.Arrays;

public class ThreeSumClosest_16 {
	public int threeSumClosest(int[] nums, int target) {
		int closest = nums[0] + nums[1] + nums[2];
		Arrays.sort(nums);

		for (int i = 0; i < nums.length; i++) {
			int peak = nums[i];
			if (i > 0 && nums[i] == nums[i - 1]) // check duplicate
				continue;

			// twoPoint
			int l = i + 1;
			int r = nums.length - 1;
			while (l < r) {
				int sum2 = nums[l] + nums[r];
				if (peak + sum2 == target)
					return target;
				else if (peak + sum2 > target)
					r--;
				else
					l++;

				if (Math.abs(target - (peak + sum2)) < Math.abs(target - closest))
					closest = peak + sum2;
			}
		}

		return closest;
	}
}
