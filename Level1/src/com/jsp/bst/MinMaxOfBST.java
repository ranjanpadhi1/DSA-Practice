package com.jsp.bst;

import java.util.ArrayDeque;
import java.util.Queue;

public class MinMaxOfBST {

	public static void main(String[] args) {
		Integer[] arr = { 12, 25, 37, 50, 62, 75, 87 };
		Tree tree = new Tree(arr);
		tree.printInorder(tree.root);
		System.out.println();
		tree.printLevelOrder(tree.root);
		System.out.println(tree.min(tree.root));
		System.out.println(tree.max(tree.root));
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

		public int max(Node node) {
			if (node.right != null)
				return max(node.right);
			else
				return node.data;
		}

		public int min(Node node) {
			if (node.left != null)
				return min(node.left);
			else
				return node.data;
		}

		private void constructTree(Integer[] arr) {
			root = construct(arr, 0, arr.length - 1);
		}

		private Node construct(Integer[] arr, int lo, int hi) {
			if (lo <= hi) {
				int mid = (lo + hi) / 2;
				Node newNode = new Node(arr[mid]);
				newNode.left = construct(arr, lo, mid - 1);
				newNode.right = construct(arr, mid + 1, hi);
				return newNode;
			}
			return null;
		}

		public void printLevelOrder(Node root) {
			if (root == null)
				return;
			Queue<Node> queue = new ArrayDeque<>();
			queue.add(root);

			while (!queue.isEmpty()) {
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					root = queue.remove();
					System.out.print(root.data + " ");

					if (root.left != null)
						queue.add(root.left);

					if (root.right != null)
						queue.add(root.right);
				}
				System.out.println();
			}
		}

		public void printInorder(Node root) {
			if (root == null) {
				return;
			}
			printInorder(root.left);
			System.out.print(root.data + " ");
			printInorder(root.right);
		}

	}
}
