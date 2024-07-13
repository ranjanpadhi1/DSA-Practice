package com.jsp.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestPath {
	public static void main(String[] args) {
		ArrayList<Edge>[] graph = createGraph();
		System.out.println(Arrays.toString(graph));

		findKthShortestPath(graph, 0, 6, 2);
	}

	static class Pair implements Comparable<Pair> {
		int weight;
		String path;

		public Pair(int weight, String path) {
			super();
			this.weight = weight;
			this.path = path;
		}

		@Override
		public int compareTo(Pair o) {
			return Integer.compare(weight, o.weight);
		}

		@Override
		public String toString() {
			return path + " @ " + weight;
		}
	}

	static PriorityQueue<Pair> pq;

	private static void findKthShortestPath(ArrayList<Edge>[] graph, int source, int dest, int k) {
		pq = new PriorityQueue<>(k);
		kthLargestPaths(graph, source, dest, new boolean[graph.length], "", 0, k);
		System.out.println(k + " largest path : " + pq.peek());
	}

	private static void kthLargestPaths(ArrayList<Edge>[] graph, int source, int dest, boolean[] visited, String path,
			int pathWt, int k) {
		if (source == dest) {
			path += source;

			if (pq.size() < k)
				pq.add(new Pair(pathWt, path));
			else if (pq.peek().weight < pathWt) {
				pq.poll();
				pq.add(new Pair(pathWt, path));
			}
			return;
		}
		visited[source] = true;
		for (Edge edge : graph[source]) {
			if (!visited[edge.v2])
				kthLargestPaths(graph, edge.v2, dest, visited, path + source, pathWt + edge.weight, k);
		}
		visited[source] = false;
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
