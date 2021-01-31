import java.util.ArrayList;
import java.util.List;
		
public class RestoreIPAddresses_93 {
	public void BT(int lastIndex, String a_str, int callCount) {
		if (lastIndex == mS.length() - 1) {
			mRet.add(a_str.substring(0, a_str.length() - 2 + 1));
			return;
		} else if (callCount == 4) {
			return;
		}

		int n1 = mS.charAt(lastIndex + 1) - '0';
		BT(lastIndex + 1, a_str + mS.charAt(lastIndex + 1) + '.', callCount + 1);
		if (n1 == 0)
			return;

		if (lastIndex + 2 == mS.length())
			return;
		int n2 = mS.charAt(lastIndex + 2) - '0';
		BT(lastIndex + 2, a_str + mS.substring(lastIndex + 1, lastIndex + 2 + 1) + '.', callCount + 1);

		if (lastIndex + 3 == mS.length())
			return;
		int n3 = mS.charAt(lastIndex + 3) - '0';
		if (n1 * 100 + n2 * 10 + n3 > 255)
			return;
		BT(lastIndex + 3, a_str + mS.substring(lastIndex + 1, lastIndex + 3 + 1) + '.', callCount + 1);
	}

	public List<String> restoreIpAddresses(String s) {
		mS = s;
		mRet = new ArrayList<>();
		BT(-1, "", 0);
		return mRet;
	}

	private List<String> mRet;
	private String mS;
}
