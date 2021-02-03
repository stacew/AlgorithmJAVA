import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_22 {
	
	void BT(StringBuilder str, int count) {
		if( str.length() == countLP * 2 ) {
			if( count > countLP )
				return;
			mRet.add(str.toString());
			return;
		}
		
		if( count < countLP )
			BT(new StringBuilder(str.toString()).append('('), count + 1 );
		
		BT(new StringBuilder(str.toString()).append(')'), count );		
	}
	
    public List<String> generateParenthesis(int n) {
    	countLP = n;
        mRet = new ArrayList<String>();
        StringBuilder str = new StringBuilder();
        BT( str.append('('), 1 );   
        return mRet;
    }
    int countLP;
	List<String> mRet;
}
