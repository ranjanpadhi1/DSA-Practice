package com.jsp.basics;

public class InverseANumber {
	public static void main(String[] args) {
		System.out.println(inverse(21453));
		System.out.println(inverse(426135));
	}

	private static int inverse(int num) {
		int inverse = 0, pos = 1;

		while (num > 0) {
			inverse += pos * Math.pow(10, (num % 10) - 1);
			num = num / 10;
			pos++;
		}
		return inverse;
	}
}
