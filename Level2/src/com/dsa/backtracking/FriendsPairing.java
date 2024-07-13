package com.dsa.backtracking;

import java.util.ArrayList;
import java.util.List;

public class FriendsPairing {
	public static void main(String[] args) {
		System.out.println(pairFriends(3));
	}

	private static List<String> pairs;
	private static boolean[] paired;

	private static List<String> pairFriends(int n) {
		pairs = new ArrayList<>();
		paired = new boolean[3 + 1];
		pairFriends(n, 1, "");
		return pairs;
	}

	private static void pairFriends(int n, int f, String pair) {
		if (f == n + 1) {
			pairs.add(new String(pair));
			return;
		}
		if (paired[f]) {
			pairFriends(n, f + 1, pair);
		} else {
			paired[f] = true;
			pairFriends(n, f + 1, pair + "[" + f + "]");
			paired[f] = false;

			for (int i = f + 1; i <= n; i++) {
				if (!paired[i] && !paired[f]) {
					paired[i] = true;
					paired[f] = true;
					pairFriends(n, f + 1, pair + "[" + f + "," + i + "]");
					paired[i] = false;
					paired[f] = false;
				}
			}
		}
	}
}
