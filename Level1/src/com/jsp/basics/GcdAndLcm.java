package com.jsp.basics;

public class GcdAndLcm {
	public static void main(String[] args) {
		System.out.println(gcd1(24, 36));
		System.out.println(gcd1(27, 45));
		System.out.println(gcd2(24, 36));
		System.out.println(gcd2(27, 45));

		System.out.println(lcm(24, 36));
		System.out.println(lcm(27, 45));
	}

	// Brute force, divide both number starting from min to 1 - O(n)
	private static int gcd1(int n1, int n2) {
		for (int i = Math.min(n1, n2); i > 0; i--) {
			if (n1 % i == 0 && n2 % i == 0)
				return i;
		}
		return 1;
	}

	// Divide two numbers and divide number with rem until 0
	private static int gcd2(int n1, int n2) {
		while (n2 % n1 != 0) {
			int rem = n2 % n1;
			n2 = n1;
			n1 = rem;
		}
		return n1;
	}

	private static int lcm(int n1, int n2) {
		return (n1 * n2) / gcd2(n1, n2);
	}

}
