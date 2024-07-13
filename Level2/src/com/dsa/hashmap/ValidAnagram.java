package com.dsa.hashmap;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
	public static void main(String[] args) {
		System.out.println(isAnagram("cat", "tac"));
		System.out.println(isAnagram("cat", "rat"));

	}

	public static boolean isAnagram(String s, String t) {
		int sl = s.length();
		int tl = t.length();
		if (sl != tl) {
			return false;
		}

		Map<Character, Integer> smap = new HashMap<>();
		for (int i = 0; i < sl; i++) {
			smap.put(s.charAt(i), smap.getOrDefault(s.charAt(i), 0) + 1);
			smap.put(t.charAt(i), smap.getOrDefault(t.charAt(i), 0) - 1);
		}
		for (char c : smap.keySet()) {
			if (smap.get(c) != 0) {
				return false;
			}
		}
		return true;
	}
}
