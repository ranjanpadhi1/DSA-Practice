package com.ds.algo.hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArrays {
	public static void main(String[] args) {
		System.out.println(
				Arrays.toString(intersect(new int[] { 1, 1, 2, 2, 2, 3, 5 }, new int[] { 1, 1, 1, 2, 2, 4, 5 })));
	}

	private static int[] intersect(int[] arr1, int[] arr2) {
		Map<Integer, Integer> freqMap = new HashMap<>();
		for (int num : arr1)
			freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);

		List<Integer> list = new ArrayList<>();
		for (int num : arr2) {
			if (freqMap.containsKey(num) && freqMap.get(num) > 0) {
				list.add(num);
				freqMap.put(num, freqMap.get(num) - 1);
			}
		}

		int[] result = new int[list.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = list.get(i);
		}

		return result;
	}
}
