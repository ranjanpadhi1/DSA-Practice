package com.jsp.graph;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

import com.jsp.graph.IsGraphCyclic.Edge;

public class MinimumSpanningTree {
	public static void main(String[] args) {
		ArrayList<Edge>[] graph = createGraph();

		minimumSpanningTree(graph);
	}

	static class Pair implements Comparable<Pair> {
		int src;
		int dst;
		int weight;

		public Pair(int v1, int v2, int weight) {
			super();
			this.src = v1;
			this.dst = v2;
			this.weight = weight;
		}

		@Override
		public int compareTo(Pair o) {
			return Integer.compare(weight, o.weight);
		}

		@Override
		public String toString() {
			return src + "-" + dst + " @ " + weight;
		}
	}

	private static void minimumSpanningTree(ArrayList<Edge>[] graph) {
		boolean[] visited = new boolean[graph.length];
		Queue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(-1, 0, 0));

		while (!pq.isEmpty()) {
			Pair pair = pq.remove();

			if (!visited[pair.dst]) {
				if (pair.src != -1)
					System.out.println(pair);
				visited[pair.dst] = true;
			}

			for (Edge edge : graph[pair.dst]) {
				if (!visited[edge.v2])
					pq.add(new Pair(pair.dst, edge.v2, edge.weight));
			}
		}
	}

	@SuppressWarnings("unchecked")
	private static ArrayList<Edge>[] createGraph() {

		ArrayList<Edge>[] graph = new ArrayList[9];

		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}

		graph[0].add(new Edge(0, 1, 1));
		graph[0].add(new Edge(0, 2, 6));
		graph[0].add(new Edge(0, 3, 5));

		graph[1].add(new Edge(1, 0, 1));
		graph[1].add(new Edge(1, 2, 6));

		graph[2].add(new Edge(2, 1, 6));
		graph[2].add(new Edge(2, 0, 6));
		graph[2].add(new Edge(2, 4, 7));
		graph[2].add(new Edge(2, 5, 3));

		graph[3].add(new Edge(3, 0, 5));
		graph[3].add(new Edge(3, 5, 2));
		graph[3].add(new Edge(3, 6, 10));

		graph[4].add(new Edge(4, 2, 7));
		graph[4].add(new Edge(4, 7, 12));

		graph[5].add(new Edge(5, 3, 2));
		graph[5].add(new Edge(5, 2, 3));
		graph[5].add(new Edge(5, 7, 8));

		graph[6].add(new Edge(6, 3, 10));
		graph[6].add(new Edge(6, 7, 7));
		graph[6].add(new Edge(6, 8, 3));

		graph[7].add(new Edge(7, 4, 12));
		graph[7].add(new Edge(7, 5, 8));
		graph[7].add(new Edge(7, 6, 7));
		graph[7].add(new Edge(7, 8, 8));

		graph[8].add(new Edge(8, 6, 3));
		graph[8].add(new Edge(8, 7, 8));

		return graph;
	}
}
