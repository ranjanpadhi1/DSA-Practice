package com.ds.algo.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllDuplicatesInArray {

	// 442. Find All Duplicates in an Array
	public static void main(String[] args) {
		System.out.println(findDuplicates1(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 }));
		System.out.println(findDuplicates1(new int[] { 1, 1, 2 }));
		System.out.println(findDuplicates2(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 }));
		System.out.println(findDuplicates2(new int[] { 1, 1, 2 }));
		System.out.println(findDuplicates3(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 }));
		System.out.println(findDuplicates3(new int[] { 1, 1, 2 }));
	}

	// Brute force - O(n^2)
	private static List<Integer> findDuplicates1(int[] arr) {
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (i != j && arr[i] == arr[j] && !list.contains(arr[i]))
					list.add(arr[i]);
			}
		}
		return list;
	}

	// Using HashMap - O(n) / O(n)
	private static List<Integer> findDuplicates2(int[] arr) {
		List<Integer> list = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();

		for (int ele : arr) {
			if (map.containsKey(ele))
				list.add(ele);
			else
				map.put(ele, 1);
		}

		return list;
	}

	// Using range array O(n) / O(n)
	private static List<Integer> findDuplicates3(int[] arr) {
		List<Integer> list = new ArrayList<>();
		int rangeArr[] = new int[arr.length + 1];
		for (int ele : arr) {
			rangeArr[ele]++;
			if (rangeArr[ele] == 2)
				list.add(ele);
		}
		return list;
	}

}
