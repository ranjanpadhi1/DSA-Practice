package com.ds.algo.arrays;

import java.util.ArrayList;
import java.util.List;

public class SubArrayWithGivenSum {
	public static void main(String[] args) {
		System.out.println(subarraySum(new int[] { 1, 2, 3, 7, 5 }, 13));
	}

	private static List<Integer> subarraySum(int[] arr, int s) {
		int first = 0, second = 1, sum = arr[first];
		while (second < arr.length) {
			if (sum == s)
				break;
			sum += arr[second];
			if (sum < s)
				second++;
			else if (sum > s) {
				first++;
				sum = arr[first];
			}
		}
		List<Integer> result = new ArrayList<>();
		for (int i = first + 1; i < second; i++)
			result.add(arr[i]);
		return result;
	}
}
