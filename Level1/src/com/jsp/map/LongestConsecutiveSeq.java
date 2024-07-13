package com.jsp.map;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSeq {

	public static void main(String[] args) {
		System.out.println(longestConsecuteSeq(new int[] { 10, 5, 9, 1, 11, 8, 6, 15, 3, 12, 2 }));
	}

	private static int longestConsecuteSeq(int[] arr) {
		Set<Integer> set = new HashSet<>();
		for (int num : arr)
			set.add(num);

		int longestSeq = 0;
		for (int num : set) {
			if (!set.contains(num - 1)) {
				int count = 0;
				while (set.contains(num)) {
					count++;
					num++;
				}
				longestSeq = Math.max(longestSeq, count);
			}
		}
		return longestSeq;
	}
}
