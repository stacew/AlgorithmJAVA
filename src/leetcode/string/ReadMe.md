# find string = O(n)
	1. Rabin-karp : rolling hash
	2. KMP : substring의 index table(반복되는 인덱스 정보를 저장)을 추가
	3. Boyer-Moore

##### Implement_strStr_28
	sub가 ""일때 예외 처리 추가 필요
	같은 길이의 JAVA의 compareTo()도 요구하는 답과 다름

##### RotateString_796
	쉬프트 된 문자열인지 확인 방법


# Palindrome (회문)
	palindrome : 뒤에서 읽어도 앞에서 읽은 것과 같은 문자열
	2 pointer 이용
##### ValidPalindrome_125
##### ValidPalindromeII_680


# AddStrings_415
	긴 숫자를 문자열로 변경하여 합치기

# LongestSubstringWithoutRepeatingCharacters_3
	반복 없이 가장 긴 substring 구하기
	이전에 저장했던 문자맵의 인덱스가 갱신된 start 이후 값인지 확인
	제한된 문자라면 hashmap보다 배열을 사용하는게 좋음

# Anagrams 같은 문자 개수를 갖는 문자열들
	anagram : 문자열 단위로 정렬하면 확인 가능
	key를 문자-개수 배열을 사용하면 정렬을 제외시킬 수 있음.( 배열 비교 compair 구현 필요 )

##### GroupAnagrams_49
	hashmap 이터레이터 삽입 방법
	1. hm.keyset()
	이터레이터 가져와서 while(hasnext())
	for range
	2. entry key, value를 가져와서 for range
	3. addAll(hm.values())