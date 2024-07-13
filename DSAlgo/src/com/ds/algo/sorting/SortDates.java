package com.ds.algo.sorting;

import java.util.Arrays;

public class SortDates {
	public static void main(String[] args) {
		System.out.println(Arrays
				.toString(sortDates(new String[] { "12041996", "20101996", "05061997", "12041989", "11081987" })));
	}

	private static String[] sortDates(String[] dates) {

		dates = countSort(dates, 1000000, 100, 32);
		dates = countSort(dates, 10000, 100, 13);
		dates = countSort(dates, 1, 10000, 2500);
		return dates;
	}

	private static String[] countSort(String[] dates, int div, int mod, int range) {
		int[] rangeArr = new int[range];
		// Store ranges
		for (String date : dates) {
			System.out.println(Integer.parseInt(date) / div % mod);
			rangeArr[Integer.parseInt(date) / div % mod]++;
		}
		// Prefix sum
		rangeArr[0] = rangeArr[0] - 1;
		for (int i = 1; i < rangeArr.length; i++) {
			rangeArr[i] += rangeArr[i - 1];
		}
		// Prepare result
		String[] result = new String[dates.length];
		for (int i = dates.length - 1; i >= 0; i--) {
			int rangeIndex = Integer.parseInt(dates[i]) / div % mod;
			result[rangeArr[rangeIndex]] = dates[i];
			rangeArr[rangeIndex]--;
		}
		return result;
	}
}
