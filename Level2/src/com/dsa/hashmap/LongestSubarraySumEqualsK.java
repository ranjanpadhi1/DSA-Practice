package com.dsa.hashmap;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarraySumEqualsK {
	public static void main(String[] args) {
		System.out.println(longestSubArrayWithEqual01(new int[] { 1, -1, 5, -2, 3 }, 3));
	}

	private static int longestSubArrayWithEqual01(int[] arr, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);

		int preSum = 0, maxLength = 0;
		for (int i = 0; i < arr.length; i++) {
			preSum += arr[i];

			if (map.containsKey(preSum - k))
				maxLength = Math.max(maxLength, i - map.get(preSum - k));

			if (!map.containsKey(preSum))
				map.put(preSum, i);
		}
		return maxLength;
	}
}
