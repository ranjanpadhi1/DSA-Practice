package com.dsa.hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicStrings {
	public static void main(String[] args) {
		System.out.println(isIsomorphic("add", "egg"));
		System.out.println(isIsomorphic("foo", "bar"));
		System.out.println(isIsomorphic("paper", "title"));
		System.out.println(isIsomorphic("badc", "baba"));
	}

	public static boolean isIsomorphic(String s, String t) {
		Set<Character> set = new HashSet<>();
		Map<Character, Character> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char sCh = s.charAt(i), tCh = t.charAt(i);
			if (!map.containsKey(sCh)) {
				if (set.contains(tCh))
					return false;
				map.put(sCh, tCh);
				set.add(tCh);
			}

			else if (map.get(sCh) != tCh)
				return false;
		}
		return true;
	}
}
