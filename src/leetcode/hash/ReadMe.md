# FirstUniqueCharacterInAString_387
	getOrDefault
	
# IsomorphicStrings_205
	양방향 비교가 필요
	1. 맵의 사이즈로 인덱스를 정한 것
	2. 둘 다 char를 value로 저장
	
# ValidAnagram_242
	첫 번째 문자열을 다 넣고, 두 번째 문자열을 검사하면서 return하는게 더 빠름
	시간 O(n), 공간 O(1) : 해시맵이 증가가 알파벳의 개수로 제한되어 있기 때문에
	문자열 내부 정렬 후 loop 진행하며 찾는 방법은
	시간 O(nlogn), 공간 O(1) : 추가 공간이 필요 없음
	
	
# WordPattern_290
	중복 사용 패턴이 존재할 수 있어서, 새로 나오는 패턴에 대해 사이즈로 인덱스 정해주는게 좋음

# TopKFrequentWords_692
	Comparator compair Override

# TopKFrequentElements_347	
	Comparator.comparing
	
# RandomizedSet_380
	getrandom을 O(1)의 uniform distribution의 확률 처리를 위해 key array 정보를 hashmap의 value(array pos)로 관리한다.
	key를 삭제할 때, array의 중간 부분이 삭제되는 경우, 맨 뒤에서 중간값으로 이동시켜주고, hashmap의 key value도 갱신
	
	
# SubarraySumEqualsK_560
	subArray의	 positive 조건이 있다면 sliding window를 사용 O(n)으로 처리 가능
	음수가 있다면 누적합 정보를 만들어 HashMap으로 target K와 관련된 subarray 정보를 구할 수 있음
# SubArraySumsDivisibleByK_974
	음수의 나머지 값이 key를 분리 시키기 때문에, 음수는 나머지 기준값을 더해 양수로 변경시켜 관리

# ContiguousArray_525
	0과 1 또는 a와 b 같은 2가지 값만 같는 경우, 양수, 음수로 처리하면 cumulative sum 성질을 적용할 수 있음

# MinimumAreaRectangle_939
	직사각형 => 대각 좌표를 확인. 도형적 직관