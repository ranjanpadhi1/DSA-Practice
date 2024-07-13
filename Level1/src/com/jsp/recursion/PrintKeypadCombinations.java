package com.jsp.recursion;

import java.util.Map;

public class PrintKeypadCombinations {
	public static void main(String[] args) {
		printKeypadCombinations("246", "");
	}

	private static final Map<Character, Character[]> KEYPAD = Map.of('2', new Character[] { 'a', 'b', 'c' }, '3',
			new Character[] { 'd', 'e', 'f' }, '4', new Character[] { 'g', 'h', 'i' }, '5',
			new Character[] { 'j', 'k', 'l' }, '6', new Character[] { 'm', 'n', 'o' }, '7',
			new Character[] { 'p', 'q', 'r', 's' }, '8', new Character[] { 't', 'u', 'v' }, '9',
			new Character[] { 'w', 'x', 'y', 'z' });

	private static void printKeypadCombinations(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.print(ans + " ");
			return;
		}
		for (char letter : KEYPAD.get(ques.charAt(0))) {
			printKeypadCombinations(ques.substring(1), ans + letter);
		}
	}
}
