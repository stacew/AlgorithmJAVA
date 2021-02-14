package leetcode.array;

//array, use value as index, modify, fast/slow
//(cond : num values < size )
//modify index move
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
	public int findDuplicate_modify(int[] nums) {
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
}
