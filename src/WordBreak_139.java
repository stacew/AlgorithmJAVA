import java.util.HashSet;
import java.util.List;

public class WordBreak_139 {
	public boolean wordBreak(String s, List<String> wordDict) {
	//O(s.length() * s.length())
	boolean[] dp = new boolean[s.length() + 1];
	dp[0] = true;
	
	HashSet<String> hs = new HashSet<>();
	for (int i = 0; i < wordDict.size(); i++) {
		hs.add(wordDict.get(i));
	}
	
	for (int i = 0; i < s.length(); i++) {
		if( dp[i] == false )
			continue;
		for( int j = i; j < s.length(); j++) {
			if( hs.contains(s.substring(i,  j + 1)) ) {
				dp[j + 1] = true;
				break;
			}			
		}
	}
	
	return dp[s.length()];
}
//	public boolean wordBreak(String s, List<String> wordDict) {
//		//O(s.length()*wordDict.size())
//		boolean[] dp = new boolean[s.length() + 1];
//		dp[0] = true;
//
//		for (int i = 0; i < s.length(); i++) {
//			for (String word : wordDict) {
//				int check = i - word.length() + 1;
//				if (check < 0 || dp[check] == false)
//					continue;
//				if (s.substring(check, i + 1).equals(word) ) {
//					dp[i + 1] = true;
//					break;
//				}
//			}
//		}
//
//		return dp[s.length()];
//	}
}

