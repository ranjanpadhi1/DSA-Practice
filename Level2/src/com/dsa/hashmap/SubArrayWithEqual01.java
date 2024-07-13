package com.dsa.hashmap;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithEqual01 {
	public static void main(String[] args) {
		System.out.println(subArrayCount(new int[] { 0, 1, 1, 1, 0, 0 }));
	}

	private static int subArrayCount(int[] arr) {
		Map<Integer, Integer> pSumFreqMap = new HashMap<>();
		pSumFreqMap.put(0, 1);

		int subArrayCount = 0, sum = 0;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i] == 0 ? -1 : arr[i];
			int freq = 0;
			if (pSumFreqMap.containsKey(sum)) {
				freq = pSumFreqMap.get(sum);
				subArrayCount += freq;
			}
			pSumFreqMap.put(sum, freq + 1);
		}

		return subArrayCount;
	}
}
