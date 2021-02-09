package leetcode.bfs;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
class Pair<T1, T2>{
	T1 first;
	T2 second;
	Pair(T1 _t1, T2 _t2){
		first = _t1;
		second = _t2;
	}
}
public class EmployeeImportance_690 {
	public int getImportance(List<Employee> employees, int id) {
		//1.
		//HashMap<Integer, Integer> hmValue = new HashMap<>();
		//HashMap<Integer, List<Integer>> hmSubid = new HashMap<>();
		
		//2.
		HashMap<Integer, Map.Entry<Integer, List<Integer>>> hm = new HashMap<Integer, Map.Entry<Integer,List<Integer>>>();
		
		//3.
		HashMap<Integer, Pair<Integer, List<Integer>>> hm3 = new HashMap<>();
		
		
		for(int i =0; i < employees.size(); i++) {
			Employee em = employees.get(i);
			//1.
			//hmValue.put(em.id, em.importance);
			//hmSubid.put(em.id, em.subordinates);

			//2.
			hm.put(em.id, new AbstractMap.SimpleEntry<Integer, List<Integer>>(em.importance, em.subordinates));

			//3.
			hm3.put(em.id, new Pair<Integer, List<Integer>>(em.importance, em.subordinates));
		}
		
		Queue<Integer> Qid = new LinkedList<>();
		Qid.add(id);
		
		int ret = 0;
		while( Qid.isEmpty() == false ) {
			int poll_Id = Qid.poll();
			//1.
			//ret += hmValue.get(poll_Id);
			//List<Integer> subList = hmSubid.get(poll_Id);			
			//Qid.addAll(subList);
			//2.
			Map.Entry<Integer, List<Integer>> entry = hm.get(poll_Id);
			ret += entry.getKey();
			Qid.addAll(entry.getValue());
			
			//3.
			Pair<Integer, List<Integer>> pair = hm3.get(poll_Id);
			ret += pair.first;
			Qid.addAll(pair.second);					
		}
		
		return ret;
	}
}

class Employee {
	public int id;
	public int importance;
	public List<Integer> subordinates;
};
