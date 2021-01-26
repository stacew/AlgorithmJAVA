import java.util.ArrayList;
import java.util.List;

//BT는 O(n*n!) <= T <= n^2*n!
//swap 방식 구현 시, O(n!) <= T <= n*n! 가능
public class Permutations_46 {

	public List<List<Integer>> permute(int[] nums) {
		mRet = new ArrayList<>();
		mNums = nums;
		
		BT(new boolean[nums.length], new ArrayList<>());
		return mRet;
	}
	
	@SuppressWarnings("unchecked")
	private void BT(boolean[] arr, ArrayList<Integer> a_list) {
		if( a_list.size() == mNums.length ) {
			mRet.add( (List<Integer>)a_list.clone());
			return ;
		}
		
    	for (int i = 0; i < arr.length; i++) {
			if (arr[i] == false) {
				a_list.add(mNums[i]);
				arr[i] = true;
				BT(arr.clone(), a_list);
				arr[i] = false;
				a_list.remove(a_list.size()-1);
			}
		}			
	}
	
	private List<List<Integer>> mRet;
	private int[] mNums;
}
