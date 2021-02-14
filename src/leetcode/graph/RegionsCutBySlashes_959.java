package leetcode.graph;
//matrix fill dfs
public class RegionsCutBySlashes_959 {
	int dfs(int r, int c, eDir inDir) {
		if (r < 0 || r >= n || c < 0 || c >= n)
			return 0;
		else if ((inDir == eDir.L && m[r][c].R) || (inDir == eDir.R && m[r][c].L) || (inDir == eDir.T && m[r][c].B)
				|| (inDir == eDir.B && m[r][c].T))
			return 0;

		if (block[r][c] == eBlock.Slash) {
			if (inDir == eDir.R || inDir == eDir.B) {
				m[r][c].L = m[r][c].T = true;
				dfs(r, c - 1, eDir.L);
				dfs(r - 1, c, eDir.T);
			} else {
				m[r][c].R = m[r][c].B = true;
				dfs(r, c + 1, eDir.R);
				dfs(r + 1, c, eDir.B);
			}
		} else if (block[r][c] == eBlock.BackSlash) {
			if (inDir == eDir.R || inDir == eDir.T) {
				m[r][c].L = m[r][c].B = true;
				dfs(r, c - 1, eDir.L);
				dfs(r + 1, c, eDir.B);
			} else {
				m[r][c].R = m[r][c].T = true;
				dfs(r, c + 1, eDir.R);
				dfs(r - 1, c, eDir.T);
			}
		} else { // None
			m[r][c].L = m[r][c].R = m[r][c].T = m[r][c].B = true;
			dfs(r, c - 1, eDir.L);
			dfs(r - 1, c, eDir.T);
			dfs(r, c + 1, eDir.R);
			dfs(r + 1, c, eDir.B);
		}

		return 1;
	}

	public int regionsBySlashes(String[] grid) {
		initMember(grid);
		int regionCount = 0;
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				regionCount += dfs(r, c, eDir.L);
				regionCount += dfs(r, c, eDir.R);
				regionCount += dfs(r, c, eDir.T);
				regionCount += dfs(r, c, eDir.B);
			}
		}
		return regionCount;
	}

	private int n;
	private Matrix[][] m;
	private eBlock[][] block;

	void initMember(String[] grid) {
		n = grid.length;
		m = new Matrix[n][n];
		block = new eBlock[n][n];
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				m[r][c] = new Matrix();
				if (grid[r].charAt(c) == '/')
					block[r][c] = eBlock.Slash;
				else if (grid[r].charAt(c) == '\\')
					block[r][c] = eBlock.BackSlash;
				else
					block[r][c] = eBlock.None;
			}
		}
	}

	private enum eBlock {
		None, Slash, BackSlash,
	}

	private enum eDir {
		L, R, T, B;
	}

	private class Matrix {
		boolean L;
		boolean R;
		boolean T;
		boolean B;
	}
}