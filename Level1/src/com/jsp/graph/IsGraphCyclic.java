package com.jsp.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class IsGraphCyclic {
	public static void main(String[] args) {
		ArrayList<Edge>[] graph1 = createGraph1();
		System.out.println(isCyclic(graph1));

		ArrayList<Edge>[] graph2 = createGraph2();
		System.out.println(isCyclic(graph2));

		ArrayList<Edge>[] graph3 = createGraph3();
		System.out.println(isCyclic(graph3));
	}

	private static boolean isCyclic(ArrayList<Edge>[] graph) {
		boolean[] visited = new boolean[graph.length];
		for (int v = 0; v < graph.length; v++) {
			if (!visited[v]) {
				if (hasCycle(graph, v, visited))
					return true;
			}
		}
		return false;
	}

	private static boolean hasCycle(ArrayList<Edge>[] graph, int v, boolean[] visited) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(v);

		while (!queue.isEmpty()) {
			int vtx = queue.remove();

			if (visited[vtx])
				return true;

			visited[vtx] = true;

			for (Edge edge : graph[v]) {
				if (!visited[edge.v2])
					queue.add(edge.v2);
			}
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	private static ArrayList<Edge>[] createGraph1() {

		ArrayList<Edge>[] graph = new ArrayList[7];

		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}

		graph[0].add(new Edge(0, 1, 10));
		graph[0].add(new Edge(0, 3, 40));

		graph[1].add(new Edge(1, 0, 10));
		graph[1].add(new Edge(1, 2, 10));

		graph[2].add(new Edge(2, 1, 10));
		graph[2].add(new Edge(2, 3, 10));

		graph[3].add(new Edge(3, 0, 40));
		graph[3].add(new Edge(3, 2, 10));
		graph[3].add(new Edge(3, 4, 2));

		graph[4].add(new Edge(4, 3, 2));
		graph[4].add(new Edge(4, 5, 3));
		graph[4].add(new Edge(4, 6, 8));

		graph[5].add(new Edge(5, 4, 3));
		graph[5].add(new Edge(5, 6, 3));

		graph[6].add(new Edge(6, 5, 3));
		graph[6].add(new Edge(6, 4, 8));

		return graph;
	}

	@SuppressWarnings("unchecked")
	private static ArrayList<Edge>[] createGraph2() {

		ArrayList<Edge>[] graph = new ArrayList[7];

		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}

		graph[0].add(new Edge(0, 1));

		graph[1].add(new Edge(1, 0));

		graph[2].add(new Edge(2, 3));

		graph[3].add(new Edge(3, 2));

		graph[4].add(new Edge(4, 5));
		graph[4].add(new Edge(4, 6));

		graph[5].add(new Edge(5, 4));
		graph[5].add(new Edge(5, 6));

		graph[6].add(new Edge(6, 4));
		graph[6].add(new Edge(6, 5));

		return graph;
	}

	@SuppressWarnings("unchecked")
	private static ArrayList<Edge>[] createGraph3() {

		ArrayList<Edge>[] graph = new ArrayList[7];

		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}

		graph[0].add(new Edge(0, 1));

		graph[1].add(new Edge(1, 0));
		graph[1].add(new Edge(1, 2));

		graph[2].add(new Edge(2, 1));
		graph[2].add(new Edge(2, 3));

		graph[3].add(new Edge(3, 2));
		graph[3].add(new Edge(3, 4));

		graph[4].add(new Edge(4, 3));
		graph[4].add(new Edge(4, 5));

		graph[5].add(new Edge(5, 4));
		graph[5].add(new Edge(5, 6));

		graph[6].add(new Edge(6, 5));

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
