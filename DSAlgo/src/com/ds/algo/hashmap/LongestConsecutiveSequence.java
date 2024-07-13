package com.ds.algo.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {
	public static void main(String[] args) {
		System.out.println(longestConsecutiveSeq(new int[] { 5, 9, 1, 11, 8, 6, 15, 3, 12, 2 }));
		System.out.println(longestConsecutiveSeq(new int[] { 5, 9, 1, 11, 8, 6, 15, 3, 12, 2, 7 }));
		System.out.println(longestConsecutiveSeq2(new int[] { 5, 9, 1, 11, 8, 6, 15, 3, 12, 2 }));
		System.out.println(longestConsecutiveSeq2(new int[] { 5, 9, 1, 11, 8, 6, 15, 3, 12, 2, 7 }));
	}

	// Sort and count seq - O(nLogn + n) / O(1)
	private static int longestConsecutiveSeq(int[] arr) {
		Arrays.sort(arr);
		int longestSeq = 0, count = 1;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] + 1 == arr[i + 1]) {
				count++;
			} else {
				longestSeq = Math.max(longestSeq, count);
				count = 1;
			}
		}
		return longestSeq;
	}

	private static int longestConsecutiveSeq2(int[] arr) {
		Map<Integer, Boolean> map = new HashMap<>();

		for (int num : arr)
			map.put(num, true);

		for (int num : map.keySet()) {
			if (map.containsKey(num - 1))
				map.put(num, false);
		}
		int longest = 0;
		for (int num : map.keySet()) {
			if (map.get(num)) {
				int count = 0;
				while (map.get(num++) != null)
					count++;
				longest = Math.max(longest, count);
			}
		}

		return longest;
	}
}
