package leetcode.array;

//array<int[]>. comparator(lambda), list.toArray( list -> T[] )  
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//merge all overlapping intervals, and return an array of the non-overlapping intervals
//1 <= intervals.length <= 10^4
//intervals[i].length == 2
//0 <= starti <= endi <= 10^4
public class MergeIntervals_56 {
	public int[][] merge(int[][] intervals) {

//		@Override
//		Arrays.sort(intervals, new Comparator<int[]>() {
//			public int compare(int[] o1, int[] o2) {
//				return o1[0] - o2[0];
//			}
//		});
		Arrays.sort(intervals, (int[] a, int[] b) -> a[0] - b[0]); // java lambda

		List<int[]> temp = new ArrayList<>(); // Type : int[]허용

		int l = intervals[0][0];
		int r = intervals[0][1];
		for (int i = 1; i < intervals.length; i++) {
			int a_l = intervals[i][0];
			int a_r = intervals[i][1];
			if (a_r < r)
				continue;
			else if (a_l > r) {
				temp.add(new int[] { l, r });
				l = a_l;
				r = a_r;
			} else {
				r = a_r;
			}
		}

		temp.add(new int[] { l, r });

		return temp.toArray(new int[temp.size()][]); // Array -> T[]
	}
}
