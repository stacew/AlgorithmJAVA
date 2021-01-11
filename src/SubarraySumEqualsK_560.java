import java.util.HashMap;
import java.util.HashSet;

// 1, 1, 1 _ 2 => 2
// 1, 2, 3 _ 3 => 2
// 1,-1, 0 _ 0 => 3

class SubarraySumEqualsK_560 {
	
	static public int subarraySum(int[] nums, int k) {
	
		for( int i = 1;  i < nums.length;  i++) {
			nums[i] = nums[i - 1] + nums[i];			
		}
		
		HashMap<Integer,Integer> hm = new HashMap<>();
	
		int retCount = 0;
		for( int i = 0; i < nums.length; i++ ) {			
			if( nums[i] == k )
				retCount++;
			
			retCount += hm.getOrDefault(nums[i]-k, 0);			
			hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
		}		 
		 return retCount;
	}
}
