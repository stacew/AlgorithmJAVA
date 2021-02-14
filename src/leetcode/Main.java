package leetcode;

import leetcode.array.ThreeSumClosest_16;
import leetcode.backtracking.SudokuSolver_37;
import leetcode.graph.SortIntegersByThePowerValue_1387;

public class Main {
	public static void main(String[] args) {
		System.out.println("--- start ---");

		SudokuSolver_37 sol37 = new SudokuSolver_37();
		char board[][] = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		sol37.solveSudoku(board);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(board[i][j] + "\t");
			}
			System.out.println();
		}

		SortIntegersByThePowerValue_1387 sol1387 = new SortIntegersByThePowerValue_1387();
		sol1387.getKth(12, 15, 2);
		
		// N_Queens_51 sol51 = new N_Queens_51();
		// sol51.solveNQueens(4);
		
		ThreeSumClosest_16 sol16 = new ThreeSumClosest_16();
		sol16.threeSumClosest(new int[] {-1,2,1,-4}, 1);
		System.out.println("--- end ---");
	}
};
