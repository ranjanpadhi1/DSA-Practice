package com.jsp.dp;

public class DecodeWays {
	public static void main(String[] args) {
		System.out.println(decodeWays1("2326", ""));
		System.out.println(decodeWays2("2326", 0, new int[5]));
		System.out.println(decodeWays3("2326"));
	}

	private static int decodeWays3(String str) {
		int[] dp = new int[str.length() + 1];
		dp[0] = 1;
		dp[1] = str.charAt(0) == '0' ? 0 : 1;

		for (int i = 2; i < dp.length; i++) {
			if (str.charAt(i - 1) != '0')
				dp[i] = dp[i - 1];

			int twoDigit = Integer.parseInt(str.substring(i - 2, i));
			if (twoDigit >= 10 && twoDigit <= 26)
				dp[i] += dp[i - 2];
		}

		return dp[str.length()];
	}

	private static int decodeWays2(String str, int i, int[] dp) {

		if (i == str.length())
			return 1;

		if (str.charAt(i) == '0')
			return 0;

		if (dp[i] > 0)
			return dp[i];

		int ways = decodeWays2(str, i + 1, dp);

		if (i < str.length() - 1 && Integer.parseInt(str.substring(i, i + 2)) <= 26)
			ways += decodeWays2(str, i + 2, dp);

		dp[i] = ways;

		return ways;
	}

	private static int decodeWays1(String str, String rs) {
		if (str.length() == 0) {
			System.out.println(rs);
			return 1;
		}
		int asc1 = Integer.parseInt(str.substring(0, 1));
		int ways = decodeWays1(str.substring(1), rs + decode(asc1));

		if (str.length() >= 2) {
			int asc2 = Integer.parseInt(str.substring(0, 2));
			if (asc2 <= 26)
				ways += decodeWays1(str.substring(2), rs + decode(asc2));
		}
		return ways;
	}

	private static char decode(int i) {
		return (char) (64 + i);
	}
}
