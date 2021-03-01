package leetcode.hash;

import java.util.HashMap;

public class ValidAnagram_242 {
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;

		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
			hm.put(t.charAt(i), hm.getOrDefault(t.charAt(i), 0) - 1);
		}

		for (int i = 0; i < s.length(); i++) {
			if (hm.get(s.charAt(i)) != 0)
				return false;
		}

		return true;
	}
}
