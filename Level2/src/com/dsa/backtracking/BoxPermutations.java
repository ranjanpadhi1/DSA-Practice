package com.dsa.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoxPermutations {
	public static void main(String[] args) {
		System.out.println(boxPermute(3, 2));
	}

	private static List<List<Integer>> permutations;

	private static List<List<Integer>> boxPermute(int box, int items) {
		permutations = new ArrayList<>();
		Integer[] boxes = new Integer[box];
		Arrays.fill(boxes, 0);
		permute(boxes, items, 1);
		return permutations;
	}

	private static void permute(Integer[] boxes, int items, int currItem) {
		if (currItem > items) {
			permutations.add(new ArrayList<>(Arrays.asList(boxes)));
			return;
		}

		for (int i = 0; i < boxes.length; i++) {
			if (boxes[i] == 0) {
				boxes[i] = currItem;
				permute(boxes, items, currItem + 1);
				boxes[i] = 0;
			}
		}
	}
}
