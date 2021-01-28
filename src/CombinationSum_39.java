import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_39 {

	public void BT(int target, int index, ArrayList<Integer> curList) {
		if (target == 0) {
			m_retList.add(new ArrayList<>(curList));
			return;
		}

		for (int i = index; i < m_cand.length; i++) {
			if( target - m_cand[i] >= 0) {
				curList.add(m_cand[i]);
				BT(target-m_cand[i], i , curList);
				curList.remove(curList.size() -1 );
			}
		}
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		// Arrays.sort(candidates);
		m_cand = candidates;
		m_retList = new ArrayList<List<Integer>>();
		BT(target, 0, new ArrayList<>());
		return m_retList;
	}

	private List<List<Integer>> m_retList;
	private int[] m_cand;

}
