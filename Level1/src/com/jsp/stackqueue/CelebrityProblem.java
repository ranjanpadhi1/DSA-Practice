package com.jsp.stackqueue;

import java.util.Stack;

public class CelebrityProblem {
	public static void main(String[] args) {
		int[][] celeb = new int[][] { new int[] { 0, 1, 1, 0, 1 }, new int[] { 0, 0, 1, 1, 0 },
				new int[] { 0, 0, 0, 0, 0 }, new int[] { 0, 1, 1, 0, 1 }, new int[] { 1, 0, 1, 1, 0 } };
		System.out.println(findCelebrity(celeb));
	}

	private static int findCelebrity(int[][] knows) {
		Stack<Integer> persons = new Stack<>();
		for (int i = 0; i < knows.length; i++)
			persons.push(i);

		while (persons.size() > 1) {
			int p1 = persons.pop();
			int p2 = persons.pop();
			persons.push(knows[p1][p2] == 1 ? p2 : p1);
		}

		return isCelebrity(persons.peek(), knows) ? persons.pop() : -1;
	}

	private static boolean isCelebrity(Integer celeb, int[][] knows) {
		for (int person = 0; person < knows.length; person++) {
			if (person == celeb)
				continue;
			if (knows[person][celeb] == 0 || knows[celeb][person] == 1)
				return false;
		}
		return true;
	}
}
