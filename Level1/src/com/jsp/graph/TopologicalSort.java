package com.jsp.graph;

import java.util.ArrayList;
import java.util.Stack;

import com.jsp.graph.IsGraphCyclic.Edge;

public class TopologicalSort {
	public static void main(String[] args) {
		ArrayList<Edge>[] graph = createGraph();
		topologicalSort(graph);
	}

	private static void topologicalSort(ArrayList<Edge>[] graph) {
		boolean[] visited = new boolean[graph.length];
		Stack<Integer> result = new Stack<>();
		for (int v = 0; v < visited.length; v++) {
			if (!visited[v])
				dfs(graph, v, visited, result);
		}
		System.out.println(result);
	}

	private static void dfs(ArrayList<Edge>[] graph, int v, boolean[] visited, Stack<Integer> rs) {

		visited[v] = true;
		for (Edge edge : graph[v]) {
			if (!visited[edge.v2])
				dfs(graph, edge.v2, visited, rs);
		}
		rs.add(v);
	}

	@SuppressWarnings("unchecked")
	private static ArrayList<Edge>[] createGraph() {

		ArrayList<Edge>[] graph = new ArrayList[7];

		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}

		graph[0].add(new Edge(0, 1));
		graph[0].add(new Edge(0, 3));

		graph[1].add(new Edge(1, 2));

		graph[2].add(new Edge(2, 3));

//		graph[3].add(new Edge(3, 4));

		graph[4].add(new Edge(4, 3));
		graph[4].add(new Edge(4, 5));
		graph[4].add(new Edge(4, 6));

		graph[5].add(new Edge(5, 6, 3));

		return graph;
	}
}
