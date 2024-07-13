package com.jsp.dp;

public class PossibleWaysToConstructBuilding {
	public static void main(String[] args) {
		System.out.println(waysToArrangeBuilding(5));
		System.out.println(waysToArrangeBuilding2(5));
	}

	private static int waysToArrangeBuilding(int n) {
		int dp[][] = new int[2][n + 1];
		dp[0][1] = dp[1][1] = 1;

		for (int i = 2; i < dp[0].length; i++) {
			dp[0][i] = dp[1][i - 1];
			dp[1][i] = dp[0][i - 1] + dp[1][i - 1];
		}

		int totalways = dp[0][n] + dp[1][n];
		return totalways * totalways;
	}

	private static int waysToArrangeBuilding2(int n) {
		int buildingCombCount = 1, spaceCombCount = 1;

		for (int i = 2; i <= n; i++) {
			int newBuildingCombCount = spaceCombCount;
			int newSpaceCombCount = buildingCombCount + spaceCombCount;

			buildingCombCount = newBuildingCombCount;
			spaceCombCount = newSpaceCombCount;

		}
		int totalCombs = buildingCombCount + spaceCombCount;
		return totalCombs * totalCombs;
	}
}
