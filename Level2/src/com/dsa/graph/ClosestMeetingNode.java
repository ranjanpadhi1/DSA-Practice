package com.dsa.graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class ClosestMeetingNode {
	public static void main(String[] args) {
		System.out.println(closestMeetingNode(new int[] { 2, 2, 3, -1 }, 0, 1));
	}

	public static int closestMeetingNode(int[] edges, int node1, int node2) {
		boolean visited[] = new boolean[edges.length];

		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(node1);
		queue.add(node2);

		while (!queue.isEmpty()) {
			int v = queue.remove();
			if (visited[v])
				return v;
			visited[v] = true;

			if (edges[v] == -1)
				continue;

			if (!visited[edges[v]])
				queue.add(edges[v]);
		}
		return -1;
	}
}
