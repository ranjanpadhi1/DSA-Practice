package com.dsa.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class KruskalAndUnionFind {
	public static void main(String[] args) {
		ArrayList<Edge>[] graph = createGraph();
		System.out.println(Arrays.toString(graph));
		kruskalMstUsingUnionFind(graph);
	}

	static int[] parent, rank;

	private static void kruskalMstUsingUnionFind(ArrayList<Edge>[] graph) {
		parent = new int[graph.length];
		rank = new int[graph.length];

		// Prepare Disjoint Set
		for (int v = 0; v < parent.length; v++)
			parent[v] = v;

		Queue<Edge> queue = new PriorityQueue<>((a, b) -> a.weight - b.weight);
		for (List<Edge> edges : graph) {
			for (Edge edge : edges)
				queue.add(edge);
		}

		while (!queue.isEmpty()) {
			Edge edge = queue.remove();
			int p1 = find(edge.v1);
			int p2 = find(edge.v2);
			if (p1 != p2) {
				System.out.println(edge);
				union(p1, p2);
			}
		}
		System.out.println(Arrays.toString(rank));
		System.out.println(Arrays.toString(parent));
	}

	private static int find(int v) {
		if (v == parent[v])
			return v;
		int p = find(parent[v]);
		parent[v] = p; // Path Compression
		return p;
	}

	private static void union(int p1, int p2) {
		if (rank[p1] > rank[p2])
			parent[p2] = p1;
		else if (rank[p1] < rank[p2])
			parent[p1] = p2;
		else { // Union p1 and p2
			parent[p2] = p1;
			rank[p1]++; // Increment rank
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
