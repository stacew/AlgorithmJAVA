# RemoveLinkedListElements_203
	remove 작업에 head를 지우기 위해 dummy를 이용하면 편함.
	
# MergeTwoSortedLists_21
	dummy node 이용하면 편함.
	null 처리
	O( n1 + n2 )t, O( 1 )s
	
# MiddleOfTheLinkedList_876
	fast/slow 방식이 멈출 때 slow
	
# LinkedListCycle_141
	loop를 확인하는 경우 fast/slow 방식으로 확인 가능.
	추가적으로 loop가 발생하는 위치를 찾으려면
	1. fast == slow 시점에 기존 반복문을 끝내고, fast를 다시 head로 이동
	2. fast도 1칸씩 이동하며, slow와 만나는 시점이 loop가 발생하는 시작점
	O( N + L )t, L은 loop안의 node의 개수
	=> O( N )t
	
	other ways. 
	1. hashSet으로 중복을 확인 가능. + O( N )s
	2. loop를 찾으려면 modify 방식도 가능
	
	etc.
	Array의 값을 index로 사용하는 경우에도 loop를 찾을 수 있다.
	
# IntersectionOfTwoLinkedLists_160
	두 linked list의 교차점 찾기
	두 헤드에 각각 탐색 노드를 만들고, null을 만난 노드는 반대편에서 다시 시작하면 결국 교차점에서 만나게 된다.
	
	other ways.
	하나의 헤드부터 hashSet에 저장하고, 두 번째 헤드부터 반복하면서 중복을 체크. + O( N )s

# ReverseLinkedList_206
	prev, cur, tempNext 3개의 노드를 진행하며 방향을 바꿔준다.

	가장 쉬운 방법.
	Array에 채워놓은 후 바꾸기. + O(N)s
	
# AddTwoNumbers_2, AddTwoNumbers_II_445
	- 역방향 합 결과 구하는 문제 ( easy )
	순서대로 합하면서 carray를 넘겨주면 된다.
	- 정방향 합 결과 구하는 문제 ( medium )
	각각의 LL을 뒤집어서 순서대로 합한 이후, 결과를 다시 뒤집어준다.
	
# RemoveNthNodeFromEndOfList_19	
	뒤에서 n번째 노드를 삭제하는 문제
	1. Array 이용 			O(n)t, O(n)s
	2. two pass counter 	O(n)t, O(1)s
		한 번 돌고 전체 길이를 파악 후 두 번 째에 처리
	3. two node, one pass O(n)t, O(1)s
		null을 만날 first node와 back node의 간격을 n만큼 만들고 진행
		
# PartitionList_86
	x를 기준으로 value가 작은 node와 큰 node를 분리하는 문제
	두 노드 더미 헤드를 이용하여 분리한 후 합치기.
	 
# ReorderList_143
	0, n - 1, 1, n - 2 순서대로 node들을 배치하는 문제
	LL의 기본 동작을 사용
	1. 중간을 구해서
	2. 분할하고
	3. 우측 리스트는 reverse 해주고
	4. 정해진 조건에 맞춰 reorder해준다.

# CopyListWithRandomPointer_138
	next pointer 외의 random pointer가 있는 LL을 Deep Copy하는 문제
	1. hashmap<기본 node, 기본 node index>와 복사된 node의 array를 두고, 연결.
	2. hashmap<기본 node, 복사된 node>로 기본 node를 key로 복사된 node를 value로 random pointer를 찾는 방법
	3 - 1. 기존 노드 뒤에 복사된 노드를 삽입하여 연결하면
	3 - 2. 기존 노드의 랜덤 정보를 다음 복사된 노드에게 넘겨줄 수 있다.
	3 - 3. 연결된 노드를 분할하면 된다.

# LRUCache_146
	Key-Value 구조의 cache, 저장 공간 limit (Least Recently Used : 가장 최근에 사용되지 않은 것 삭제) 
	hashmap에 key, node를 저장하여 get이나 put 수정이 발생하였을 때, 빠르게 tail로 보내는게 핵심

	중요.
	제공되는 컨테이너 양방향 리스트의 경우에는 중간 노드를 찾아서 삭제하는 remove()에서 탐색을 위한 O(n)t가 발생한다.
	그래서 Node Class에 prev, next를 추가하고 LRU Cache는 head, tail을 두고 직접 관리해야만 O(1)로 처리 가능

