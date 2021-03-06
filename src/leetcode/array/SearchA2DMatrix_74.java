package leetcode.array;

public class SearchA2DMatrix_74 {

	// O(log M + log N) => O( logMN )
	public boolean searchMatrix(int[][] m, int target) {
		int rowLastIndex = m.length - 1;
		int colLastIndex = m[0].length - 1;

		int row = 0;

		int l = 0;
		int r = rowLastIndex;
		while (l <= r) {
			int mid = (l + r) / 2;

			row = mid; // 찾는 row 값

			if (target < m[mid][0])
				r = mid - 1;
			else if (m[mid][colLastIndex] < target)
				l = mid + 1;
			else
				break;
		}
		
		if (m[row][0] == target)
			return true;

		l = 0;
		r = colLastIndex;
		while (l <= r) {
			int mid = (l + r) / 2;

			int midVal = m[row][mid];
			if (midVal == target)
				return true;

			if (target < midVal)
				r = mid - 1;
			else
				l = mid + 1;
		}

		return false;
	}
}
