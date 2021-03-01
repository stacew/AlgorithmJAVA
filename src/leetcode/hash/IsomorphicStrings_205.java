package leetcode.hash;

import java.util.HashMap;

public class IsomorphicStrings_205 {
	public boolean isIsomorphic(String s, String t) {
		HashMap<Character, Integer> hm1 = new HashMap<Character, Integer>();
		HashMap<Character, Integer> hm2 = new HashMap<Character, Integer>();

		char ss[] = s.toCharArray();
		char tt[] = t.toCharArray();

		int loop = s.length();
		for (int i = 0; i < loop; i++) {
			// 1
			if (hm1.containsKey(ss[i]) == false)
				hm1.put(ss[i], hm1.size());

			// 2
			if (hm2.containsKey(tt[i]) == false)
				hm2.put(tt[i], hm2.size());

			if (hm1.get(ss[i]) != hm2.get(tt[i]))
				return false;

		}

		return true;

	}

	public boolean isIsomorphic_char(String s, String t) {
		HashMap<Character, Character> hm1 = new HashMap<Character, Character>();
		HashMap<Character, Character> hm2 = new HashMap<Character, Character>();

		char ss[] = s.toCharArray();
		char tt[] = t.toCharArray();

		int loop = s.length();
		for (int i = 0; i < loop; i++) {
			// 1
			if (hm1.containsKey(ss[i]) == false)
				hm1.put(ss[i], tt[i]);

			// 2
			if (hm2.containsKey(tt[i]) == false)
				hm2.put(tt[i], ss[i]);

			if (hm1.get(ss[i]) != tt[i] || hm2.get(tt[i]) != ss[i])
				return false;

		}

		return true;

	}
}
