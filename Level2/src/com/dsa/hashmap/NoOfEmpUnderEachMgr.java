package com.dsa.hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NoOfEmpUnderEachMgr {
	public static void main(String[] args) {
		Map<String, String> dataSet = new HashMap<String, String>();
		dataSet.put("A", "C");
		dataSet.put("B", "C");
		dataSet.put("C", "F");
		dataSet.put("D", "E");
		dataSet.put("E", "F");
		dataSet.put("F", "F");
		System.out.println(noOfEmpUnderManager(dataSet));
	}

	private static Map<String, Integer> noOfEmpUnderManager(Map<String, String> dataSet) {
		Map<String, List<String>> mgrMap = new HashMap<>();

		for (String emp : dataSet.keySet()) {
			String mgr = dataSet.get(emp);
			if (!mgr.equals(emp)) {
				if (mgrMap.containsKey(mgr))
					mgrMap.get(mgr).add(emp);
				else
					mgrMap.put(mgr, new ArrayList<>(Arrays.asList(emp)));
			}
		}
		Map<String, Integer> empCount = new HashMap<>();
		for (String mgr : dataSet.keySet()) {
			empCount.put(mgr, countEmployees(mgr, mgrMap));
			System.out.println(empCount);
			System.out.println(mgrMap);
		}

		return empCount;
	}

	private static int countEmployees(String mgr, Map<String, List<String>> mgrMap) {
		if (!mgrMap.containsKey(mgr))
			return 0;

		List<String> directReportEmp = mgrMap.get(mgr);
		int count = directReportEmp.size();
		for (String emp : directReportEmp)
			count += countEmployees(emp, mgrMap);

		return count;
	}
}
