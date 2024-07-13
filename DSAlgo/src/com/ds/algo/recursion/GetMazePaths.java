package com.ds.algo.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetMazePaths {
	public static void main(String[] args) {
		System.out.println(getMazePaths(1, 1, 3, 3));
	}

	private static List<String> getMazePaths(int srRow, int srCol, int dsRow, int dsCol) {
		if (srRow == dsRow && srCol == dsCol)
			return Arrays.asList(new String[] { "" });

		List<String> rowPaths = new ArrayList<>();
		List<String> colPaths = new ArrayList<>();

		if (srCol <= dsCol)
			rowPaths = getMazePaths(srRow, srCol + 1, dsRow, dsCol);

		if (srRow <= dsRow)
			colPaths = getMazePaths(srRow + 1, srCol, dsRow, dsCol);

		List<String> paths = new ArrayList<>();

		for (String rPath : rowPaths) {
			paths.add("h" + rPath);
		}

		for (String cPath : colPaths) {
			paths.add("v" + cPath);
		}

		return paths;
	}
}
