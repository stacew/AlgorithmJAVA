package leetcode.string;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters_3 {

	public int lengthOfLongestSubstring(String s) {

		HashMap<Character, Integer> hm = new HashMap<>();
		int maxLen = 0;
		int start = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (hm.getOrDefault(c, Integer.MIN_VALUE) >= start) { //start ex) "abba"
				start = hm.get(c) + 1;
			}
			hm.put(c, i);
			maxLen = Math.max(i - start + 1, maxLen);
		}

		return maxLen;
	}

}
