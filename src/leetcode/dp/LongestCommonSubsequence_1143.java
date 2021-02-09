package leetcode.dp;

//DP(m,n) = 
//if ( t1[m] == t2[n] ){ 
//DP(m-1, n-1)  + 1
//}else{
//max( DP(m-1, n), DP(m, n-1) )
//}
public class LongestCommonSubsequence_1143 {
	public int longestCommonSubsequence(String text1, String text2) {
		int[] dpLast = new int[text2.length() + 1];
		int[] dpCur = new int[text2.length() + 1];
		int[] dpSwapTemp;
		dpCur[0] = 0;

		for (int r = 0; r < text1.length(); r++) {
			for (int i = 0; i < text2.length(); i++) {
				if (text1.charAt(r) == text2.charAt(i))
					dpCur[i + 1] = dpCur[i] + 1;
				else
					dpCur[i + 1] = Math.max(dpLast[i], dpCur[i + 1]);
			}
			dpSwapTemp = dpLast;
			dpLast = dpCur;
			dpCur = dpSwapTemp;
		}

		return dpLast[text2.length()];
	}
}
