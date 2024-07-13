package com.dsa.basics;
public class ReverseNumBinarySearch {
	public static void main(String[] args) {

		System.out.println(countDigit(12345));
		System.out.println(reverseNum(12345));

		System.out.println(binarySearch(new int[] { 1, 3, 5, 6, 7, 10, 12, 13, 14 }, 13));
	}

	private static int countDigit(int num) {
		int count = 0;

		while (num != 0) {
			num /= 10;
			count++;
		}

		return count;
	}

	private static int reverseNum(int num) {
		int revNum = 0;

		while (num != 0) {
			int digit = num % 10;
			revNum = revNum * 10 + digit;
			num /= 10;
		}

		return revNum;
	}

	private static int binarySearch(int[] arr, int target) {
		int left = 0, right = arr.length - 1, count = 0;

		while (left <= right) {
			int mid = (left + right) / 2;
			System.out.println("Count : " + count);

			if (arr[mid] > target)
				right = mid - 1;
			else if (arr[mid] < target)
				left = mid + 1;
			else
				return mid;
			count++;
		}
		return -1;
	}
}
