package com.jsp.basics;

public class IsPrimeNumber {
	public static void main(String[] args) {
		System.out.println(isPrime(23));
		System.out.println(isPrime(24));
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
