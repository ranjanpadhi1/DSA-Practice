package com.dsa.hashmap;

import java.util.HashSet;
import java.util.Set;

public class CountSubstringWithUniqueChar {
	public static void main(String[] args) {
		System.out.println(countUniqueCharSubstring("abcdbac"));
		System.out.println(countUniqueCharSubstring("gffg"));
		System.out.println(countUniqueCharSubstring("gfg"));
		System.out.println(countUniqueCharSubstring("abababab"));
	}

	private static int countUniqueCharSubstring(String str) {
		Set<Character> set = new HashSet<>();
		int count = 0, left = 0;
		for (int right = 0; right < str.length(); right++) {
			char ch = str.charAt(right);
			if (!set.contains(ch))
				set.add(ch);
			else {
				while (set.contains(ch))
					set.remove(str.charAt(left++));
				set.add(ch);
			}
			count += set.size();
		}
		return count;
	}
}
