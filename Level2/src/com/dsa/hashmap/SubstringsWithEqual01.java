package com.dsa.hashmap;

import java.util.HashMap;
import java.util.Map;

public class SubstringsWithEqual01 {
	public static void main(String[] args) {
		System.out.println(substringWithEqual01("011100"));
	}

	private static int substringWithEqual01(String str) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int c0 = 0, c1 = 0, count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '0')
				c0++;
			else
				c1++;
			if (map.containsKey(c1 - c0))
				count += map.get(c1 - c0);

			map.put(c1 - c0, map.getOrDefault(c1 - c0, 0) + 1);
		}
		return count;
	}
}
