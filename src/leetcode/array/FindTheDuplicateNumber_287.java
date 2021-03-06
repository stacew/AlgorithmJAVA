package leetcode.array;

//array, use value as index, modify, fast/slow
// cond : num values < size, nums[i] > 0
public class FindTheDuplicateNumber_287 {

	// fast/slow
	public int findDuplicate_(int[] nums) {
		//fast / slow로 loop 체크
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

	// Array의 값을 이용해 다음 index로 이동하며 이동했던 인덱스는 -1 세팅, 다음에 이동 시 -1이 세팅되어 있으면 중복
	public int findDuplicate_modifyMinus(int[] nums) {
		int next = 0;
		while (true) {
			if (nums[next] < 0)
				break;

			int nTemp = next;
			next = nums[next];
			nums[nTemp] *= -1;
		}
		return next;
	}

	// Array의 index에 해당 index 값을 세팅하며 이동하다가 세팅 되어 있으면 중복
	public int findDuplicate_modifyNext(int[] nums) {
		int next = nums[0];
		while (nums[next] != next) {
			int temp = nums[next];
			nums[next] = next;
			next = temp;
		}
		return next;
	}
}
