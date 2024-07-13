package com.dsa.hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagram {
	public static void main(String[] args) {
		System.out.println(findAnagrams1("cbaebabacd", "abc"));
		System.out.println(findAnagrams2("cbaebabacd", "abc"));
		System.out.println(findAnagrams1("cbaebabacdabc", "abc"));
		System.out.println(findAnagrams2("cbaebabacdabc", "abc"));
		System.out.println('z' - 'A');
	}

	private static List<Integer> findAnagrams2(String s, String p) {
		int pLength = p.length(), sLength = s.length();
		int[] pCount = new int[26];
		for (int i = 0; i < pLength; i++) {
			pCount[p.charAt(i) - 'a']++;
		}

		List<Integer> result = new ArrayList<>();
		int[] sCount = new int[26];
		for (int i = 0; i < sLength; i++) {
			if (i >= pLength) {
				sCount[s.charAt(i - pLength) - 'a']--;
			}
			sCount[s.charAt(i) - 'a']++;

			// Valid anagram
			if (Arrays.equals(pCount, sCount))
				result.add(i - pLength + 1);
		}
		return result;
	}

	private static List<Integer> findAnagrams1(String s, String p) {
		Map<Character, Integer> pMap = new HashMap<>();
		for (int i = 0; i < p.length(); i++) {
			char ch = p.charAt(i);
			pMap.put(ch, pMap.getOrDefault(ch, 0) + 1);
		}

		List<Integer> result = new ArrayList<>();
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			// if window is formed, slide
			if (i >= p.length()) {
				char left = s.charAt(i - p.length());
				if (map.get(left) == 1)
					map.remove(left);
				else
					map.put(left, map.getOrDefault(left, 0) - 1);
			}
			char ch = s.charAt(i);
			map.put(ch, map.getOrDefault(ch, 0) + 1);

			// Valid anagram
			if (map.equals(pMap)) {
				result.add(i - p.length() + 1);
			}
		}
		return result;
	}
}
