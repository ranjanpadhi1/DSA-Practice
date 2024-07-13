package com.jsp.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConnectedComponenets {
	public static void main(String[] args) {
		ArrayList<Edge>[] graph = createGraph();
		System.out.println(Arrays.toString(graph));
		System.out.println(allConnectedComponents(graph));
	}

	private static List<List<Integer>> allConnectedComponents(ArrayList<Edge>[] graph) {
		List<List<Integer>> components = new ArrayList<>();

		boolean[] visited = new boolean[graph.length];

		for (int vertex = 0; vertex < visited.length; vertex++) {
			if (!visited[vertex]) {
				List<Integer> comp = new ArrayList<>();
				findComponent(graph, vertex, visited, comp);
				components.add(comp);
			}
		}
		return components;
	}

	private static void findComponent(ArrayList<Edge>[] graph, int vertex, boolean[] visited, List<Integer> comp) {
		visited[vertex] = true;
		comp.add(vertex);

		for (Edge edge : graph[vertex]) {
			if (!visited[edge.v2]) {
				findComponent(graph, edge.v2, visited, comp);
			}
		}
	}

	@SuppressWarnings("unchecked")
	private static ArrayList<Edge>[] createGraph() {

		ArrayList<Edge>[] graph = new ArrayList[9];

		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}

		graph[0].add(new Edge(0, 1, 0));

		graph[1].add(new Edge(1, 0, 0));

		graph[2].add(new Edge(2, 3, 0));
		graph[2].add(new Edge(2, 5, 0));

		graph[3].add(new Edge(3, 4, 0));
		graph[3].add(new Edge(3, 2, 0));

		graph[4].add(new Edge(4, 5, 0));
		graph[4].add(new Edge(4, 3, 0));

		graph[5].add(new Edge(5, 2, 0));
		graph[5].add(new Edge(5, 4, 0));

		graph[6].add(new Edge(6, 7, 0));
		graph[6].add(new Edge(6, 8, 0));

		graph[7].add(new Edge(7, 8, 0));
		graph[7].add(new Edge(7, 6, 0));

		graph[8].add(new Edge(8, 7, 0));
		graph[8].add(new Edge(8, 6, 0));

		return graph;
	}

	static class Edge {
		int v1;
		int v2;
		int weight;

		public Edge(int v1, int v2, int weight) {
			super();
			this.v1 = v1;
			this.v2 = v2;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return v1 + "-" + v2 + "@" + weight;
		}
	}

}
