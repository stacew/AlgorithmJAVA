package leetcode.array;
//array, sliding

//The pivot index : sum of all left of the index is equal to the sum of all index's right.
//Return the leftmost pivot index. If no such index exists, return -1.
//1 <= nums.length <= 104
//-1000 <= nums[i] <= 1000
public class FindPivotIndex_724 {
	public int pivotIndex(int[] nums) {
		int leftSum = 0;
		int rightSum = 0;
		for (int i = 0; i < nums.length; i++)
			rightSum += nums[i];

		for (int i = 0; i < nums.length; i++) {
			rightSum -= nums[i];
			if (leftSum == rightSum)
				return i;
			leftSum += nums[i];
		}
		return -1;
	}
}
