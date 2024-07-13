package com.dsa.hashmap;

import java.util.HashMap;
import java.util.Map;

public class CountPairsDivByK {
	public static void main(String[] args) {
		System.out.println(pairsDivByK(new int[] { 2, 2, 1, 7, 5, 3 }, 4));
		System.out.println(pairsDivByK(new int[] { 5, 9, 36, 74, 52, 31, 42 }, 3));
	}

	private static int pairsDivByK(int[] arr, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int val : arr) {
			map.put(val % k, map.getOrDefault(val % k, 0) + 1);
		}
		System.out.println(map);
		int count = map.getOrDefault(0, 0), left = 1, right = k - 1;
		while (left < right) {
			count += map.getOrDefault(left++, 0) * map.getOrDefault(right--, 0);
		}

		if (map.size() % 2 != 0 && k % 2 == 0) {
			count += map.getOrDefault((k / 2), 0) / 2;
		}
		return count;
	}
}
