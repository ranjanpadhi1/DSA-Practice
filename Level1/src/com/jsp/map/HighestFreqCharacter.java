package com.jsp.map;

import java.util.HashMap;
import java.util.Map;

public class HighestFreqCharacter {
	public static void main(String[] args) {
		System.out.println(highestFreqChar("bacabccacabcbc"));
	}

	private static char highestFreqChar(String str) {
		Map<Character, Integer> freqMap = new HashMap<>();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (freqMap.containsKey(ch))
				freqMap.replace(ch, freqMap.get(ch) + 1);
			else
				freqMap.put(ch, 1);
		}

		char maxFreqChar = str.charAt(0);
		int maxFreq = freqMap.get(maxFreqChar);

		for (Character ch : freqMap.keySet()) {
			if (freqMap.get(ch) > maxFreq) {
				maxFreq = freqMap.get(ch);
				maxFreqChar = ch;
			}
		}
		return maxFreqChar;
	}
}
