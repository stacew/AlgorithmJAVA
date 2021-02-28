package leetcode.string;

public class RabinKarp {
	private static int make_hash(String s, int length) {
		// other 1. 자릿수 마다 곱하기 해주면, hash값이 겹칠 확률이 적겠지만 sublength의 길이 제한이 걸림
		// other 2. bit rotation

		int hash = 0;
		for (int i = 0; i < length; i++)
			hash += s.charAt(i);
		return hash;
	}

	private static boolean myCompair(String a, String b) {
		for (int i = 0; i < b.length(); i++) {
			if (a.charAt(i) != b.charAt(i)) {
				return false;
			}
		}
		return true;
	}

	public static int RabinKarp(String base, String sub) {
		int subLength = sub.length();
		int baseLength = base.length();
		if (baseLength < subLength)
			return -1;
		if (baseLength == subLength)
			return myCompair(base, sub) ? 0 : -1;

		int subHash = make_hash(sub, subLength);
		int baseHash = make_hash(base, subLength - 1);
		for (int i = subLength - 1; i < baseLength; i++) {
			int baseLeft = i - subLength + 1;
			baseHash += base.charAt(i);

			if (baseHash == subHash) {
				if (myCompair(base.substring(baseLeft, i + 1/* end */), sub))
					return baseLeft;
			}

			baseHash -= base.charAt(baseLeft);
		}

		return -1;
	}
}
