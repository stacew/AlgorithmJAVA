package leetcode.graph;

public class FindTheTownJudge_997 {
	public int findJudge(int N, int[][] trust) {
		int trusted[] = new int[N + 1];
		boolean noJudge[] = new boolean[N + 1];

		for (int i = 0; i < trust.length; i++) {
			noJudge[trust[i][0]] = true;
			trusted[trust[i][1]]++;
		}

		for (int peopleId = 1; peopleId < N + 1; peopleId++) {
			if (trusted[peopleId] == N - 1 && noJudge[peopleId] == false)
				return peopleId;
		}
		return -1;
	}
}
