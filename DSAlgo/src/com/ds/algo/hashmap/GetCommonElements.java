package com.ds.algo.hashmap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GetCommonElements {
	public static void main(String[] args) {
		System.out.println(getCommonElements(new int[] { 1, 1, 2, 2, 2, 3, 5 }, new int[] { 1, 1, 1, 2, 2, 4, 5 }));
	}

	private static List<Integer> getCommonElements(int[] arr1, int[] arr2) {
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < arr1.length; i++) {
			if (!set.contains(arr1[i]))
				set.add(arr1[i]);
		}

		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < arr2.length; i++) {
			if (set.contains(arr2[i])) {
				result.add(arr2[i]);
				set.remove(arr2[i]);
			}
		}
		return result;
	}
}
