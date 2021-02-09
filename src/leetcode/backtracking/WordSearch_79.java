package leetcode.backtracking;

public class WordSearch_79 {

	public boolean BT(int a_index, int r, int c, boolean[][] a_board) {
		if (a_index == m_word.length())
			return true;

		if (r - 1 > 0 && a_board[r-1][c] == false && m_board[r - 1][c] == m_word.charAt(a_index)) {
			a_board[r - 1][c] = true;
			if (BT(a_index + 1, r - 1, c, a_board))
				return true;
			a_board[r - 1][c] = false;
		}

		if (r + 1 < a_board.length && a_board[r+1][c] == false && m_board[r + 1][c] == m_word.charAt(a_index)) {
			a_board[r + 1][c] = true;
			if (BT(a_index + 1, r + 1, c, a_board))
				return true;
			a_board[r + 1][c] = false;
		}

		if (c - 1 > 0 && a_board[r][c-1] == false && m_board[r][c - 1] == m_word.charAt(a_index)) {
			a_board[r][c - 1] = true;
			if (BT(a_index + 1, r, c - 1, a_board))
				return true;
			a_board[r][c - 1] = false;
		}

		if (c + 1 < a_board[0].length && a_board[r][c+1] == false && m_board[r][c + 1] == m_word.charAt(a_index)) {
			a_board[r][c + 1] = true;
			if (BT(a_index + 1, r, c + 1, a_board))
				return true;
			a_board[r][c + 1] = false;
		}

		return false;
	}

	public boolean exist(char[][] board, String word) {
		m_word = word;
		m_board = board;
		boolean[][] a_board = new boolean[board.length][board[0].length];
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {
				if (m_board[r][c] != word.charAt(0))
					continue;
				
				a_board[r][c] = true;
				if (BT(1, r, c, a_board))
					return true;
				a_board[r][c] = false;
			}
		}
		return false;
	}

	private char[][] m_board;
	private String m_word;
}
