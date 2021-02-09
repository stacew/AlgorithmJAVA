package leetcode.hash;
import java.util.HashMap;

// 0과 1 개수가 같은 subArray 최대 길이
// 0, 1 => 2
// 0, 1, 0 => 2
// 1, 0, 0, 0, 0, 1 => 2
// 1, 0, 0, 0, 0, 1, 0, 0, 1 => 4
// 1, 0, 0, 0, 0, 1, 1, 0, 0, 1 => 6
// 1, 0, 1, 0,   1, 0, 1, 0,  1, 0 => 10
// 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1 => 12
// a, b, a => 2
// 풀이. 1과 -1로 바꿔 누적합 처리로 푼다.
class ContiguousArray_525 {
	static public int findMaxLength(int[] nums) {
		int retMax = 0;
		HashMap<Integer, Integer> hm = new HashMap<>();
		hm.put(0, -1); // 0 값에 대한 distance 처리

		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum = sum + (nums[i] == 0 ? -1 : 1); // 누적합

			if (hm.containsKey(sum)) {
				int dist = i - hm.get(sum);
				retMax = Math.max(retMax, dist);
			} else {
				hm.put(sum, i); // 최대 length만 필요하여 최초에 나온 key만 삽입.
			}
		}
		return retMax;
	}
}
