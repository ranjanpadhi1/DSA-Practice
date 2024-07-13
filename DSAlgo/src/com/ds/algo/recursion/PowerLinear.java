package com.ds.algo.recursion;

public class PowerLinear {
	public static void main(String[] args) {
		System.out.println(power(2, 4));
	}

	private static int power(int x, int n) {
		if (n == 0)
			return 1;

		return x * power(x, n - 1);
	}
}
