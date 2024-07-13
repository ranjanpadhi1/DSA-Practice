package com.ds.algo.arrays;

public class PrintBiDirectional {
	public static void main(String[] args) {
		printBiDirectionl(new int[] { 10, 20, 30, 40, 50, 60 });
		System.out.println("---");
		printBiDirectionl(new int[] { 10, 20 });
	}

	private static void printBiDirectionl(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
			System.out.println(arr[arr.length - 1 - i]);
		}
	}
}
