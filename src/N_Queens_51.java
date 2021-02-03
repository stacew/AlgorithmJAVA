import java.util.ArrayList;
import java.util.List;
//현재 풀이에서 추가 개선안
//1. 가로에서 한 개만 처리 가능하기 때문에 다음 행으로 넘기면 된다.
//2. 세로의 경우도 다 확인할 필요 없이 HashSet으로 존재하는지 확인 가능
//3. 대각선의 경우 Key(y-x) HashSet을 이용하면 존재하는지 확인 가능 
public class N_Queens_51 {
	private class XY {
		public XY(int _x, int _y) {
			x = _x;
			y = _y;
		}

		public int x;
		public int y;
	}

	private boolean checkDiagonal(int r, int c) {
		int t_r = r;
		int t_c = c;
		while (--t_r >= 0 && --t_c >= 0)
			if (board[t_r][t_c] == 'Q')
				return true;
		t_r = r;
		t_c = c;
		while (--t_r >= 0 && ++t_c < size)
			if (board[t_r][t_c] == 'Q')
				return true;
		t_r = r;
		t_c = c;
		while (++t_r < size && --t_c >= 0)
			if (board[t_r][t_c] == 'Q')
				return true;
		t_r = r;
		t_c = c;
		while (++t_r < size && ++t_c < size)
			if (board[t_r][t_c] == 'Q')
				return true;
		return false;
	}

	private boolean checkVertical(int r, int c) {
		for (int i = 0; i < size; i++)
			if (board[i][c] == 'Q' && i != r)
				return true;
		return false;
	}

	private boolean checkHorizontal(int r, int c) {
		for (int i = 0; i < size; i++)
			if (board[r][i] == 'Q' && i != c)
				return true;
		return false;
	}

	private XY findNext(int x, int y) {
		int c = y;
		for (int r = x; r < size; r++) {
			while (c < size) {
				if (board[r][c] == '.')
					return new XY(r, c);

				c++;
			}
			c = 0;
		}
		return null;
	}

	private void BT(int r, int c, int count) {
		if (checkDiagonal(r, c) || checkVertical(r, c) || checkHorizontal(r, c))
			return;

		if (count == size) {
			ArrayList<String> list = new ArrayList<String>();
			for( int i = 0; i < size; i ++)
				list.add( new String(board[i]));
			mRet.add(list);
			return;
		}
		XY xy = null;
		while ((xy = findNext(r, c)) != null) {
			r = xy.x;
			c = xy.y;
			board[r][c] = 'Q';
			BT(r, c, count + 1);
			board[r][c] = '.';
			c++;
		}
	}

	public List<List<String>> solveNQueens(int n) {
		mRet = new ArrayList<>();
		size = n;
		board = new char[size][size];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				board[i][j] = '.';
		
		BT(0, 0, 0);

		return mRet;
	}

	char[][] board;
	private List<List<String>> mRet;
	private int size;
}
