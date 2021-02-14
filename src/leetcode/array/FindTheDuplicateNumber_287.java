package leetcode.array;

//array, use value as index, modify, fast/slow
// cond : num values < size, nums[i] > 0
public class FindTheDuplicateNumber_287 {
	// fast/slow
	public int findDuplicate(int[] nums) {
		int slow = nums[0];
		int fast = nums[0];
		do {
			slow = nums[slow];
			fast = nums[nums[fast]];
		} while (slow != fast);
		fast = nums[0];
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}
		return slow;
	}

	// modify
	public int findDuplicate_modifyMinus(int[] nums) {
		int n = 0;
		while (true) {
			if (nums[n] < 0)
				break;

			int nTemp = n;
			n = nums[n];
			nums[nTemp] = nums[nTemp] * -1;
		}
		return n;
	}

	public int findDuplicate_modifyNext(int[] nums) {
		int next = nums[0];
		int temp;
		while (nums[next] != next) {
			temp = nums[next];
			nums[next] = next;
			next = temp;
		}
		return next;
	}
}
