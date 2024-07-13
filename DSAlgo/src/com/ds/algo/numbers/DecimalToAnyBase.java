package com.ds.algo.numbers;

public class DecimalToAnyBase {
	public static void main(String[] args) {
		System.out.println(decimalToBse(12, 2));
	}

	private static int decimalToBse(int num, int base) {
		int result = 0, power = 1;

		while (num > 0) {
			int remainder = num % base;
			result += remainder * power;
			num = num / base;
			power = power * 10;
		}
		return result;
	}
}
