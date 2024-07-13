package com.jsp.graph;

import java.util.ArrayList;
import java.util.List;

import com.jsp.graph.ConnectedComponenets.Edge;

public class FriendsPairing {

	public static void main(String[] args) {
		System.out.println(pairFriends(7, new String[] { "01", "23", "45", "56", "46" }));
	}

	private static List<String> pairFriends(int n, String[] relations) {

		ArrayList<Edge>[] graph = createGraph(n, relations);
		List<List<Integer>> groups = findConnectedComponents(graph);

		List<String> pairs = new ArrayList<>();
		for (int i = 0; i < groups.size(); i++) {
			for (int j = i + 1; j < groups.size(); j++) {
				preparePair(groups.get(i), groups.get(j), pairs);
			}
		}
		return pairs;
	}

	private static void preparePair(List<Integer> group1, List<Integer> group2, List<String> pairs) {
		for (Integer f1 : group1) {
			for (Integer f2 : group2) {
				pairs.add(f1 + "" + f2);
			}
		}
	}

	private static List<List<Integer>> findConnectedComponents(ArrayList<Edge>[] graph) {
		List<List<Integer>> components = new ArrayList<>();

		boolean[] visited = new boolean[graph.length];
		for (int v = 0; v < graph.length; v++) {
			if (!visited[v]) {
				List<Integer> comp = new ArrayList<>();
				findComp(graph, v, visited, comp);
				components.add(comp);
			}
		}
		return components;
	}

	private static void findComp(ArrayList<Edge>[] graph, int v, boolean[] visited, List<Integer> comp) {
		visited[v] = true;
		comp.add(v);

		for (Edge edge : graph[v]) {
			if (!visited[edge.v2]) {
				findComp(graph, edge.v2, visited, comp);
			}
		}
	}

	@SuppressWarnings("unchecked")
	private static ArrayList<Edge>[] createGraph(int n, String[] relations) {
		ArrayList<Edge>[] graph = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<>();
		}

		for (String rel : relations) {
			String[] vertices = rel.split("");
			int v1 = Integer.parseInt(vertices[0]);
			int v2 = Integer.parseInt(vertices[1]);
			graph[v1].add(new Edge(v1, v2, 0));
			graph[v2].add(new Edge(v2, v1, 0));
		}

		return graph;
	}
}
