# Tree Order

##### dfs 
	- Pre Order
		Cur, left, right
	- In Order
		left, Cur, right	
	- Post Order
		left, right, Cur
		
##### dfs ( recursive )
	각 order에 적힌 순서대로 호출하면 된다.
	ex) preorder : callRecursive(root)
		1. cur 출력
		2. callRecursive(left)
		3. callRecursive(right)
		
	
##### dfs ( iterative stack )
	Pre Order
		1. stack에 root push
		2. top() 출력, pop()
		3. top()의 존재하는 right, left 순서대로 push
		*. empty까지 2 ~ 3 반복
		
	In Order
		*. LeftPushContinue()!!!
			push가 될 때 left가 없어질 때까지 계속 left를 쌓는다.
		0. stack에 root LeftPushContinue()
		1. top() 출력, pop()!!!, right가 존재하면 right를 LeftPushContinue()
		*. empty까지 1 반복
		
	Post Order
		*. CheckLastPopIsRight()!!!
			이전에 수행했던 작업이 Right Child Node 였는지 레퍼런스 체크
			Check 작업이 없다면 무한루프
		0. stack에 root LeftPushContinue()
		1 - 1. top()의 right가 존재하지 않는다면 top() 출력, pop()
		1 - 2. top()의 right가 존재하는데 CheckLastPopIsRight() == false 라면 right를 LeftPushContinue()
		1 - 3. top()의 right가 존재하는데 CheckLastPopIsRight() == true 라면 top() 출력, pop()
		*. empty까지 1의 조건들 반복 	
		


##### bfs ( queue )
	Level Order

# SymmetricTree_101
	tree의 center 기준으로 좌측, 우측이 mirror 형태로 있는지 check
	O(N)s, O(TreeDepth)t
	
# InvertBinaryTree_226
	child swap
	O(N)s, O(TreeDepth)t
	Homebrew 개발자 알고리즘 테스트 떨어진 문제
	
# PathSumII_113
	tree root부터 leaf까지의 경로 합 확인하기
	BackTracking 방식 O(N)t, O(Depth)s
	
# DiameterOfBinaryTree_543
	Diameter : 한 곳의 노드에서 다른 곳의 노드 까지의 최대 길이 ( root를 지나지 않아도 최대 길이가 될 수 있다 )
	O(N)t, O(Depth)s
	
# LowestCommonAncestorOfABinaryTree_236
	트리에서 주어진 두 노드 p, q의 가장 낮은 공통 조상을 찾는 문제
	풀이 : left와 right recursion이 둘 다 올라오는 곳의 위치가 가장 낮은 조상 노드.
	opti : 만약 자신이 p와 q 중 하나라도 같다면,
	자신의 하위에 다른 노드가 있다고 해도 자신이 가장 낮은 공통 조상이기 때문에 더 이상 child를 확인할 필요 없음.
	O(N)t, O(Depth)s
	
	
	
	
	