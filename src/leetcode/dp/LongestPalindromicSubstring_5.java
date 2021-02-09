package leetcode.dp;

public class LongestPalindromicSubstring_5 {
	public String longestPalindrome(String s) {
		int len = s.length();
		int[] arr = new int[len];
		int maxStartIndex = 0;
		int maxEndIndex = 0;
		int maxDistance = 0;
		for (int i = 0; i < len; i++) {

			int count = 0;
			do {
				int left = i - count;
				int right = i + 1 + count;
				if (left < 0 || right >= len)
					break;
				else if (s.charAt(left) != s.charAt(right))
					break;
				else if (arr[left] >= right)
					break;

				arr[left] = right;
				if (right - left > maxDistance) {
					maxDistance = right - left;
					maxEndIndex = right;
					maxStartIndex = left;
				}

				count++;
			} while (true);

			count = 0;
			do {
				int left = i - count;
				int right = i + 2 + count;
				if (left < 0 || right >= len)
					break;
				else if (s.charAt(left) != s.charAt(right))
					break;
				else if (arr[left] >= right)
					break;

				arr[left] = right;
				if (right - left > maxDistance) {
					maxDistance = right - left;
					maxEndIndex = right;
					maxStartIndex = left;
				}

				count++;
			} while (true);
		}

		return s.substring(maxStartIndex, maxEndIndex + 1);
	}
}
