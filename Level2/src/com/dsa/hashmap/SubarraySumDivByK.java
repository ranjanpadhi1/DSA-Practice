package com.dsa.hashmap;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumDivByK {
	public static void main(String[] args) {
		System.out.println(subarraysDivByK(new int[] { 4, 5, 0, -2, -3, 1 }, 5));
	}

	private static int subarraysDivByK(int[] arr, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int sum = 0, count = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			int remainder = sum % k;
			if (remainder < 0)
				remainder += k;
			if (map.containsKey(remainder)) {
				count += map.get(remainder);
			}
			map.put(remainder, map.getOrDefault(remainder, 0) + 1);
		}
		return count;
	}
}
