package com.jsp.tree;

import java.util.Stack;

public class KLevelNodes {

	public static void main(String[] args) {
		Integer[] arr = { 10, 20, 40, null, null, 50, 80, null, null, null, 30, 60, null, 90, null, null, 70 };
		Tree tree = new Tree(arr);

		tree.printKLevelNodes(tree.root, 2, 0);
	}

	static class Tree {

		public void printKLevelNodes(Node root, int k, int level) {
			if (root == null)
				return;

			if (level == k)
				System.out.print(root.data + " ");

			printKLevelNodes(root.left, k, level + 1);
			printKLevelNodes(root.right, k, level + 1);
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
	}
}
