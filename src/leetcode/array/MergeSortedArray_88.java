package leetcode.array;
//Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3

//Output: [1,2,2,3,5,6]

//Input: nums1 = [1], m = 1, nums2 = [], n = 0
//Output: [1]
public class MergeSortedArray_88 {
	
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m -1;
        int index2 = n -1;
        
    	for( int i = nums1.length -1; i >=0 ; i--) {
    		if( index1 >= 0 && index2 >= 0) {
    			if( nums1[index1] > nums2[index2] )
    				nums1[i] = nums1[index1--];
    			else
    				nums1[i] = nums2[index2--];    		
    		}else if( index1 == -1 ) {
    			nums1[i] = nums2[index2--];
    		}else {
    			nums1[i] = nums1[index1--];
    		}
    	}        
    }
}
