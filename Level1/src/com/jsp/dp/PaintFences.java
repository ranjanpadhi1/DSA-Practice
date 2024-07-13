package com.jsp.dp;

public class PaintFences {
	public static void main(String[] args) {
		System.out.println(paintFenceWays(20, 3));
		System.out.println(paintFenceWaysR(20, 3, 0, -1));
	}

	private static int paintFenceWays(int fences, int colors) {
		if (fences == 1)
			return colors;

		int ii = colors, ij = colors * (colors - 1), total = ii + ij;

		for (int i = 3; i <= fences; i++) {
			ii = ij;
			ij = total * (colors - 1);
			total = ii + ij;
		}

		return total;
	}

	private static int paintFenceWaysR(int n, int k, int c, int p) {
		if (n == 0)
			return 1;

		int ways = 0;

		for (int j = 1; j <= k; j++) {
			if (!(c == p && c == j))
				ways += paintFenceWaysR(n - 1, k, j, c);
		}

		return ways;
	}
}
