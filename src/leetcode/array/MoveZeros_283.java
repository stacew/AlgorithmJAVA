package leetcode.array;

//move all 0's to the end
public class MoveZeros_283 {
	public void moveZeroes(int[] nums) {
		int insertPos = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[insertPos] = nums[i];
				if (insertPos != i)
					nums[i] = 0;
				insertPos++;
			}
		}
	}
}
