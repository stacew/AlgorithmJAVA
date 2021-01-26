import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

//380. Insert Delete GetRandom O(1)
public class RandomizedSet_380 {

	private List<Integer> m_al;
	private HashMap<Integer, Integer> m_hm;
    /** Initialize your data structure here. */
    public RandomizedSet_380() {
    	m_hm = new HashMap<>();       
    	m_al = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
    	if( m_hm.containsKey(val) )
    		return false;
    	
    	m_hm.put(val, m_al.size());
    	m_al.add(val);
    	return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
    	if( m_hm.containsKey(val ) == false )
    		return false;

    	int alIndex = m_hm.remove(val);
    	int lastIndex = m_al.size() - 1;
		if( alIndex == lastIndex) //target == 마지막 인덱스, 제거만 처
			m_al.remove(lastIndex);
		else {
			int lastVal = m_al.remove(lastIndex);
			m_al.set(alIndex, lastVal);	 //target == 중간 인덱스, 마지막 인덱스를 제거 후 중간 인덱스에 씌움.
			m_hm.put(lastVal, alIndex); //해시 value의 인덱스 갱신
		}
    	return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
    	int rand = (int)(Math.random() * m_al.size());
    	return m_al.get(rand);
    }
}
