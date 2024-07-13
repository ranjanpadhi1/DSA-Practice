package com.jsp.dp;

public class ClimbingStairWithMinCost {
	public static void main(String[] args) {
		System.out.println(minCostClimbStair(new int[] { 10, 15, 20 }));
		System.out.println(minCostClimbStair(new int[] { 1, 100, 2, 3, 50 }));
		System.out.println(minCostClimbStair(new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 }));

		System.out.println(minCostClimbStairTab(0, 5, new int[] { 1, 100, 2, 3, 50 }));
		System.out.println(minCostClimbStairTab(0, 10, new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 }));
	}

	// From each step 1 or 2 jumps allowed
	private static int minCostClimbStairTab(int src, int dest, int[] cost) {
		Integer[] dp = new Integer[dest + 1];
		dp[dest] = 0;

		for (int step = dest - 1; step >= 0; step--) {
		}

		return dp[0];
	}

	private static int minCostClimbStair(int[] cost) {
		return minCostClimbStair(0, cost.length, 0, cost);
	}

	private static int minCostClimbStair(int src, int dest, int pathCost, int[] cost) {
		if (src == dest)
			return pathCost;
		else if (src > dest)
			return Integer.MAX_VALUE;

		int minCost = Math.min(minCostClimbStair(src + 1, dest, pathCost + cost[src], cost),
				minCostClimbStair(src + 2, dest, pathCost + cost[src], cost));

		return minCost;
	}

}
