package com.jsp.tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class PathSum {

	public static void main(String[] args) {
		Integer[] arr = { 10, 20, 40, null, null, 50, 90, null, null, 100, null, null, 30, 60, null, null, 70 };
		Tree tree = new Tree(arr);
		tree.printLevelOrder();
		System.out.println(tree.targetSumPath(tree.root, 110, 0));
	}

	static class Tree {

		public boolean targetSumPath(Node root, int target, int sum) {
			if (root != null) {
				sum = sum + root.data;

				if (root.left == null && root.right == null && sum == target)
					return true;

				if (targetSumPath(root.left, target, sum) || targetSumPath(root.right, target, sum)) {
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