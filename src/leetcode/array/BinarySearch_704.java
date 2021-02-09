package leetcode.array;

public class BinarySearch_704 {
	public int search(int[] nums, int target) {
    	int l = 0;
    	int r = nums.length -1; // -1 인덱스 표시 주의
    	
    	while( l <= r ) { //길이 1개 일 때 생각
            int mid = (l + r) / 2; //미드 중앙 가능
    		if( target == nums[mid] ) {
    			return mid;    			
    		}else if( target < nums[mid] ) {
    			r = mid - 1;    			
    		}else {
    			l = mid + 1;
    		}    		
    	}	
    	return -1;       
    }
}
