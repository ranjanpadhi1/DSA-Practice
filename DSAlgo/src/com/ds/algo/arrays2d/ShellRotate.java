package com.ds.algo.arrays2d;

import java.util.Arrays;

public class ShellRotate {
	public static void main(String[] args) {
		int[] row1 = new int[] { 11, 12, 13, 14, 15, 16 };
		int[] row2 = new int[] { 21, 22, 23, 24, 25, 26 };
		int[] row3 = new int[] { 31, 32, 33, 34, 35, 36 };
		int[] row4 = new int[] { 41, 42, 43, 44, 45, 46 };
		int[] row5 = new int[] { 51, 52, 53, 54, 55, 56 };
		int[] row6 = new int[] { 61, 62, 63, 64, 65, 66 };

		print(shellRotate(new int[][] { row1, row2, row3, row4, row5, row6 }, 2, 3));
	}

	private static int[][] shellRotate(int[][] mat, int shell, int rotate) {
		int[] shellArr = getShellElements(mat, shell);
		System.out.println(Arrays.toString(shellArr));
		rotateShelArr(shellArr, rotate);
		System.out.println(Arrays.toString(shellArr));
		fillElementsToShell(mat, shellArr, shell);
		return mat;
	}

	private static int[] getShellElements(int[][] mat, int shell) {
		int minr = shell - 1;
		int minc = shell - 1;
		int maxr = mat.length - shell;
		int maxc = mat[0].length - shell;

		int shellArr[] = new int[2 * (maxc - minc + maxr - minr)];
		int j = 0;
		// Top
		for (int i = minc; i <= maxc; i++) {
			shellArr[j++] = mat[minr][i];
		}
		// Right
		for (int i = minr + 1; i <= maxr; i++) {
			shellArr[j++] = mat[i][maxc];
		}
		// Bottom
		for (int i = maxc - 1; i >= minc; i--) {
			shellArr[j++] = mat[maxr][i];
		}

		// Left
		for (int i = maxc - 1; i > minc; i--) {
			shellArr[j++] = mat[i][minc];
		}
		return shellArr;
	}

	private static void rotateShelArr(int[] shellArr, int rotate) {
		int length = shellArr.length;
		rotate = rotate < 0 ? length + rotate : rotate;
		rotate = rotate % length;

		reverse(shellArr, 0, length - rotate - 1);
		reverse(shellArr, length - rotate, length - 1);
		reverse(shellArr, 0, length - 1);
	}

	private static void reverse(int[] arr, int i, int j) {
		while (i < j)
			swap(arr, i++, j--);
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static void fillElementsToShell(int[][] mat, int[] shellArr, int shell) {
		int minr = shell - 1;
		int minc = shell - 1;
		int maxr = mat.length - shell;
		int maxc = mat[0].length - shell;

		int j = 0;
		// Top
		for (int i = minc; i <= maxc; i++) {
			mat[minr][i] = shellArr[j++];
		}
		// Right
		for (int i = minr + 1; i <= maxr; i++) {
			mat[i][maxc] = shellArr[j++];
		}
		// Bottom
		for (int i = maxc - 1; i >= minc; i--) {
			mat[maxr][i] = shellArr[j++];
		}

		// Left
		for (int i = maxc - 1; i > minc; i--) {
			mat[i][minc] = shellArr[j++];
		}
	}

	private static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
