package com.jsp.basics;

public class ReverseANumber {
	public static void main(String[] args) {
		System.out.println(reverse(123));
		System.out.println(reverse(54321));
	}

	private static int reverse(int num) {
		int place = (int) Math.pow(10, noOfDigits(num) - 1);
		int reverse = 0;

		while (num > 0) {
			reverse += (num % 10) * place;
			num /= 10;
			place = place / 10;
		}
		return reverse;
	}

	private static int noOfDigits(int num) {
		int digit = 0;
		while (num > 0) {
			num /= 10;
			digit++;
		}
		return digit;
	}

}
