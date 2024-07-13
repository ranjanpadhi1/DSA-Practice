package com.dsa.hashmap;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithEqual01 {
	public static void main(String[] args) {
		System.out.println(longestSubArrayWithEqual01(new int[] { 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0 }));
	}

	private static int longestSubArrayWithEqual01(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);

		int preSum = 0, maxLength = 0;
		for (int i = 0; i < arr.length; i++) {
			preSum += arr[i] == 0 ? -1 : 1;
			if (map.containsKey(preSum))
				maxLength = Math.max(maxLength, i - map.get(preSum));
			else
				map.put(preSum, i);
		}
		return maxLength;
	}
}
