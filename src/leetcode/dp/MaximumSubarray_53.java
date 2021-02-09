package leetcode.dp;

public class MaximumSubarray_53 {
	public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = max;
        for( int i = 1; i < nums.length; i++ ){
            if( sum < 0 ){
                sum = nums[i];
            }
            else{
                sum += nums[i];
            }
            
            if( max < sum )
                max = sum;            
                
        }
            
        
        return max;
    }
}