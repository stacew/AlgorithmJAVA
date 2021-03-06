# BinarySearch_704
	정렬된 상태에서만 사용 가능,
	while( l <= r ) left = mid + 1; right = mid - 1; 형태가 가독성 좋아 보인다.
	
# MoveZeros_283
	모든 0을 우측으로 이동 시키기
	1. 브루트 포스 : 같은 사이즈의 array를 만든 후, 0이 아닌 숫자를 앞에 인덱스 부터 넣는다. 공간복잡도 O(N) 증가
	2. in-place : 0이 아닌 숫자를 삽입할 인덱스의 위치와 0이 아닌 숫자를 찾는 2 pointer 방식 사용
	
# FindPivotIndex_724
	좌측의 합과 우측의 합이 같아지는 중앙 인덱스(Pivot) 찾기
	sliding
	0번 인덱스부터 이동하면서, 전체를 합한 결과(right)에서 제거한 값과 점점 더해지는 값(left)을 비교하면서 진행

# SortColors_75
	1. 범위가 제한적이라면 counting sort
	2. 종류 3개 제한 in-place : left, right, pivot 3 pointer 이용.
	단순히 이동하는게 아니라 생각보다 고려할게 있음.
	
# MergeSortedArray_88
	큰 배열에 비공간에 데이터를 넣고 앞부터 채워넣는다라고 생각할 수 있는데,
	오히려 뒷쪽 빈 공간에 데이터를 삽입하면서 진행하면 불필요한 작업이 없어진다.
	꼭 작은 것 부터 정렬할 필요 없다는 생각하기.
	
# FindPeakElement_162
	바이너리 서치 쉽게 하려면 종료 조건을 확실하게 처리하는게 좋은 것 같다.	
	범위를 넘어간 값이 필요한 경우, 조건 처리에서 인덱스 체크

# MergeIntervals_56
	그래프 그리기 : 정렬 후 합치기
	
# ShortestUnsortedContinuousSubarray_581
	정렬을 위한 최소 subArray 구간 구하기
	1. 전체 순회를 하며 최대값 갱신하면서 최대값 보다 작은 마지막 지점 구하기 (+ 정렬이 필요 없는지 체크도 가능)
	2. 반대로 순회하며 최소값을 갱신하면서 최소값 보다 큰 가장 앞 지점 구하기
	3.	Sorting Algoritm 실행
	***** 유용함
	전체 정렬이 필요한 경우에는 2N 낭비될 수도 있지만, 정렬된 상태는 Check N만 하고 끝날 수 있어서 좋음.
	구간이 짧을수록 N Log N의 N 수치도 줄어들어서 좋음.

# FindTheDuplicateNumber_287
	비둘기집 원리 : n + 1개의 항목을 n개의 Array에 넣을 때 적어도 어느 한 상자에는 두 개 이상의 물건이 들어갈 수 있다는 증명
	Array의 값을 인덱스로 보는 관점
	
# TwoSum_1, ThreeSumClosest_16, ThreeSum_15, FourSum_18
	two sum. hashmap을 이용하여 확인하는 방법 O(N)t, O(N)s
	정령과 2 포인터를 이용방법 O(NlogN + N)t => O(NlogN)t, O(1)s
	threeSum 부터는 좌측 부터 타겟으로 잡고, 우측에 2개에 대한 값을 구하기 때문에 O(N^2)이 기본으로 들어감.	

# RotateImage_48
	접는 방식과 분할 영역 회전 방식

# SearchA2DMatrix_74
	바이너리 서치 O(log M + log N)t => O( logMN )t
	좀 더 느리지만 SearchA2DMatrixII_240 코드로 작성은 빨리 가능 O( M + N )t
# SearchA2DMatrixII_240
	바이너리 서치 O( N log M )t
	정렬 특성을 이용한 이동 방식 O( M + N )t
	
	
	
	