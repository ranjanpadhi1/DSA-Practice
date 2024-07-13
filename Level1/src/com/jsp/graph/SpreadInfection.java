package com.jsp.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class SpreadInfection {
	public static void main(String[] args) {
		ArrayList<Edge>[] graph = createGraph();
		System.out.println(Arrays.toString(graph));
		System.out.println(totalInfectedPersons(graph, 6, 2));
	}

	private static int totalInfectedPersons(ArrayList<Edge>[] graph, int src, int time) {
		boolean[] infected = new boolean[graph.length];
		Queue<Pair> q = new ArrayDeque<>();
		q.add(new Pair(src, 0));

		int count = 0;
		while (!q.isEmpty()) {
			Pair rem = q.remove();
			// Count till the given time
			if (rem.time > time)
				break;
			// If person is already infected, chain is counted
			if (infected[rem.vertex])
				continue;
			// If not infected, it will infect, inc count
			infected[rem.vertex] = true;
			count++;
			// Ask all connected persons
			for (Edge edge : graph[rem.vertex]) {
				if (!infected[edge.v2])
					q.add(new Pair(edge.v2, rem.time + 1));
			}
		}
		return count;
	}

	static class Pair {
		int vertex;
		int time;

		public Pair(int vertex, int time) {
			this.vertex = vertex;
			this.time = time;
		}
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

		graph[3].add(new Edge(3, 0));
		graph[3].add(new Edge(3, 2));
		graph[3].add(new Edge(3, 4));

		graph[4].add(new Edge(4, 3));
		graph[4].add(new Edge(4, 5));
		graph[4].add(new Edge(4, 6));

		graph[5].add(new Edge(5, 4));
		graph[5].add(new Edge(5, 6));

		graph[6].add(new Edge(6, 4));
		graph[6].add(new Edge(6, 5));

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
			return v1 + "-" + v2;
		}
	}

}
