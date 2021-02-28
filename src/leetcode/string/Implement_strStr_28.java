package leetcode.string;

public class Implement_strStr_28 {
    public int strStr(String haystack, String needle) {
    	if( needle.isEmpty() )
    		return 0;
    	
		return RabinKarp.RabinKarp(haystack, needle);
    }
}
