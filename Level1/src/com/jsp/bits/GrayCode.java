package com.jsp.bits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GrayCode {
	public static void main(String[] args) {
		System.out.println(grayCode(4));
	}

	private static List<String> grayCode(int n) {
		if (n == 1) {
			return Arrays.asList("0", "1");
		}

		List<String> grayCodes = grayCode(n - 1);
		List<String> rs = new ArrayList<>();

		for (int i = 0; i < grayCodes.size(); i++) {
			rs.add("0" + grayCodes.get(i));
		}

		for (int i = grayCodes.size() - 1; i >= 0; i--) {
			rs.add("1" + grayCodes.get(i));
		}

		return rs;
	}
}
