package leetcode.hash;
import java.util.HashMap;
//4,5,0,-2,-3,1 _ 5 => 7
class SubArraySumsDivisibleByK_974 {
    static public int subarraysDivByK(int[] A, int K) {
    	int retCount = 0;
    	int sumMod = 0;
    	HashMap<Integer, Integer> hm = new HashMap<>();
    	for(int i =0; i < A.length; i++) {
    		sumMod += A[i];
    		sumMod %= K;
    		sumMod = ( sumMod < 0 ) ? sumMod + K : sumMod;
    		 if( sumMod == 0 )
    			 retCount++;
    		 
    		 retCount += hm.getOrDefault(0, 0);    		 
    		 hm.put(sumMod, hm.getOrDefault(sumMod, 0) + 1);
    	}
    	
    	return retCount;
    }
}
