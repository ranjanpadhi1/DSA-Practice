package com.jsp.basics;

public class CountDigits {
	public static void main(String[] args) {
		System.out.println(countDigits(2));
		System.out.println(countDigits(345));
		System.out.println(countDigits(2346));
		System.out.println(countDigits(24536712));
	}

	private static int countDigits(int num) {
		int digit = 0;
		while (num > 0) {
			num = num / 10;
			digit++;
		}
		return digit;
	}
}
