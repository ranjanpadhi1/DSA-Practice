package com.dsa.hashmap;

import java.util.HashMap;
import java.util.Map;

public class SubstringsWithEqual012 {
	public static void main(String[] args) {
		System.out.println(substringWithEqual012("0102010"));
		System.out.println(substringWithEqual012("102100211"));
	}

	private static int substringWithEqual012(String str) {
		Map<String, Integer> map = new HashMap<>();
		map.put("0#0", 1);

		int c0 = 0, c1 = 0, c2 = 0, count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '0')
				c0++;
			else if (str.charAt(i) == '1')
				c1++;
			else
				c2++;
			String key = (c1 - c0) + "#" + (c2 - c1);
			if (map.containsKey(key))
				count += map.get(key);

			map.put(key, map.getOrDefault(key, 0) + 1);
		}
		return count;
	}
}
