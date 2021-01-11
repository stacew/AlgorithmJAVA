class ClimbingStairs_70 {
	int[] arr;

	private int recursiveMemo(int n) {
		if (n == 1)
			return 1;
		else if (n == 2)
			return 2;
		else if (arr[n] != 0)
			return arr[n];

		arr[n - 1] = recursiveMemo(n - 1);
		arr[n - 2] = recursiveMemo(n - 2);

		return arr[n - 1] + arr[n - 2];
	}

	private int climbStairs_memo(int n) {
		arr = new int[n + 1];
		return recursiveMemo(n);
	}

	public int climbStairs(int n) {
		return climbStairs_BU(n);
		
		//return climbStairs_memo(n);
	}

	public int climbStairs_BU(int n) {
		arr = new int[3];
		arr[1] = 1;
		arr[2] = 2;
		for (int i = 3; i <= n; i++)
			arr[i % 3] = arr[(i - 1) % 3] + arr[(i - 2) % 3];

		return arr[n % 3];
	}
}
