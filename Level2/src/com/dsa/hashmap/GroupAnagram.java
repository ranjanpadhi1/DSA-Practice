package com.dsa.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {
	public static void main(String[] args) {
		System.out.println(groupAnagram(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));
	}

	private static List<List<String>> groupAnagram(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();

		for (String str : strs) {
			int[] freq = new int[26];
			for (char ch : str.toCharArray())
				freq[ch - 'a']++;
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < 26; i++) {
				sb.append(freq[i]);
				sb.append("#");
			}
			String key = sb.toString();
			if (!map.containsKey(key))
				map.put(key, new ArrayList<>());

			map.get(key).add(str);
		}
		return new ArrayList<>(map.values());
	}
}
