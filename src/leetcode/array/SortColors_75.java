package leetcode.array;

//빨리 구현하려면 그냥 counting sort..
//*. 구현 때, 디버깅 많이 필요하면 조건을 확실히 나눠서 처리 
public class SortColors_75 {
	public void sortColors(int[] nums) {
		int i0 = 0, i2 = nums.length - 1;
		int pivot = 0;
		while (pivot <= i2) {
			if (nums[pivot] == 0) {
				pivot++;
			} else if (nums[pivot] == 1) {
				nums[pivot] = nums[i0];
				nums[i0] = 1;
				i0++;
			} else if (nums[pivot] == 2) {
				nums[pivot] = nums[i2];
				nums[i2] = nums[pivot];
				i2--;
			}
		}
	}
}