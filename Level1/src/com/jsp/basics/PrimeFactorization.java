package com.jsp.basics;

public class PrimeFactorization {
	public static void main(String[] args) {
		printPrimeFact(1440);
	}

	private static void printPrimeFact(int num) {
		int div = 2;

		while (num > 1) {
			if (num % div == 0) {
				System.out.println(div);
				num = num / div;
			} else
				div++;
		}

	}
}
