package com.dsa.hashmap;

public class MinimumWindowSubstring {
	public static void main(String[] args) {
		System.out.println(minWindowSubstring("ADOBECODEBANC", "ABC"));
		System.out.println(minWindowSubstring("cabwefgewcwaefgcf", "cae"));
	}

	private static String minWindowSubstring(String s, String p) {
		int[] pCount = new int[58];
		for (int i = 0; i < p.length(); i++) {
			pCount[p.charAt(i) - 'A']++;
		}

		String minSubstring = "";
		int start = 0, minLength = s.length();
		int[] sCount = new int[58];

		for (int i = 0; i < s.length(); i++) {
			sCount[s.charAt(i) - 'A']++;
			while (validAnagram(pCount, sCount)) {
				if (i - start < minLength) {
					minLength = i - start;
					minSubstring = s.substring(start, i + 1);
				}
				sCount[s.charAt(start++) - 'A']--;
			}
		}
		return minSubstring;
	}

	private static boolean validAnagram(int[] pCount, int[] sCount) {
		for (int i = 0; i < 58; i++) {
			if (pCount[i] > sCount[i])
				return false;
		}
		return true;
	}
}
