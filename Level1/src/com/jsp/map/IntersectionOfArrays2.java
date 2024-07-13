package com.jsp.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IntersectionOfArrays2 {
	public static void main(String[] args) {
		System.out.println(intersection2(new int[] { 1, 1, 2, 4, 5 }, new int[] { 1, 1, 3, 4 }));
	}

	private static List<Integer> intersection2(int[] arr1, int[] arr2) {
		HashMap<Integer, Integer> freqMap = new HashMap<>();

		for (int num : arr1) {
			freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
		}

		List<Integer> result = new ArrayList<>();
		for (int num : arr2) {
			if (freqMap.containsKey(num)) {
				result.add(num);

				int newFreq = freqMap.get(num) - 1;
				if (newFreq == 0)
					freqMap.remove(num);
				else
					freqMap.replace(num, newFreq);
			}
		}
		return result;
	}
}
