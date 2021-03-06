package leetcode.array;

//return while initializing new ArrayList.( Arrays.asList )
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ThreeSum_15 {
	// target, (not contain duplicate)
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> mRet = new ArrayList<List<Integer>>();
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
				if (peak + sum2 == 0) {
					mRet.add(new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[r])));
					int checkDuple = r--;
					while (nums[checkDuple] == nums[r] && l < r)
						r--;
					checkDuple = l++;
					while (nums[checkDuple] == nums[l] && l < r)
						l++;
				} else if (peak + sum2 > 0) {
					r--;
				} else {
					l++;
				}
			}
		}
		return mRet;
	}

	// BT 연습 ( 중복 포함 )
	public List<List<Integer>> threeSum_BT_(int[] nums) {
		List<List<Integer>> mRet = new ArrayList<List<Integer>>();
		Stack<int[]> oStack = new Stack<>();
		for (int index = 0; index < nums.length; index++)
			oStack.add(new int[] { index });

		while (oStack.empty() == false) {
			int[] popArr = oStack.pop();
			if (popArr.length == 1) {
				for (int index = popArr[0] + 1; index < nums.length; index++) {
					oStack.add(new int[] { popArr[0], index });
				}
			} else if (popArr.length == 2) {
				for (int index = popArr[1] + 1; index < nums.length; index++) {
					oStack.add(new int[] { popArr[0], popArr[1], index });
				}
			} else {
				if (0 == nums[popArr[0]] + nums[popArr[1]] + nums[popArr[2]]) {
					mRet.add(new ArrayList<>(Arrays.asList(nums[popArr[0]], nums[popArr[1]], nums[popArr[2]])));
				}
			}
		}

		return mRet;
	}

	// BT 연습 ( 중복 제거 ) O( 2^N )
	public List<List<Integer>> threeSum_BT(int[] nums) {
		List<List<Integer>> mRet = new ArrayList<List<Integer>>();
		Stack<int[]> stkIndex = new Stack<>();

		Arrays.sort(nums);
		for (int index = 0; index < nums.length - 2; index++) {
			if (index > 0 && nums[index] == nums[index - 1]) // check duplicate
				continue;

			stkIndex.add(new int[] { index });
		}

		while (stkIndex.empty() == false) {
			int[] popArr = stkIndex.pop();

			if (popArr.length == 1) {

				for (int index = popArr[0] + 1; index < nums.length - 1; index++) {
					if (index > popArr[0] + 1 && nums[index] == nums[index - 1]) // check duplicate
						continue;

					stkIndex.add(new int[] { popArr[0], index });
				}

			} else if (popArr.length == 2) {

				for (int index = popArr[1] + 1; index < nums.length; index++) {
					if (index > popArr[1] + 1 && nums[index] == nums[index - 1]) // check duplicate
						continue;

					stkIndex.add(new int[] { popArr[0], popArr[1], index });
				}

			} else {
				if (0 == nums[popArr[0]] + nums[popArr[1]] + nums[popArr[2]]) {

					mRet.add(new ArrayList<>(Arrays.asList(nums[popArr[0]], nums[popArr[1]], nums[popArr[2]])));

				}
			}
		}

		return mRet;
	}
}
