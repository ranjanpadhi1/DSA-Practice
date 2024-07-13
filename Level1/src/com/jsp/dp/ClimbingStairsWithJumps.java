package com.jsp.dp;

public class ClimbingStairsWithJumps {
	public static void main(String[] args) {
		System.out.println(stairPaths(0, 6, new int[] { 2, 4, 0, 2, 2, 3 }));
		System.out.println(stairPathsMem(0, 6, new int[] { 2, 4, 0, 2, 2, 3 }));
	}

	private static int stairPaths(int src, int dest, int[] jumps) {
		if (src == dest)
			return 1;
		else if (src > dest)
			return 0;

		int paths = 0;
		for (int jump = 1; jump <= jumps[src]; jump++) {
			paths += stairPaths(src + jump, dest, jumps);
		}

		return paths;
	}

	private static int stairPathsMem(int src, int dest, int[] jumps) {
		int[] dp = new int[dest + 1];
		dp[dest] = 1;

		for (int i = dest - 1; i >= 0; i--) {
			for (int j = 1; j <= jumps[i] && i + j < dp.length; j++) {
				dp[i] += dp[i + j];
			}
		}

		return dp[src];
	}

}
