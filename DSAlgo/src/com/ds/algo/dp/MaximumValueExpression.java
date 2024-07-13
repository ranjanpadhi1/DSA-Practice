package com.ds.algo.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumValueExpression {
	public static void main(String[] args) {
		System.out.println(maxValExpression("1+2*3+4*5"));
	}

	private static int maxValExpression(String exp) {
		List<Integer> opnds = new ArrayList<>();
		List<Character> opr = new ArrayList<>();

		for (char ch : exp.toCharArray()) {
			if (Character.isDigit(ch))
				opnds.add(ch - '0');
			else
				opr.add(ch);
		}
		int n = opnds.size();
		int[][] dp = new int[n][n];

		for (int gap = 0; gap < n; gap++) {
			for (int r = 0, c = gap; r < n && c < n; r++, c++) {
				if (gap == 0)
					dp[r][c] = opnds.get(r);
				else if (gap == 1)
					dp[r][c] = eval(opnds.get(r), opnds.get(c), opr.get(r));
				else {
					int max = 0;
					for (int k = 0; k < gap; k++) {
						int left = dp[r][r + k];
						int right = dp[r + k + 1][c];
						max = Math.max(max, eval(left, right, opr.get(r + k)));
					}
					dp[r][c] = max;
				}
			}
		}
		print(dp);
		return dp[0][n - 1];
	}

	private static void print(int[][] dp) {
		for (int[] row : dp) {
			System.out.println(Arrays.toString(row));
		}
	}

	private static int eval(int i, int j, char c) {
		if (c == '+')
			return i + j;
		else
			return i * j;
	}
}
