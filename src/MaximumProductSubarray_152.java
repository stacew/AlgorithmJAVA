
//dp 점화식 교차 진행 문제..
//dp로 풀었지만 더 최적화된 방법은... 좌측방향 진행하며 max만 구하고, 우측방향 진행하며 max만 구하는 방법
public class MaximumProductSubarray_152 {
	public int maxProduct(int[] nums) {
        int[] mindp = new int[nums.length];
        int[] maxdp = new int[nums.length];
		mindp[0] = nums[0];
		maxdp[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int n = nums[i];
			if (n == 0) {
				mindp[i] = 0;
				maxdp[i] = 0;
				continue;
			}
        
			maxdp[i] = Math.max(Math.max(mindp[i-1] * n, maxdp[i-1] * n), n);
            mindp[i] = Math.min(Math.min(mindp[i-1] * n, maxdp[i-1] * n), n);
		}
        
        int max = maxdp[0];
        for( int i = 1; i < nums.length; i++){
            max = Math.max(max, maxdp[i]);
        }
        
		return max;
	}
}

//brute-force optimization O(n^2)
//public int maxProduct(int[] nums) {
//	int max = nums[0];
//    for( int i = 0; i < nums.length; i++ ) {
//        int in = 1;
//        for( int j = i; j < nums.length; j++ ) {
//            in *= nums[j];
//            if( in > max )
//                max = in;
//        }
//    }
//    return max;
//}