package leetcode.hash;

import java.util.HashMap;

public class FirstUniqueCharacterInAString_387 {
	public int firstUniqChar(String s) {
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

		char ss[] = s.toCharArray();
		for (int i = 0; i < s.length(); i++) {
			hm.put(ss[i], hm.getOrDefault(ss[i], 0) + 1);
		}

		for (int i = 0; i < s.length(); i++) {
			if (hm.get(ss[i]) == 1)
				return i;
		}

		return -1;

	}
}
