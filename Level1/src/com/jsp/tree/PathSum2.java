package com.jsp.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class PathSum2 {

	public static void main(String[] args) {
		Integer[] arr = { 3, 5, 9, null, null, 1, 6, null, null, null, 8, 2, null, 7, null, null, 4 };
		Tree tree = new Tree(arr);
		tree.printLevelOrder();

		System.out.println(tree.targetedPaths(15));
	}

	static class Tree {

		public List<List<Integer>> targetedPaths(int target) {
			List<List<Integer>> paths = new ArrayList<>();
			targetedSumPaths(root, target, new ArrayList<>(), paths);
			return paths;
		}

		private void targetedSumPaths(Node root, int target, List<Integer> path, List<List<Integer>> paths) {
			if (root != null) {
				path = new ArrayList<>(path);
				path.add(root.data);
				target -= root.data;

				if (root.left == null && root.right == null && target == 0)
					paths.add(path);

				targetedSumPaths(root.left, target, path, paths);
				targetedSumPaths(root.right, target, path, paths);
			}
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
