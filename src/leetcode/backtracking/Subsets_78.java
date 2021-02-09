package leetcode.backtracking;
import java.util.LinkedList;
import java.util.List;

public class Subsets_78 {
	List<List<Integer>> mList;
	int[] mNums;

	private void BT(int a_nIndex, LinkedList<Integer> pInt) {
		if (a_nIndex == -1) {
			mList.add(pInt);
			return;
		}

		BT(a_nIndex - 1, pInt);
		
		LinkedList<Integer> pInt2 = (LinkedList<Integer>) pInt.clone();
		pInt2.addFirst(mNums[a_nIndex]);
		BT(a_nIndex - 1, pInt2);
	}

	public List<List<Integer>> subsets(int[] nums) {
		mNums = nums;
		mList = new LinkedList<>();
        mList.add(new LinkedList<Integer>()); //???
		for (int i = 0; i < nums.length; i++) {
			LinkedList<Integer> pInt = new LinkedList<Integer>();
			pInt.add(mNums[i]);
			BT(i - 1, pInt);
		}

		return mList;
	}
}
