package com.dsa.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ReconstructItinerary {
	public static void main(String[] args) {
		List<List<String>> tickets = new ArrayList<>();
		tickets.add(List.of("CHN", "BAN"));
		tickets.add(List.of("BOM", "DEL"));
		tickets.add(List.of("GOA", "CHN"));
		tickets.add(List.of("DEL", "GOA"));
		System.out.println(findItinerary(tickets));
	}

	public static List<String> findItinerary(List<List<String>> tickets) {
		Map<String, String> map = new HashMap<>();
		for (List<String> ticket : tickets)
			map.put(ticket.get(0), ticket.get(1));
		String src = findSource(map);
		List<String> itr = new LinkedList<>();
		prepareItinerary(src, map, itr);
		return itr;
	}

	private static void prepareItinerary(String src, Map<String, String> map, List<String> itr) {
		if (!map.containsKey(src)) {
			itr.add(src);
			return;
		}
		itr.add(src);
		prepareItinerary(map.get(src), map, itr);
	}

	private static String findSource(Map<String, String> map) {
		for (String src : map.keySet()) {
			if (!map.containsValue(src))
				return src;
		}
		return "";
	}
}
