package com.jsp.tree;

import java.util.Stack;

public class ConstructTree {

	public static void main(String[] args) {
		Integer[] arr = { 10, 20, 40, null, null, 50, 80, null, null, null, 30, 60, null, 90, null, null, 70 };
		Tree tree = new Tree(arr);
		tree.printPreorder(tree.root);
		System.out.println();
		tree.printInorder(tree.root);
		System.out.println();
		tree.printPostorder(tree.root);
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

		public void printPreorder(Node root) {
			if (root == null) {
				return;
			}
			System.out.print(root.data + " ");
			printPreorder(root.left);
			printPreorder(root.right);
		}

		public void printInorder(Node root) {
			if (root == null) {
				return;
			}
			printInorder(root.left);
			System.out.print(root.data + " ");
			printInorder(root.right);
		}

		public void printPostorder(Node root) {
			if (root == null) {
				return;
			}
			printPostorder(root.left);
			printPostorder(root.right);
			System.out.print(root.data + " ");
		}
	}
}
