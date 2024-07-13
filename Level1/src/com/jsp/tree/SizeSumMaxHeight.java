package com.jsp.tree;

import java.util.Stack;

public class SizeSumMaxHeight {

	public static void main(String[] args) {
		Integer[] arr = { 10, 20, 40, null, null, 50, 80, null, null, null, 30, 60, null, 90, null, null, 70 };
		Tree tree = new Tree(arr);
		System.out.println("Size: " + tree.size(tree.root));
		System.out.println("Sum: " + tree.sum(tree.root));
		System.out.println("Max: " + tree.max(tree.root));
		System.out.println("Height: " + tree.height(tree.root, 0));
	}

	static class Tree {
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

		public int size(Node root) {
			if (root == null)
				return 0;
			return 1 + size(root.left) + size(root.right);
		}

		public int sum(Node root) {
			if (root == null)
				return 0;
			return root.data + sum(root.left) + sum(root.right);
		}

		public int max(Node root) {
			if (root == null)
				return -1;
			return Math.max(root.data, Math.max(max(root.left), max(root.right)));
		}

		public int height(Node root, int level) {
			if (root == null)
				return 0;
			return 1 + Math.max(height(root.left, level + 1), height(root.right, level + 1));
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
	}
}
