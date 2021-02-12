package leetcode.graph;

//pair, sort(Comparator), memo
//way 1. countList (other. priority queue)
//way 2. memoization 
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//Return the k-th integer in the range [lo, hi] sorted by the power value.
//if x is even then x = x / 2
//if x is odd then x = 3 * x + 1
public class SortIntegersByThePowerValue_1387 {
	private int memo[];

	public int getKth(int lo, int hi, int k) {
		memo = new int[hi * 1000];
		List<Integer> list = new ArrayList<>();
		for (int i = lo; i <= hi; i++) {
			list.add(i);
		}

		list.sort(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				int i1 = getPower(o1);
				int i2 = getPower(o2);
				return i1 - i2;
			}

			private int getPower(int x) {
				if (x == 1)
					return 0;
				else if (memo[x] != 0)
					return memo[x];

				if ((x & 1) == 1)
					memo[x] = getPower(3 * x + 1) + 1;
				else
					memo[x] = getPower(x / 2) + 1;

				return memo[x];
			}
		});

		return list.get(k - 1);
	}
}

//1.
//public class SortIntegersByThePowerValue_1387 {
//	private class myPair{
//		public myPair(int _i, int _power) {
//			index = _i;
//			power = _power;
//		}
//		int index;
//		int power;
//	}
//    public int getKth(int lo, int hi, int k) {
//    	List<myPair> powerList = new ArrayList<myPair>();  
//    	for( int i = lo; i <= hi; i++) {
//    		int power = 0;
//    		int x = i;
//    		while( x != 1 ) {
//    			if( (x & 1) == 1 )
//    				x = 3 * x + 1;
//    			else
//    				x = x / 2;
//    			power++;
//    		}
//    		powerList.add(new myPair(i, power));
//    	}
//    	
//    	powerList.sort(new Comparator<myPair>() {
//			@Override
//			public int compare(myPair o1, myPair o2) {
//				return o1.power - o2.power;
//			}
//    	});
//    	
//    	return powerList.get(k - 1).index;
//    }
//}
