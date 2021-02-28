package leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams_49 {
	public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, List<String>> hm = new HashMap<>();
		for (int i = 0; i < strs.length; i++) {

			char[] charArr = strs[i].toCharArray();
			Arrays.sort(charArr);
			String sorted = new String(charArr);

			if (hm.containsKey(sorted)) {
				hm.get(sorted).add(strs[i]);
			} else {
				hm.put(sorted, new ArrayList<String>());
				hm.get(sorted).add(strs[i]);
			}

		}
		
		List<List<String>> ret = new ArrayList<>();
		ret.addAll(hm.values());
		return ret;
	}
}
