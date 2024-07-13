package com.dsa.backtracking;

import java.util.ArrayList;
import java.util.List;

public class BoxCombinations {
	public static void main(String[] args) {
		System.out.println(combinations(2, 2));
	}

	private static List<List<Integer>> combs;

	private static List<List<Integer>> combinations(int box, int item) {
		combs = new ArrayList<>();
		findCombinations(box, item, 0, 1, new ArrayList<>());
		return combs;
	}

	private static void findCombinations(int box, int item, int currBox, int currItem, List<Integer> comb) {
		if (currBox > box) {
			if (currItem - 1 == item)
				combs.add(new ArrayList<>(comb));
			return;
		}
		comb.add(0);
		findCombinations(box, item, currBox + 1, currItem, comb);
		comb.remove(comb.size() - 1);
		comb.add(currItem);
		findCombinations(box, item, currBox + 1, currItem + 1, comb);
		comb.remove(comb.size() - 1);
	}
}
