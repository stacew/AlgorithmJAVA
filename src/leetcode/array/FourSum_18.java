package leetcode.array;
//new ArrayList<>(Arrays.asList(1,2,3)) -> List.of(1,2,3)
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum_18 {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> ret = new ArrayList<>();
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 3; i++) {
			if (i != 0 && nums[i - 1] == nums[i])// check duple
				continue;
			else if (nums[i] * 4 > target) // opti
				break;
			else if (nums[i] + nums[nums.length - 1] * 3 < target) // opti
				continue;

			for (int j = i + 1; j < nums.length - 2; j++) {
				if (j != i + 1 && nums[j - 1] == nums[j])// check duple
					continue;
				else if (nums[i] + nums[j] * 3 > target) // opti
					break;
				else if (nums[i] + nums[j] + nums[nums.length - 1] * 2 < target) // opti
					continue;

				int sum12 = nums[i] + nums[j];

				int l = j + 1;
				int r = nums.length - 1;
				while (l < r) {
					int sum34 = nums[l] + nums[r];
					if (sum12 + sum34 == target) {
						//ret.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[l], nums[r])));
						ret.add(List.of(nums[i], nums[j], nums[l], nums[r]));
						l++;
						r--;
						while (l < r && nums[l - 1] == nums[l])// check duple
							l++;
						while (l < r && nums[r] == nums[r + 1])// check duple
							r--;
					} else if (sum12 + sum34 < target) {
						l++;
					} else {
						r--;
					}
				}
			}
		}
		return ret;
	}
}
