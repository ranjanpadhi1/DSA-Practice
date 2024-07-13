package com.ds.algo.arrays;

public class JewelsAndStones {

	// 771. Jewels and Stones
	public static void main(String[] args) {
		System.out.println(numJewelsInStones("aA", "aAAbbbb"));
	}

	// Brute force - O(n^2)
	private static int numJewelsInStones(String jewels, String stones) {
		int count = 0;
		for (int i = 0; i < jewels.length(); i++) {
			for (int j = 0; j < stones.length(); j++)
				if (jewels.charAt(i) == stones.charAt(j))
					count++;
		}
		return count;
	}
}
