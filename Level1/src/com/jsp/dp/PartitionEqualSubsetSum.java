package com.jsp.dp;

public class PartitionEqualSubsetSum {
	public static void main(String[] args) {
		System.out.println(canPartition(new int[] { 1, 5, 11, 5 }));
		System.out.println(canPartition(new int[] { 1, 1, 1, 1 }));
	}

	private static boolean canPartition(int[] nums) {
		int sum = 0;
		for (int num : nums)
			sum += num;

		if (sum % 2 != 0)
			return false;

		int target = sum / 2;

		int[][] dp = new int[nums.length + 1][target + 1];

		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j <= target; j++) {
				if (j == 0)
					dp[i][j] = 1;
				else if (i != 0) {
					dp[i][j] = dp[i - 1][j];
					if (j >= nums[i - 1])
						dp[i][j] += dp[i - 1][j - nums[i - 1]];
				}
			}
		}
		print(dp);
		return dp[nums.length][target] == 2;
	}

	private static void print(int[][] dp) {
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
	}
}
