package com.dsa.graph;

import java.util.ArrayList;
import java.util.List;

public class ArticulationPoints {
	public static void main(String[] args) {
		graph = createGraph();
		System.out.println(articulationPoints(graph));
	}

	static ArrayList<Edge>[] graph;
	static List<Integer> arPoints = new ArrayList<>();
	static Integer[] dis, low;

	private static List<Integer> articulationPoints(ArrayList<Edge>[] graph) {
		dis = new Integer[graph.length];
		low = new Integer[graph.length];

		for (int v = 0; v < graph.length; v++) {
			if (dis[v] == null)
				dfs(v, -1);
		}

		return arPoints;
	}

	static int time = 0;

	private static void dfs(int v, int parent) {
		dis[v] = low[v] = time++;

		int childVisited = 0;

		for (Edge edge : graph[v]) {
			int nbr = edge.v2;
			if (nbr == parent)
				continue;
			else if (dis[nbr] != null) // visited
				low[v] = Math.min(low[v], low[nbr]);
			else {
				childVisited++;
				dfs(nbr, v);

				low[v] = Math.min(low[v], low[nbr]);

				if (parent != -1 && low[nbr] >= dis[v])
					arPoints.add(v);
			}
		}
		if (parent == -1 && childVisited > 1)
			arPoints.add(v);
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
