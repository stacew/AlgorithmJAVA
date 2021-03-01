package leetcode.hash;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class TopKFrequentWords_692 {

	class pair {
		String word;
		int count;

		public pair(String _word, int _count) {
			word = _word;
			count = _count;
		}

		public int getCount() {
			return count;
		}
	}

	public List<String> topKFrequent(String[] words, int k) {

		HashMap<String, Integer> hm = new HashMap<>();
		for (int i = 0; i < words.length; i++)
			hm.put(words[i], hm.getOrDefault(words[i], 0) + 1);

		List<pair> wcList = new ArrayList<>();
		for (String key : hm.keySet())
			wcList.add(new pair(key, hm.get(key)));

		//wcList.sort(Comparator.comparing(pair::getCount).reversed());
		wcList.sort(new Comparator<pair>() {
			public int compare(pair p1, pair p2) {
				if( p1.count == p2.count )
					return p2.word.compareTo(p1.word);
				
				return p2.count - p1.count;
			}
		});

		List<String> listRet = new ArrayList<>();
		for (int i = 0; i < k; i++)
			listRet.add(wcList.get(i).word);

		return listRet;
	}
}
