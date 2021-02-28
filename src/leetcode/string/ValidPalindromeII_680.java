package leetcode.string;

public class ValidPalindromeII_680 {

	boolean validPalindrome_rec(String s, int chance) {
		int l = 0;
		int r = s.length() - 1;
		while (l < r) {
			if (s.charAt(l) != s.charAt(r)) {
				if (chance == 0)
					return false;

				if (validPalindrome_rec(s.substring(l + 1, r + 1/* substring end */), chance - 1))
					return true;
				else if (validPalindrome_rec(s.substring(l, r - 1 + 1/* substring end */), chance - 1))
					return true;

				return false;
			}

			l++;
			r--;
		}

		return true;
	}

	public boolean validPalindrome(String s) {
		int chance = 1;
		return validPalindrome_rec(s, chance);
	}
}
