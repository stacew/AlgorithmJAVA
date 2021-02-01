// 그냥 구현 난이도가 어려움..
public class SudokuSolver_37 {
	private class XY {
		public XY() {
			x = -1;
			y = -1;
		}

		public int x;
		public int y;
	}

	private boolean CheckSquare(int r, int c, int n) {
		r = r / 3;
		c = c / 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (m_board[r * 3 + i][c * 3 + j] == '0' + n)
					return false;
			}
		}
		return true;
	}

	private boolean CheckRow(int r, int n) {
		for (int i = 0; i < 9; i++) {
			if (m_board[r][i] == '0' + n)
				return false;
		}
		return true;
	}

	private boolean CheckCol(int c, int n) {
		for (int i = 0; i < 9; i++) {
			if (m_board[i][c] == '0' + n)
				return false;
		}
		return true;
	}

	private XY getnextXY(int r, int c) {
		XY retXY = new XY();
		for (int i = r; i < 9; i++) {
			for (int j = c; j < 9; j++) {
				c = 0;//
				if (m_board[i][j] == '.') {
					retXY.x = i;
					retXY.y = j;
					return retXY;
				}
			}
		}
		return retXY;
	}

	private boolean BT(int r, int c, int n) {
		if (CheckRow(r, n) == false)
			return false;
		if (CheckCol(c, n) == false)
			return false;
		if (CheckSquare(r, c, n) == false)
			return false;

		m_board[r][c] = (char) ('0' + n);
		XY xy = getnextXY(r, c);
		if (xy.x == -1)
			return true;

		for (int nn = 1; nn <= 9; nn++)
			if (BT(xy.x, xy.y, nn))
				return true;

		m_board[r][c] = '.';
		return false;
	}

	public void solveSudoku(char[][] board) {
		m_board = board;
		XY xy = getnextXY(0, 0);
		for (int n = 1; n <= 9; n++)
			BT(xy.x, xy.y, n);
	}

	char[][] m_board;
}

////내부에 for 잘못 넣으면 구현이 어려워짐..
//class Solution {
//	private void CheckSquare(boolean Number[], int r, int c) {
//		r = r / 3;
//		c = c / 3;
//		for (int i = 0; i < 3; i++) {
//			for (int j = 0; j < 3; j++) {
//				if (m_board[r * 3 + i][c * 3 + j] != '.')
//					Number[m_board[r * 3 + i][c * 3 + j] - '0'] = true;
//			}
//		}
//	}
//
//	private void CheckRow(boolean Number[], int r) {
//		for (int i = 0; i < 9; i++) {
//			if (m_board[r][i] != '.')
//				Number[m_board[r][i] - '0'] = true;
//		}
//	}
//
//	private void CheckCol(boolean Number[], int c) {
//		for (int i = 0; i < 9; i++) {
//			if (m_board[i][c] != '.')
//				Number[m_board[i][c] - '0'] = true;
//		}
//	}
//
//	private boolean checkTryNumber(boolean Number[]) {
//		for (int i = 1; i <= 9; i++)
//			if (Number[i] == false)
//				return true;
//		return false;
//	}
//
//	private boolean BT(int r, int c) {
//		for (int i = r; i < 9; i++) {
//			for (int j = c; j < 9; j++) {
//				c = 0;
//				if (m_board[i][j] != '.') {
//					continue;
//				}
//
//				boolean[] Number = new boolean[10];
//				CheckSquare(Number, i, j);
//				CheckRow(Number, i);
//				CheckCol(Number, j);
//				if (checkTryNumber(Number) == false) {
//					return false;
//				}
//
//				boolean bTrue = true;
//				for (int k = 1; k <= 9; k++) {
//					if (Number[k])
//						continue;
//
//					m_board[i][j] = (char) ('0' + k);
//					if (BT(i, j) == true) {
//						bTrue = true;
//						break;
//					} else {
//						m_board[i][j] = '.';
//						bTrue = false;
//					}
//				}
//				if (bTrue == false) {
//					return false;
//				}
//
//			}
//		}
//
//		return true;
//	}
//
//	public void solveSudoku(char[][] board) {
//		m_board = board;
//		BT(0, 0);
//	}
//
//	char[][] m_board;
//}
