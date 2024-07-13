package com.ds.algo.numbers;

public class FindFrequenyOfDigit {
	public static void main(String[] args) {
		System.out.println(findFrequency(99769312, 9));
	}

	private static int findFrequency(int num, int digit) {
		int freq = 0;

		while (num > 0) {
			int remainder = num % 10;
			num = num / 10;

			if (remainder == digit)
				freq++;
		}
		return freq;
	}
}
