package leetcode.backtracking;
import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber_17 {
	private List<String> ret;
	private String m_digits;

	private char[][] text = { { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
			{ 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };

	private int getTextIndex(char c) {
		return c - '0' - 2;
	}

	private void recursive(int a_Index, String make) {
		if (a_Index == m_digits.length()) {
			ret.add(make);
			return;
		}

		int pos = getTextIndex(m_digits.charAt(a_Index));
		for (int i = 0; i < text[pos].length; i++)
			recursive(a_Index + 1, make + text[pos][i]);
	}

	public List<String> letterCombinations(String digits) {
		m_digits = digits;
		ret = new ArrayList<>();
		if (digits.length() == 0)
			return ret;

		recursive(0, "");
		return ret;
	}
}
