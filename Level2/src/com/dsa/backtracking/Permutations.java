package com.dsa.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	public static void main(String[] args) {
		System.out.println(permute(new int[] { 1, 2, 3 }));
	}

	private static List<List<Integer>> perms;
	private static boolean[] visited;

	public static List<List<Integer>> permute(int[] nums) {
		perms = new ArrayList<>();
		visited = new boolean[nums.length];
		permute(nums, new ArrayList<>());
		return perms;
	}

	private static void permute(int[] nums, List<Integer> perm) {
		if (perm.size() == nums.length) {
			perms.add(new ArrayList<>(perm));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				perm.add(nums[i]);
				permute(nums, perm);
				perm.remove(perm.size() - 1);
				visited[i] = false;
			}
		}
	}
}
