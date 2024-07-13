package com.dsa.hashmap;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
	public static void main(String[] args) {
		System.out.println(subArraySumEqualsK(new int[] { 2, 5, 1, 6, 7, 3, 4, 8, 2 }, 14));
	}

	private static int subArraySumEqualsK(int[] arr, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);

		int sum = 0, count = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (map.containsKey(sum - k)) {
				count += map.get(sum - k);
			}
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return count;
	}
}
