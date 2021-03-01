package leetcode.hash;

import java.util.HashMap;

public class WordPattern_290 {
	public boolean wordPattern(String pattern, String s) {
		HashMap<Character, Integer> hm1 = new HashMap<Character, Integer>();
		HashMap<String, Integer> hm2 = new HashMap<String, Integer>();

		char[] pp = pattern.toCharArray();
		String[] ss = s.split(" ");
		if (pp.length != ss.length)
			return false;

		for (int i = 0; i < pp.length; i++) {
			if (hm1.containsKey(pp[i]) == false)
				hm1.put(pp[i], hm1.size());
			if (hm2.containsKey(ss[i]) == false)
				hm2.put(ss[i], hm2.size());

			if (hm1.get(pp[i]) != hm2.get(ss[i]))
				return false;
		}

		return true;
	}
}
