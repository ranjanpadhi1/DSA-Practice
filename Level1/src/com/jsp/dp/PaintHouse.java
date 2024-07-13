package com.jsp.dp;

public class PaintHouse {
	public static void main(String[] args) {
		int[][] paintCost = { { 1, 5, 7 }, { 5, 8, 4 }, { 3, 2, 9 }, { 1, 2, 4 } };
		System.out.println(minCostPaint(paintCost));
	}

	private static int minCostPaint(int[][] paintCost) {
		int redCost = Integer.MAX_VALUE, greenCost = Integer.MAX_VALUE, blueCost = Integer.MAX_VALUE;

		for (int i = 0; i < paintCost.length; i++) {
			int minGB = Math.min(greenCost, blueCost);
			int newRedCost = (minGB == Integer.MAX_VALUE ? 0 : minGB) + paintCost[i][0];

			int minRB = Math.min(redCost, blueCost);
			int newGreenCost = (minRB == Integer.MAX_VALUE ? 0 : minRB) + paintCost[i][1];

			int minRG = Math.min(redCost, greenCost);
			int newBlueCost = (minRG == Integer.MAX_VALUE ? 0 : minRG) + paintCost[i][2];

			redCost = newRedCost;
			greenCost = newGreenCost;
			blueCost = newBlueCost;
		}
		return Math.min(redCost, Math.min(greenCost, blueCost));
	}
}
