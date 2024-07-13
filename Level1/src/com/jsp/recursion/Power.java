package com.jsp.recursion;

public class Power {
	public static void main(String[] args) {
		System.out.println(power(2, 6));
		System.out.println(power2(2, 6));
	}

	// O(n)
	private static int power(int n, int p) {
		if (p == 0)
			return 1;
		return n * power(n, p - 1);
	}

	private static int power2(int n, int p) {
		if (p == 0)
			return 1;
		int power = power(n, p / 2);
		int result = power * power;
		if (p % 2 != 0) {
			result *= n;
		}
		return result;
	}
}
