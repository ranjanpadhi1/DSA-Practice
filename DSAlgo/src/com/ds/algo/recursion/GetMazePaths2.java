package com.ds.algo.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetMazePaths2 {
	// Movements - Horizontal, Vertical, Diagonal
	// Jumps - 1, 2, 3
	public static void main(String[] args) {
		System.out.println(getMazePaths(1, 1, 4, 4));
	}

	private static List<String> getMazePaths(int srRow, int srCol, int dsRow, int dsCol) {

		if (srRow == dsRow && srCol == dsCol)
			return Arrays.asList(new String[] { "" });

		List<String> results = new ArrayList<>();
		for (int i = 1; i <= 3; i++) {
			if (srRow <= dsRow) {
				List<String> rowPaths = getMazePaths(srRow, srCol, dsRow, dsCol);
				for (String rPath : rowPaths) {
					results.add("h" + i + rPath);
				}
			}

			if (srCol <= dsCol) {
				List<String> colPaths = getMazePaths(srRow, srCol, dsRow, dsCol);
				for (String cPath : colPaths) {
					results.add("v" + i + cPath);
				}
			}

			if (srRow <= dsRow && srCol <= dsCol) {
				List<String> diagPaths = getMazePaths(srRow, srCol, dsRow, dsCol);
				for (String dPath : diagPaths) {
					results.add("d" + i + dPath);
				}
			}
		}

		return results;
	}
}
