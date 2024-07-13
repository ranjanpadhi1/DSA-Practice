package com.jsp.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class KeypadCombinations {
	public static void main(String[] args) {
		System.out.println(keypadCombinations("23"));
	}

	private static final Map<Character, Character[]> KEYPAD = Map.of('2', new Character[] { 'a', 'b', 'c' }, '3',
			new Character[] { 'd', 'e', 'f' }, '4', new Character[] { 'g', 'h', 'i' }, '5',
			new Character[] { 'j', 'k', 'l' }, '6', new Character[] { 'm', 'n', 'o' }, '7',
			new Character[] { 'p', 'q', 'r', 's' }, '8', new Character[] { 't', 'u', 'v' }, '9',
			new Character[] { 'w', 'x', 'y', 'z' });

	private static List<String> keypadCombinations(String keys) {
		if (keys.length() == 0)
			return List.of("");

		List<String> result = new ArrayList<>();
		for (char letter : KEYPAD.get(keys.charAt(0))) {
			for (String combs : keypadCombinations(keys.substring(1))) {
				result.add(letter + combs);
			}
		}
		return result;
	}
}
