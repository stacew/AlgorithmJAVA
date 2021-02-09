package leetcode.hash;
import java.util.HashMap;
import java.util.HashSet;

class MinimumAreaRectangle_939 {
	static public int minAreaRect(int[][] points) {
		
		HashMap<Integer, HashSet<Integer>> hm = new HashMap<>();
		
		for(int i[] : points) {
			HashSet<Integer> hs = null;
			if( hm.containsKey(i[0]) == false) {
				hs = new HashSet<>();
				hm.put(i[0], hs);
			}else {
				hs = hm.get(i[0]);
			}				
			hs.add(i[1]);			
		}
		
		boolean bExist = false;
		int retMin = 40000 * 40000;
		for( int i =0 ; i < points.length - 1; i++ ) {
			for (int j = i + 1; j < points.length; j++ ) {
				
				if( points[i][0] == points[j][0] || points[i][1] == points[j][1])
					continue;
				
				if( hm.get(points[i][0]).contains(points[j][1]) && hm.get(points[j][0]).contains(points[i][1]) ) {
						int hor = Math.abs(points[i][0] - points[j][0]);
						int ver = Math.abs(points[i][1] - points[j][1]);
						retMin = Math.min(retMin, hor*ver);
						bExist = true;
				}
				
			}			
		}

		return bExist ? retMin : 0;
	}
}
