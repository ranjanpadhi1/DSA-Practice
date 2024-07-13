package com.dsa.hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubWithoutRepeatingChar {
	public static void main(String[] args) {
		System.out.println(longestSubstring1("abcabdceafdcab"));
		System.out.println(longestSubstring2("abcebadefcd"));
		System.out.println(longestSubstring2("abcabdceafdcab"));
		System.out.println(longestSubstring2("abcabcbb"));
	}

	private static int longestSubstring2(String str) {
		Map<Character, Integer> map = new HashMap<>();
		int maxLen = 0;

		for (int right = 0, left = 0; right < str.length(); right++) {
			char ch = str.charAt(right);
			if (map.containsKey(ch)) {
				left = Math.max(map.get(ch) + 1, left);
			}
			map.put(ch, right);
			maxLen = Math.max(maxLen, right - left + 1);
		}
		return maxLen;
	}

	private static String longestSubstring1(String str) {
		Set<Character> set = new HashSet<>();

		int left = 0, right = 0, maxLen = 0;
		String substring = "";

		while (right < str.length()) {
			char ch = str.charAt(right);
			if (!set.contains(ch)) {
				set.add(ch);
				if (maxLen < right - left + 1) {
					maxLen = right - left + 1;
					substring = str.substring(left, right + 1);
				}
			} else {
				while (set.contains(ch))
					set.remove(str.charAt(left++));
				set.add(ch);
			}
			right++;
		}
		return substring;
	}
}
