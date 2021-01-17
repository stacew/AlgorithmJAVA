import java.util.ArrayList;
import java.util.List;

//이클립스 = Ctrl + F11
//KeyMap(인텔리 J) = Shift + F10

public class Main {
	public static void main(String[] args) {
		System.out.println("--- start ---");

		List<String> oList = new ArrayList<>();
		oList.add("aa");
		oList.add("aab");
		WordBreak_139 solw = new WordBreak_139();
		solw.wordBreak("aabaab", oList);
		
		PalindromicSubstrings_647 sol = new PalindromicSubstrings_647();
		String s = "aaa";
		sol.countSubstrings(s);


		System.out.println("--- end ---");
	}
};
