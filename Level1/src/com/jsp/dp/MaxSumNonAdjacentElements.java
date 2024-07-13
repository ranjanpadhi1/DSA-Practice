package com.jsp.dp;

public class MaxSumNonAdjacentElements {
	public static void main(String[] args) {
//		System.out.println(maxSumNonAdjacent2(new int[] { 5, 10, 20, 100, 6, 5 }, 0, 0, true));
		System.out.println(maxSumNonAdjacent(new int[] { 5, 10, 20, 100, 6, 5 }));
//		System.out.println(maxSumNonAdjacent2(new int[] { 5, 22, 15, -2, 18 }, 0, 0, true));
		System.out.println(maxSumNonAdjacent(new int[] { 5, 22, 15, -2, 18 }));
	}

	private static int maxSumNonAdjacent(int[] arr) {
		int inc = 0, exc = 0;

		for (int i = 0; i < arr.length; i++) {
			int ninc = exc + arr[i];
			int nexc = Math.max(inc, exc);

			inc = ninc;
			exc = nexc;
		}

		return Math.max(inc, exc);
	}

	// !!!!
	private static int maxSumNonAdjacent2(int[] arr, int i, int sum, boolean inc) {
		if (i == arr.length - 1)
			return sum;

		if (inc)
			return maxSumNonAdjacent2(arr, i + 1, sum, !inc);
		else {
			return Math.max(maxSumNonAdjacent2(arr, i + 1, sum, !inc),
					maxSumNonAdjacent2(arr, i + 1, sum + arr[i], !inc));
		}
	}
}
