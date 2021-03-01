package leetcode.hash;

import java.util.HashMap;
import java.util.HashSet;

class MinimumAreaRectangle_939 {
	static public int minAreaRect(int[][] points) {

		HashMap<Integer, HashSet<Integer>> hm = new HashMap<>();

		for (int i[] : points) {
			HashSet<Integer> hs = null;
			if (hm.containsKey(i[0]) == false) {
				hm.put(i[0], new HashSet<>());
			}
			hm.get(i[0]).add(i[1]);
		}

		int retMin = Integer.MAX_VALUE;
		for (int i = 0; i < points.length - 1; i++) {
			for (int j = i + 1; j < points.length; j++) {
				int x1 = points[i][0];
				int y1 = points[i][1];
				int x2 = points[j][0];
				int y2 = points[j][1];
				if (x1 == x2 || y1 == y2) // 대각선이 아니면 skip
					continue;

				int area = Math.abs((x2 - x1) * (y2 - y1));
				if (retMin < area) // opti
					continue;

				if (hm.get(x1).contains(y2) && hm.get(x2).contains(y1)) {
					retMin = Math.min(retMin, area);
				}

			}
		}

		return retMin == Integer.MAX_VALUE ? 0 : retMin;
	}
}
