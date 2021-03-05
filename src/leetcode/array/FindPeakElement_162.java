package leetcode.array;
//find a peak element, and return its index.

//If the array contains multiple peaks, return the index to any of the peaks.
//nums[-1] = nums[n] = -∞

//1 <= nums.length
//nums[i] != nums[i + 1]
//O(logN)

public class FindPeakElement_162 {
	public int findPeakElement(int[] nums) {
		if (nums.length == 1)
			return 0;

		int l = 0;
		int r = nums.length - 1;
		int mid = 0;

		while (l <= r) {

			mid = (l + r) / 2;

			int left = mid - 1 >= 0 ? nums[mid - 1] : Integer.MIN_VALUE;
			int right = mid + 1 < nums.length ? nums[mid + 1] : Integer.MIN_VALUE;
			if (left < nums[mid] && nums[mid] > right) // check peak
				return mid;

			if (left < right) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}

		return mid;
	}

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

	// 정석이긴 한데 너무 어려움... 그림으로 확인하고 mid의 위치와 이동, 종료 조건 처리
	public int findPeakElement__(int[] nums) {
		if (nums.length == 1)
			return 0;

		int l = 0, r = nums.length - 1;

		while (l < r) { // < 
			int mid = (l + r) / 2;
			int num = nums[mid];
			int nextNum = nums[mid + 1];

			if (num < nextNum)
				l = mid + 1;
			else
				r = mid; //mid가 peek에 포함 될 수 있으니 -1 하지 않는다.
		}

		return l; //or return r; (left, right가 만나는 순간에 종료)
	}
}
