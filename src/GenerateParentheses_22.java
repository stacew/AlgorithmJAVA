import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_22 {

	void BT(StringBuilder str, int countL, int countR) {
		if (str.length() == mCountL * 2) {
			if (countL > mCountL)
				return;
			mRet.add(str.toString());
			return;
		}

		if (countL < mCountL) {
			// BT(new StringBuilder(str.toString()).append('('), countL + 1, countR);
			str.append('(');
			BT(str, countL + 1, countR);
			str.setLength(str.length() - 1);
		}
		
		if (countL > countR) {
			// BT(new StringBuilder(str.toString()).append(')'), countL, countR + 1);
			str.append(')');
			BT(str, countL, countR + 1);
			str.setLength(str.length() - 1);
		}
		
	}

	public List<String> generateParenthesis(int n) {
		mCountL = n;
		mRet = new ArrayList<String>();
		StringBuilder str = new StringBuilder();
		BT(str.append('('), 1, 0);
		return mRet;
	}

	int mCountL;
	List<String> mRet;
}
