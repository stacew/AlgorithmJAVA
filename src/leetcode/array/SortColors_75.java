package leetcode.array;

//in-place 3type swap
//빨리 구현하려면 그냥 counting sort..
//*. 구현 때, 디버깅 많이 필요하면 조건을 확실히 나눠서 처리 
public class SortColors_75 {

	private void swap(int[] ints, int i1, int i2) {
		int t = ints[i1];
		ints[i1] = ints[i2];
		ints[i2] = t;
	}

	public void sortColors(int[] nums) {

		int i0 = 0;
		int i2 = nums.length - 1;

		for (int p = 0; p <= i2;) {// p is pivot
			if (nums[p] == 2) {
				swap(nums, p, i2--);
			} else if (nums[p] == 0) {
				swap(nums, p, i0++);
				p++;
			} else {
				p++;
			}
		}

	}

}