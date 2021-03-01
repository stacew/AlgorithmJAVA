package leetcode.hash;

import java.util.HashMap;

// 0과 1의 배열에서 개수가 같으면 subArray로 표현
// return subArray 중 최대 길이 
// 풀이. -1과 1로 바꿔 누적합 처리로 푼다.
class ContiguousArray_525 {

	static public int findMaxLength(int[] nums) {
		int retMax = 0;

		for (int i = 0; i < nums.length; i++)
			nums[i] = nums[i] == 0 ? -1 : 1;

		for (int i = 1; i < nums.length; i++)
			nums[i] = nums[i - 1] + nums[i]; // 누적합

		HashMap<Integer, Integer> hm = new HashMap<>();
		hm.put(0, -1); // 0 값에 대한 distance 처리

		for (int i = 0; i < nums.length; i++) {
			int find = nums[i];

			if (hm.containsKey(find)) {
				int dist = i - hm.get(find);
				retMax = Math.max(retMax, dist); // 최대값 확인
			} else {
				hm.put(find, i); // 최대 length만 필요하여 최초에 나온 key만 삽입.
			}
		}
		return retMax;
	}

	static public int findMaxLength_(int[] nums) {
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
