package com.jsp.arrays;

public class SubsetsOfArray {
	public static void main(String[] args) {
		printSubsets(new int[] { 10, 20, 30 });
		System.out.println("----------");
		printSubsetsR(new int[] { 10, 20, 30 }, "", 0);
	}

	private static void printSubsets(int[] arr) {
		int limit = (int) Math.pow(2, arr.length);

		for (int i = 0; i < limit; i++) {
			int num = i;
			for (int j = 0; j < arr.length; j++) {
				System.out.print(num % 2 == 0 ? "__ " : arr[j] + " ");
				num = num / 2;
			}
			System.out.println();
		}
	}

	private static void printSubsetsR(int[] arr, String subArr, int idx) {
		if (idx == arr.length) {
			System.out.println(subArr);
			return;
		}
		printSubsetsR(arr, subArr + "__ ", idx + 1);
		printSubsetsR(arr, subArr + arr[idx] + " ", idx + 1);
	}
}
