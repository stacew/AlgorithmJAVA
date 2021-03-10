package leetcode;

import leetcode.array.SearchA2DMatrix_74;
import leetcode.array.ThreeSumClosest_16;
import leetcode.backtracking.SudokuSolver_37;
import leetcode.dp.DecodeWays_91;
import leetcode.graph.SortIntegersByThePowerValue_1387;
import leetcode.string.GroupAnagrams_49;
import leetcode.string.RabinKarp;
import leetcode.string.ValidPalindromeII_680;
import leetcode.tree.TreeBFS;
import leetcode.tree.TreeDFS;

public class Main {
	public static void main(String[] args) {
		System.out.println("--- start ---");

		DecodeWays_91 sol91 = new DecodeWays_91();
		System.out.println(sol91.numDecodings("12024"));
		
//		SearchA2DMatrix_74 sol74 = new SearchA2DMatrix_74();
//		sol74.searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 3);
		
//		TreeBreadthFirstSearch TBFS = new TreeBreadthFirstSearch();
//		TreeDepthFirstSearch TDFS = new TreeDepthFirstSearch();
//		System.out.println(RabinKarp.RabinKarp("mississippi", "pi"));
//
//		GroupAnagrams_49 sol49 = new GroupAnagrams_49();
//		String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
//		sol49.groupAnagrams(strs);
//		
//		ValidPalindromeII_680 sol680 = new ValidPalindromeII_680();
//		System.out.println(sol680.validPalindrome("abc"));

//		
//		SudokuSolver_37 sol37 = new SudokuSolver_37();
//		char board[][] = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
//				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
//				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
//				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
//				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
//		sol37.solveSudoku(board);
//		for (int i = 0; i < 9; i++) {
//			for (int j = 0; j < 9; j++) {
//				System.out.print(board[i][j] + "\t");
//			}
//			System.out.println();
//		}
//
//		SortIntegersByThePowerValue_1387 sol1387 = new SortIntegersByThePowerValue_1387();
//		sol1387.getKth(12, 15, 2);
//		
//		// N_Queens_51 sol51 = new N_Queens_51();
//		// sol51.solveNQueens(4);
//		
//		ThreeSumClosest_16 sol16 = new ThreeSumClosest_16();
//		sol16.threeSumClosest(new int[] {-1,2,1,-4}, 1);
		System.out.println("--- end ---");
	}
};
