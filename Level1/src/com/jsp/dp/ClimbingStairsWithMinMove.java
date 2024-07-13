package com.jsp.dp;

public class ClimbingStairsWithMinMove {
	public static void main(String[] args) {
		System.out.println(minJumpClimbStair(0, 5, 0, new int[] { 4, 2, 0, 1, 2 }, new int[6]));
		System.out.println(minJumpClimbStair(0, 10, 0, new int[] { 3, 2, 4, 2, 0, 2, 3, 1, 2, 2 }, new int[11]));

		System.out.println(minJumpClimbStair2(0, 5, new int[] { 4, 2, 0, 1, 2 }));
		System.out.println(minJumpClimbStair2(0, 10, new int[] { 3, 2, 4, 2, 0, 2, 3, 1, 2, 2 }));

		System.out.println(minJumpClimbStairTab(0, 5, new int[] { 4, 2, 0, 1, 2 }));
		System.out.println(minJumpClimbStairTab(0, 10, new int[] { 3, 2, 4, 2, 0, 2, 3, 1, 2, 2 }));
	}

	private static int minJumpClimbStairTab(int src, int dest, int[] jumps) {
		Integer[] dp = new Integer[dest + 1];
		dp[dest] = 0;

		for (int step = dest - 1; step >= 0; step--) {
			int min = Integer.MAX_VALUE;
			for (int jump = 1; jump <= jumps[step] && step + jump <= dest; jump++) {
				if (dp[step + jump] != null)
					min = Math.min(min, dp[step + jump]);
			}
			if (min != Integer.MAX_VALUE)
				dp[step] = min + 1;
		}

		return dp[0];
	}

	private static int minJumpClimbStair(int src, int dest, int move, int[] jumps, int[] dp) {
		if (src == dest)
			return move;
		else if (src > dest)
			return Integer.MAX_VALUE;

		if (dp[src] > 0)
			return dp[src];

		int minMove = Integer.MAX_VALUE;
		for (int jump = 1; jump <= jumps[src]; jump++) {
			minMove = Math.min(minMove, minJumpClimbStair(src + jump, dest, move + 1, jumps, dp));
		}

		if (minMove != Integer.MAX_VALUE) {
			dp[src] = minMove;
		}

		return minMove;
	}

	static int minMove;

	private static int minJumpClimbStair2(int src, int dest, int[] jumps) {
		minMove = Integer.MAX_VALUE;
		findMinMove(src, dest, 0, jumps);
		return minMove;
	}

	private static void findMinMove(int src, int dest, int move, int[] jumps) {
		if (src == dest) {
			minMove = Math.min(minMove, move);
			return;
		} else if (src > dest)
			return;

		for (int jump = 1; jump <= jumps[src]; jump++) {
			findMinMove(src + jump, dest, move + 1, jumps);
		}

	}
}
