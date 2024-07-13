package com.ds.algo.generictree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class DistanceOfTwoNodes {
	public static void main(String[] args) {
		int[] arr = new int[] { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100,
				-1, -1, -1 };

		Tree tree = new Tree(arr);
		tree.printLevels(tree.root);
		System.out.println("-------------");
		System.out.println("110 120 -> " + tree.distance(tree.root, 110, 120));
		System.out.println("70 110 -> " + tree.distance(tree.root, 70, 110));
		System.out.println("50 70 -> " + tree.distance(tree.root, 50, 70));
	}

	static class Tree {

		public int distance(Node root, int val1, int val2) {
			int distance = 0;
			if (val1 == val2)
				return distance;

			List<Integer> val1Paths = nodeToRootPaths(root, val1);
			List<Integer> val2Paths = nodeToRootPaths(root, val2);
			int i = val1Paths.size(), j = val2Paths.size();
			while (--i >= 0 && --j >= 0 && val1Paths.get(i) == val2Paths.get(j)) {
			}
			i++;
			j++;
			return i + j;
		}

		private List<Integer> nodeToRootPaths(Node root, int val) {
			if (root.data == val) {
				List<Integer> path = new ArrayList<>();
				path.add(val);
				return path;
			}

			for (Node child : root.children) {
				List<Integer> childPaths = nodeToRootPaths(child, val);
				if (!childPaths.isEmpty()) {
					childPaths.add(root.data);
					return childPaths;
				}
			}
			return new ArrayList<>();
		}

		static class Node {
			int data;
			ArrayList<Node> children = new ArrayList<>();

			public Node(int data) {
				this.data = data;
			}
		}

		Node root;

		public Tree(int[] arr) {
			Stack<Node> stack = new Stack<>();
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == -1)
					stack.pop();
				else {
					Node newNode = new Node(arr[i]);
					if (stack.size() > 0)
						stack.peek().children.add(newNode);
					else
						root = newNode;
					stack.push(newNode);
				}
			}
		}

		public void printLevels(Node root) {
			Queue<Node> queue = new ArrayDeque<>();
			Queue<Node> childQueue = new ArrayDeque<>();
			queue.add(root);

			while (!queue.isEmpty()) {
				root = queue.remove();
				System.out.print(root.data + " ");
				for (Node child : root.children)
					childQueue.add(child);

				if (queue.isEmpty()) {
					queue = childQueue;
					childQueue = new ArrayDeque<>();
					System.out.println();
				}
			}
		}
	}
}
