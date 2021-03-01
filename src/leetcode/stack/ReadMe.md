# stack
	MinimumRemoveToMakeValidParentheses_1249

# MinStack_155
	일반 스택 외에 두 번째 스택을 두고 pair <최소값, 해당 최소값의 index>를 관리
	
# AdjacentDuplicates
	RemoveAllAdjacentDuplicatesInString_1047
	RemoveAllAdjacentDuplicatesInStringII_1209
	array 또는 string에서 인접한 문자를 지우는 방법으로 복잡한 shift 처리를 없애기 위해 stack을 사용
	pair< 문자, count > 를 push 후 k와 확인
	=> 2 stack도 가능

# DecodeString_394
	괄호 처리가 필요할 때, Stack 사용. text의 Reversing에 따른 구현 확인
	=> 2 stack도 가능

# BasicCalculatorII_227
	구현 난이도가 있어서, 너무 정돈되게 작성하려면 복잡해짐
	숫자에 걸리면 한 번에 parsing하는게 더 쉬울듯.
	
# DailyTemperatures_739
	우측에서 데이터를 남겨서 재사용하는 케이스
	1. 배열의 인덱스를 누적 계산 저장 stack
	2. 단순하게 인덱스 저장 stack
	3. day 결과 정보를 이용