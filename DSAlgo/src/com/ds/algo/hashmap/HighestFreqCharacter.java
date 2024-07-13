package com.ds.algo.hashmap;

import java.util.HashMap;
import java.util.Map;

public class HighestFreqCharacter {
	public static void main(String[] args) {
		System.out.println(highestFreqChar("abracadabra"));
	}

	private static int highestFreqChar(String s) {
		Map<Character, Integer> freqMap = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			freqMap.put(s.charAt(i), freqMap.getOrDefault(s.charAt(i), 0) + 1);
		}

		int maxLength = 0;
		for (Character ch : freqMap.keySet())
			maxLength = Math.max(freqMap.get(ch), maxLength);

		return maxLength;
	}
}
