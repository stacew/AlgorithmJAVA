package leetcode.array;

public class SearchA2DMatrixII_240 {
	public boolean searchMatrix(int[][] m, int target) {
		int rows = m.length;
		int cols = m[0].length;

		int r = rows - 1;
		int c = 0;
		while (r >= 0 && c < cols) {
			if (m[r][c] == target)
				return true;

			if (m[r][c] > target)
				r -= 1;
			else
				c += 1;
		}

		return false;
	}
}
