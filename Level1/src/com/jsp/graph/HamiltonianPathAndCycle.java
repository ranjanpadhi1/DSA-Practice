package com.jsp.graph;

import java.util.ArrayList;
import java.util.HashSet;

public class HamiltonianPathAndCycle {

	private static ArrayList<Edge>[] graph;
	private static HashSet<Integer> visited;

	public static void main(String[] args) {
		graph = createGraph();
		visited = new HashSet<>();
		hamiltonianPath(0, 0, "");
	}

	private static void hamiltonianPath(int src, int v, String path) {
		if (visited.size() == graph.length - 1) {
			path += v;
			// Visited all the vertices, check if last vertex point to the source
			boolean closingEdgeFound = false;
			for (int i = 0; i < graph[v].size(); i++) {
				if (graph[v].get(i).v2 == src) {
					closingEdgeFound = true;
					break;
				}
			}
			if (closingEdgeFound)
				System.out.println("Hamiltonnial Cycle - " + path);
			else
				System.out.println("Hamiltonnial Path - " + path);
			return;
		}

		visited.add(v);
		for (Edge edge : graph[v]) {
			if (!visited.contains(edge.v2))
				hamiltonianPath(src, edge.v2, path + v);
		}
		visited.remove(v);
	}

	@SuppressWarnings("unchecked")
	private static ArrayList<Edge>[] createGraph() {

		ArrayList<Edge>[] graph = new ArrayList[7];

		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}

		graph[0].add(new Edge(0, 1));
		graph[0].add(new Edge(0, 3));

		graph[1].add(new Edge(1, 0));
		graph[1].add(new Edge(1, 2));

		graph[2].add(new Edge(2, 1));
		graph[2].add(new Edge(2, 3));
		graph[2].add(new Edge(2, 5));

		graph[3].add(new Edge(3, 0));
		graph[3].add(new Edge(3, 2));
		graph[3].add(new Edge(3, 4));

		graph[4].add(new Edge(4, 3));
		graph[4].add(new Edge(4, 5));
		graph[4].add(new Edge(4, 6));

		graph[5].add(new Edge(5, 2));
		graph[5].add(new Edge(5, 4));
		graph[5].add(new Edge(5, 6));

		graph[6].add(new Edge(6, 5));
		graph[6].add(new Edge(6, 4));

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

		public Edge(int v1, int v2) {
			super();
			this.v1 = v1;
			this.v2 = v2;
		}

		@Override
		public String toString() {
			return v1 + "-" + v2 + "@" + weight;
		}
	}

}
