
public class DecodingWays_91 {
	public int numDecodings(String s) {
		if( s.charAt(0) == '0' )
			return 0;
		
		int[] dp = new int[s.length()];
		dp[0] = 1;
		for( int i = 1; i < s.length(); i++) {
			
			if( s.charAt(i) != '0' )
				dp[i] += dp[i-1];
			
			if( s.charAt(i-1) =='1' || ( s.charAt(i-1) =='2' && s.charAt(i) <= '6') ) {
				if( i - 2 >= 0 )
					dp[i] += dp[i-2];
				else
					dp[i] += 1;				
			}			
		}
		
		return dp[s.length()-1];
	}
}
