package leetcode.array;
//find a peak element, and return its index.

//If the array contains multiple peaks, return the index to any of the peaks.
//nums[-1] = nums[n] = -∞

//1 <= nums.length
//nums[i] != nums[i + 1]
//O(logN)

public class FindPeakElement_162 {
//	public int findPeakElement(int[] nums) {
//		if (nums.length == 1)
//			return 0;
//		int l = 0;
//		int r = nums.length - 1;
//		int mid = (l + r) / 2;
//		while (l <= r) {
//			if (mid < nums.length - 1 && nums[mid] < nums[mid + 1]) {
//				l = mid + 1;
//			} else if (mid >= 1 && nums[mid - 1] > nums[mid]) {
//				r = mid - 1;
//			} else {
//				return mid;
//			}
//			mid = (l + r) / 2;
//		}
//		return mid;
//	}

	//정석이긴 한데 너무 어려움...
	public int findPeakElement(int[] nums) {
		if (nums.length == 1)
			return 0;

		int l = 0, r = nums.length - 1;

		while (l < r) { // <
			int mid = (l + r) / 2;
			if (nums[mid] > nums[mid + 1]) { //나누기 2하면 우측 +1은 무조건 가능하다.
				r = mid; //-1하면 음수 index 가능..
			} else {
				l = mid + 1; //나머지가 버려지는 걸 방지하기 위해 1증가..
			}
		}

		return r;//right를 반환..
	}
}
