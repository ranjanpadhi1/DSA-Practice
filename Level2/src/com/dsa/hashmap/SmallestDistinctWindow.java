package com.dsa.hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SmallestDistinctWindow {
	public static void main(String[] args) {
		System.out.println(findSubString("aabcbcdbca"));
		System.out.println(findSubString("aabcbcdbca"));
		System.out.println(findSubString("aabcbcdbca"));
	}

	public static int findSubString(String str) {
		Set<Character> set = new HashSet<>();
		for (char ch : str.toCharArray()) {
			if (!set.contains(ch))
				set.add(ch);
		}
		int distSize = set.size(), minLen = str.length();
		Map<Character, Integer> map = new HashMap<>();
		for (int left = 0, right = 0; right < str.length(); right++) {
			char ch = str.charAt(right);
			map.put(ch, map.getOrDefault(ch, 0) + 1);
			while (map.size() == distSize) {
				char lCh = str.charAt(left);
				if (map.get(lCh) == 1)
					map.remove(lCh);
				else
					map.put(lCh, map.get(lCh) - 1);

				minLen = Math.min(minLen, right - left + 1);
				left++;
			}
		}
		return minLen;
	}
}
