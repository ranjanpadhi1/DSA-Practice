package com.ds.algo.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TopKFrequentElements {
	public static void main(String[] args) {

	}

	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		Integer[] freqArr = new TreeMap<>(map).values().toArray(new Integer[map.size()]);
		int[] result = new int[k];
		int i = freqArr.length;
		while (k >= 0) {
			result[--k] = freqArr[--i];
		}

		return result;
	}
}
