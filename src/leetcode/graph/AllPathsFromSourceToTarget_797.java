package leetcode.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//directed acyclic graph (DAG)
//n nodes labeled from 0 to n - 1
//find all possible paths from node 0 to node n - 1
public class AllPathsFromSourceToTarget_797 {
	private class myPair {
		public int[] nextArr;
		public List<Integer> recordList;

		public myPair(int[] _nextArr, int _node) {
			nextArr = _nextArr;
			recordList = new ArrayList<>();
			recordList.add(_node);
		}

		public myPair(int[] _nextArr, List<Integer> _list, int _node) {
			nextArr = _nextArr;
			recordList = new ArrayList<>(_list);
			recordList.add(_node);
		}
	}

	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		int target = graph.length - 1;

		Stack<myPair> stack = new Stack<>();
		stack.add(new myPair(graph[0], 0));

		while (stack.isEmpty() == false) {
			myPair popNext = stack.pop();

			for (int i = 0; i < popNext.nextArr.length; i++) {
				int nodeId = popNext.nextArr[i];
				if (nodeId == target) {
					List<Integer> targetList =new ArrayList<>(popNext.recordList);
					targetList.add(target);
					ret.add(targetList);
				} else {
					stack.add(new myPair(graph[nodeId], popNext.recordList, nodeId));
				}
			}
		}
		
		return ret;
	}
}
