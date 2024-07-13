package com.jsp.dp;

import java.util.Arrays;

public class CatalanNumber {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(findCatalanNumbers(10)));
	}

	private static int[] findCatalanNumbers(int n) {
		int[] cat = new int[n + 1];
		cat[0] = 1;
		cat[1] = 1;

		for (int i = 2; i <= n; i++) {
			int left = 0, right = i - 1;

			while (left < i) {
				cat[i] += cat[left++] * cat[right--];
			}
		}

		return cat;
	}
}
