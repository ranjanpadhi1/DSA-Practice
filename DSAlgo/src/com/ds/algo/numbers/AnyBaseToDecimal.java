package com.ds.algo.numbers;

public class AnyBaseToDecimal {
	public static void main(String[] args) {
		System.out.println(baseToDecimal(1100, 2));
	}

	private static int baseToDecimal(int num, int base) {
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
