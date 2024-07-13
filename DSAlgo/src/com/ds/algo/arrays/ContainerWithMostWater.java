package com.ds.algo.arrays;

public class ContainerWithMostWater {

	// 11. Container With Most Water
	public static void main(String[] args) {
		System.out.println(mostWaterContainer1(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
		System.out.println(mostWaterContainer2(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
	}

	// Brute force - O(n^2)
	private static int mostWaterContainer1(int[] arr) {
		int maxArea = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int area = Math.min(arr[i], arr[j]) * (j - i);
				if (area > maxArea)
					maxArea = area;
			}
		}

		return maxArea;
	}

	// Two pointers - O(n)
	private static int mostWaterContainer2(int[] arr) {
		int maxArea = 0;
		int left = 0, right = arr.length - 1;
		while (left < right) {
			int area = Math.min(arr[left], arr[right]) * (right - left);

			if (area > maxArea)
				maxArea = area;

			if (arr[left] < arr[right])
				left++;
			else
				right--;
		}
		return maxArea;
	}
}
