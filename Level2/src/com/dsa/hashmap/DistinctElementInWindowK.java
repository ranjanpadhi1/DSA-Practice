package com.dsa.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DistinctElementInWindowK {
	public static void main(String[] args) {
		System.out.println(distinctElement(new int[] { 1, 2, 1, 3, 4, 2, 3 }, 4));
	}

	private static List<Integer> distinctElement(int[] arr, int k) {
		ArrayList<Integer> result = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			if (i >= k) {
				result.add(map.size());
				// Remove/reduce left most element of the window
				if (map.get(arr[i - k]) == 1)
					map.remove(arr[i - k]);
				else
					map.put(arr[i - k], map.get(arr[i - k]) - 1);
			}
			// Add new element to the window
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
		result.add(map.size());
		return result;
	}
}
