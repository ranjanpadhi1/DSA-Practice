package com.jsp.basics;

public class RotateANumber {
	public static void main(String[] args) {
		System.out.println(rotate(123456, 2));
		System.out.println(rotate(224444, 4));
		System.out.println(rotate(123456, 2));
		System.out.println((int) Math.pow(2, 31));
	}

	private static int rotate(int num, int k) {
		int digit = noOfDigit(num);
		int div = (int) Math.pow(10, k), mul = (int) Math.pow(10, digit - k);
		int left = num / div, right = num % div;
		return (right * mul) + left;
	}

	private static int noOfDigit(int num) {
		int count = 0;
		while (num > 0) {
			num = num / 10;
			count++;
		}
		return count;
	}
}
