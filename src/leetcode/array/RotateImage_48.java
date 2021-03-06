package leetcode.array;

public class RotateImage_48 {

	//회전 방식
	private void rotate90(int[][] arr, int r, int c) {
		int lastIndex = arr.length - 1;

		int temp = arr[r][c]; // t= a;
		arr[r][c] = arr[lastIndex - c][r]; // a = d;
		arr[lastIndex - c][r] = arr[lastIndex - r][lastIndex - c]; // d = c;
		arr[lastIndex - r][lastIndex - c] = arr[c][lastIndex - r];// c = b;
		arr[c][lastIndex - r] = temp; // b = t;
	}

	public void rotate(int[][] matrix) {
		int n = matrix.length;
		for (int r = 0; r < n / 2; r++)
			for (int c = 0; c < (n + 1) / 2; c++)
				rotate90(matrix, r, c);
	}

	// 접는 방식
	private void swap_(int[][] arr, int r1, int c1, int r2, int c2) {
		int temp = arr[r1][c1];
		arr[r1][c1] = arr[r2][c2];
		arr[r2][c2] = temp;
	}

	public void rotate_(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < i; j++) {
				if (i == j)
					continue;
				swap_(matrix, i, j, j, i);
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length / 2; j++) {
				swap_(matrix, i, j, i, matrix.length - j - 1);
			}
		}
	}

}
