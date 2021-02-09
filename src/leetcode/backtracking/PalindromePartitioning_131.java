package leetcode.backtracking;
import java.util.ArrayList;
import java.util.List;
//O(2^n * n) 의 시간 복잡도에서
//checkPalindrome()의 O(n) 작업을
//DP 2차원 테이블로 palindrome의 성질을 O(n^2) 작업으로 미리 세팅해두면
//O(2^n + n^2) => O(2^n)으로 축소 가능하다.

public class PalindromePartitioning_131 {

	boolean checkPalindrome(int lpos, int rpos) {
		do {
			if (ms.charAt(lpos) != ms.charAt(rpos)) {
				return false;
			}
		} while (++lpos <= --rpos);
		return true;
	}

	void BT(List<String> a_cur, int index) {
		if (ms.length() == index) {
			mRet.add(new ArrayList<>(a_cur));
			return;
		}

		for (int right = ms.length() - 1; right >= index; right--) {
			if (checkPalindrome(index, right) == false)
				continue;

			a_cur.add(ms.substring(index, right + 1));
			BT(a_cur, right + 1);
			a_cur.remove(a_cur.size() - 1);
		}
	}

	public List<List<String>> partition(String s) {
		mRet = new ArrayList<List<String>>();
		ms = s;
		BT(new ArrayList<String>(), 0);
		return mRet;
	}

	String ms;
	List<List<String>> mRet;
}
