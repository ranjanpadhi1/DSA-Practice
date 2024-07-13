package com.ds.algo.numbers;

public class DecimalToBinary {
	public static void main(String[] args) {
		System.out.println(decimalToBinary(5));
		System.out.println(decimalToBinary(5, 3));
	}

	private static int decimalToBinary(int num) {
		int binary = 0, pow = 1;

		while (num > 0) {
			int digit = num % 2;
			binary += digit * pow;
			num = num / 2;
			pow = pow * 10;
		}
		return binary;
	}

	private static int decimalToBinary(int num, int length) {
		int binary = 0;

		for (int i = 0; i < length; i++) {
			int digit = num % 2;
			binary += digit * Math.pow(10, i);
			num = num / 2;
		}

		return binary;
	}
}
