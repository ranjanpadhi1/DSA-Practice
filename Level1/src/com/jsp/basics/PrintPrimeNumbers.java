package com.jsp.basics;

public class PrintPrimeNumbers {
	public static void main(String[] args) {
		printPrimes(6);
		printPrimes(24);
	}

	private static void printPrimes(int n) {
		for (int num = 1; num <= n; num++) {
			if (isPrime(num))
				System.out.print(num + " ");
		}
		System.out.println();
	}

	private static boolean isPrime(int num) {
		boolean isPrime = true;
		for (int div = 2; div * div <= num; div++) {
			if (num % div == 0) {
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}
}
