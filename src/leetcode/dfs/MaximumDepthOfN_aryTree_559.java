package leetcode.dfs;

import java.util.List;

public class MaximumDepthOfN_aryTree_559 {
	public int maxDepth(Node root) {
        if( root == null )
            return 0;
        
		int depth = 1;
		for (int i = 0; i < root.children.size(); i++) {
			depth = Math.max(depth, maxDepth(root.children.get(i)) + 1 );
		}		
		return depth;
	}
}

class Node {
	public int val;
	public List<Node> children;

	public Node() {
	}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, List<Node> _children) {
		val = _val;
		children = _children;
	}
};