package com.ds.algo.arrays;

import java.util.List;

public class BalanceArray {
	public static void main(String[] args) {
		System.out.println(solve(List.of(2, 1, 6, 4)));
		System.out.println(solve(List.of(5, 5, 2, 5, 8)));
	}

	private static int solve(List<Integer> A) {
		int evenSum = 0, oddSum = 0;
		for (int i = 0; i < A.size(); i++) {
			if (i % 2 == 0)
				evenSum += A.get(i);
			else
				oddSum += A.get(i);
		}

		int leftEven = 0, leftOdd = 0, count = 0;
		for (int i = 0; i < A.size(); i++) {
			int rightEven = 0, rightOdd = 0, tempLeftEven = leftEven, tempLeftOdd = leftOdd;

			if (i % 2 == 0) {
				rightEven = evenSum - leftEven - A.get(i);
				rightOdd = oddSum - leftOdd;
				leftEven += A.get(i);
			} else {
				rightEven = evenSum - leftEven;
				rightOdd = oddSum - leftOdd - A.get(i);
				leftOdd += A.get(i);
			}

			if (tempLeftEven + rightOdd == tempLeftOdd + rightEven)
				count++;

		}

		return count;
	}
}
