package com.jsp.recursion;

public class TowerOfHanoi {
	public static void main(String[] args) {
		solveTowerOfHanoi(5, 'A', 'B', 'C');
	}

	private static void solveTowerOfHanoi(int disk, char source, char dest, char helper) {
		if (disk == 0)
			return;
		// Move n - 1 disks from A to C with help of B
		solveTowerOfHanoi(disk - 1, source, helper, dest);
		// Print instructions to move nth disk from A to B
		System.out.println("Move " + disk + " disk from " + source + " to " + dest);
		// Move n - 1 disks from A to C with help of B
		solveTowerOfHanoi(disk - 1, helper, dest, source);
	}
}
