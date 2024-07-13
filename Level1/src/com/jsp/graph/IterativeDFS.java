package com.jsp.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class IterativeDFS {
	public static void main(String[] args) {
		ArrayList<Edge>[] graph = createGraph();
		System.out.println(Arrays.toString(graph));

		performDfs(graph, 0);
	}

	static class Pair {
		int vertex;
		String path;

		public Pair(int vertex, String path) {
			this.vertex = vertex;
			this.path = path;
		}
	}

	private static void performDfs(ArrayList<Edge>[] graph, int src) {
		boolean[] visited = new boolean[graph.length];
		Stack<Pair> stack = new Stack<>();
		stack.push(new Pair(src, src + ""));

		while (!stack.isEmpty()) {
			Pair pair = stack.pop();

			if (!visited[pair.vertex]) {
				System.out.print(pair.vertex + " ");
				visited[pair.vertex] = true;
			}

			for (Edge edge : graph[pair.vertex]) {
				if (!visited[edge.v2])
					stack.push(new Pair(edge.v2, pair.path + edge.v2));
			}
		}
	}

	@SuppressWarnings("unchecked")
	private static ArrayList<Edge>[] createGraph() {

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
