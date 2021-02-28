package leetcode.string;

public class ValidPalindrome_125 {
	boolean isCand(char c) {
		if (c >= 'a' && c <= 'z')
			return true;
		if (c >= 'A' && c <= 'Z')
			return true;
		if (c >= '0' && c <= '9')
			return true;
		return false;
	}

	char upper(char c) {
		if (c >= 'a' && c <= 'z')
			return (char) ('A' + (c - 'a'));
		return c;
	}

	public boolean isPalindrome(String s) {
		int l = 0;
		int r = s.length() - 1;
		while (l < r) {
			while (l < r && isCand(s.charAt(l)) == false)
				l++;
			while (l < r && isCand(s.charAt(r)) == false)
				r--;
			if (l < r && upper(s.charAt(l++)) != upper(s.charAt(r--)))
				return false;
		}

		return true;
	}
}
