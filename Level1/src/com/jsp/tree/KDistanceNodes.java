package com.jsp.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class KDistanceNodes {

	public static void main(String[] args) {
		Integer[] arr = { 10, 20, 40, 80, null, null, null, 50, 90, null, null, 100, null, null, 30, 60, null, null,
				70 };
		Tree tree = new Tree(arr);
		tree.printLevelOrder();
		System.out.println(tree.kDistanceNodes(20, 2));

		Integer[] arr2 = { 10, 20, 40, 80, null, null, null, 50, 90, 110, null, null, null, 100, null, null, 30, 60,
				null, null, 70 };
		Tree tree2 = new Tree(arr2);
		tree2.printLevelOrder();
		System.out.println(tree2.kDistanceNodes(50, 2));
	}

	static class Tree {

		public List<Integer> kDistanceNodes(int node, int k) {
			List<Node> path = new ArrayList<>();
			nodeToRootPath(root, node, path);

			List<Integer> kDistanceNodes = new ArrayList<>();
			for (int i = 0; i < path.size(); i++) {
				kDistanceNodes(path.get(i), 0, k - i, i == 0 ? null : path.get(i - 1), kDistanceNodes);
			}
			return kDistanceNodes;
		}

		private void kDistanceNodes(Node root, int level, int k, Node blocker, List<Integer> kDistanceNodes) {
			if (root != null && root != blocker) {
				if (level == k)
					kDistanceNodes.add(root.data);
				kDistanceNodes(root.left, level + 1, k, blocker, kDistanceNodes);
				kDistanceNodes(root.right, level + 1, k, blocker, kDistanceNodes);
			}
		}

		private boolean nodeToRootPath(Node root, int node, List<Node> path) {
			if (root != null) {
				if (root.data == node || nodeToRootPath(root.left, node, path)
						|| nodeToRootPath(root.right, node, path)) {
					path.add(root);
					return true;
				}
			}
			return false;
		}

		static class Node {
			int data;
			Node left;
			Node right;

			public Node(int data) {
				this.data = data;
			}

			@Override
			public String toString() {
				return data + "";
			}
		}

		static class Pair {
			Node node;
			int state;

			public Pair(Node node, int state) {
				this.node = node;
				this.state = state;
			}
		}

		Node root;

		public Tree(Integer[] arr) {
			constructTree(arr);
		}

		private void constructTree(Integer[] arr) {
			Stack<Pair> stack = new Stack<>();

			for (int i = 0; i < arr.length; i++) {
				Node newNode = arr[i] != null ? new Node(arr[i]) : null;
				if (root != null) {
					Pair pair = stack.peek();
					if (pair.state == 1) {
						pair.node.left = newNode;
						pair.state++;
					} else {
						pair.node.right = newNode;
						stack.pop();
					}
				} else
					root = newNode;

				if (newNode != null)
					stack.push(new Pair(newNode, 1));
			}
		}

		public void printLevelOrder() {
			Queue<Node> queue = new ArrayDeque<>();
			queue.add(root);

			while (!queue.isEmpty()) {
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					Node node = queue.remove();
					System.out.print(node.data + " ");

					if (node.left != null)
						queue.add(node.left);

					if (node.right != null)
						queue.add(node.right);
				}
				System.out.println();
			}
		}
	}
}
