package com.jsp.map;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionOfArrays {
	public static void main(String[] args) {
		System.out.println(intersection(new int[] { 4, 4, 9, 5 }, new int[] { 9, 4, 9, 8, 4 }));
	}

	private static List<Integer> intersection(int[] arr1, int[] arr2) {
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < arr1.length; i++) {
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
