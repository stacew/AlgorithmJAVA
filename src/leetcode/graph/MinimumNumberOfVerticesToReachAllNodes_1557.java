package leetcode.graph;

import java.util.ArrayList;
import java.util.List;
//directed acyclic graph (DAG)의 모든 node 순회

//Find the smallest set of vertices from which all nodes in the graph are reachable. 
//n : vertex count
public class MinimumNumberOfVerticesToReachAllNodes_1557 {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
    	boolean target[] = new boolean[n];
        for( int i =0; i < edges.size(); i++ ) {
        	target[edges.get(i).get(1)] = true;
        }
        
        List<Integer> ret = new ArrayList<>();
        for( int i = 0; i < target.length; i++)
        	if( target[i] == false )
        		ret.add(i);
    	
        return ret;
    }
}
