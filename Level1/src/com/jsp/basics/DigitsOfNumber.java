package com.jsp.basics;

public class DigitsOfNumber {
	public static void main(String[] args) {
		printDigits(754);
		printDigits(54321);
	}

	private static void printDigits(int num) {
		int div = (int) Math.pow(10, noOfDigits(num) - 1);
		while (num > 0) {
			System.out.print(num / div + " ");
			num = num % div;
			div /= 10;
		}
		System.out.println();
	}

	private static int noOfDigits(int num) {
		int digit = 0;

		while (num > 0) {
			num = num / 10;
			digit++;
		}
		return digit;
	}
}
