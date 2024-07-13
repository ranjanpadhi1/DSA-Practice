package com.jsp.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class IsGraphBipartite {

	public static void main(String[] args) {
		ArrayList<Edge>[] graph1 = createGraph1();
		System.out.println(isBipartite(graph1));
		ArrayList<Edge>[] graph2 = createGraph2();
		System.out.println(isBipartite(graph2));
	}

	private static boolean isBipartite(ArrayList<Edge>[] graph) {
		int[] visitedLvl = new int[graph.length];
		Arrays.fill(visitedLvl, -1);

		for (int v = 0; v < graph.length; v++) {
			if (visitedLvl[v] == -1) {
				if (!isCompBipartite(graph, v, visitedLvl))
					return false;
			}
		}
		return true;
	}

	private static boolean isCompBipartite(ArrayList<Edge>[] graph, int v, int[] visitedLvl) {
		Queue<Pair> queue = new ArrayDeque<>();
		queue.add(new Pair(v, 0, v + ""));

		while (!queue.isEmpty()) {
			Pair peek = queue.remove();
			if (visitedLvl[peek.v] != -1) {// visited
				if (visitedLvl[peek.v] != peek.level)
					return false;
			} else
				visitedLvl[peek.v] = peek.level;

			for (Edge edge : graph[peek.v]) {
				if (visitedLvl[edge.v2] == -1)
					queue.add(new Pair(edge.v2, peek.level + 1, peek.path + edge.v2));
			}
		}
		return true;
	}

	static class Pair {
		int v;
		int level;
		String path;

		public Pair(int v, int level, String path) {
			super();
			this.v = v;
			this.level = level;
			this.path = path;
		}

		@Override
		public String toString() {
			return v + "";
		}

	}

	@SuppressWarnings("unchecked")
	private static ArrayList<Edge>[] createGraph1() {
		ArrayList<Edge>[] graph = new ArrayList[4];
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}

		graph[0].add(new Edge(0, 1));
		graph[0].add(new Edge(0, 3));

		graph[1].add(new Edge(1, 0));
		graph[1].add(new Edge(1, 2));

		graph[2].add(new Edge(2, 1));
		graph[2].add(new Edge(2, 3));

		graph[3].add(new Edge(3, 0));
		graph[3].add(new Edge(3, 2));

		return graph;
	}

	@SuppressWarnings("unchecked")
	private static ArrayList<Edge>[] createGraph2() {
		ArrayList<Edge>[] graph = new ArrayList[5];
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}

		graph[0].add(new Edge(0, 1));
		graph[0].add(new Edge(0, 4));

		graph[1].add(new Edge(1, 0));
		graph[1].add(new Edge(1, 2));

		graph[2].add(new Edge(2, 1));
		graph[2].add(new Edge(2, 3));

		graph[3].add(new Edge(3, 4));
		graph[3].add(new Edge(3, 2));

		graph[4].add(new Edge(4, 3));
		graph[4].add(new Edge(4, 0));

		return graph;
	}

	static class Edge {
		int v1;
		int v2;

		public Edge(int v1, int v2) {
			super();
			this.v1 = v1;
			this.v2 = v2;
		}

		@Override
		public String toString() {
			return v1 + "@" + v2;
		}
	}

}
