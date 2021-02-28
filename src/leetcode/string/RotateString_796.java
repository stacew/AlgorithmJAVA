package leetcode.string;

public class RotateString_796 {
	public boolean rotateString(String A, String B) {
		if (A.length() != B.length())
			return false;
        
		
		//return (RabinKarp.RabinKarp(A + A, B) != -1) ? true : false;
		return (A+A).contains(B);
	}
}
