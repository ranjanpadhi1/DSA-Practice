package com.jsp.bst;

import java.util.ArrayDeque;
import java.util.Queue;

public class RemoveNodeOfBST {

	public static void main(String[] args) {
		Integer[] arr = { 12, 25, 30, 37, 40, 50, 60, 62, 70, 75, 87 };
		Tree tree = new Tree(arr);
		tree.printInorder(tree.root);
		System.out.println();
		tree.printLevelOrder(tree.root);

		tree.remove(tree.root, 40);
		tree.remove(tree.root, 37);
		tree.remove(tree.root, 75);

		System.out.println();
		tree.printInorder(tree.root);
		System.out.println();
		tree.printLevelOrder(tree.root);
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

		public Node remove(Node root, int val) {
			if (root == null)
				return null;
			if (root.data < val)
				root.right = remove(root.right, val);

			else if (root.data > val)
				root.left = remove(root.left, val);

			else {
				if (root.left == null && root.right == null) {
					return null;

				} else if (root.left == null && root.right == null) {
					int max = max(root.left);
					root.data = max;
					remove(root, max);
					return root;
				} else
					return root.left == null ? root.right : root.left;
			}
			return root;
		}

		private int max(Node root) {
			if (root.right != null)
				return max(root.right);
			return root.data;
		}

		public Node add(Node root, int val) {
			if (root == null)
				return new Node(val);

			if (root.data < val)
				root.right = add(root.right, val);
			else
				root.left = add(root.left, val);

			return root;
		}

		public boolean find(Node node, int value) {
			if (node == null)
				return false;

			if (node.data < value)
				return find(node.right, value);
			else if (node.data > value)
				return find(node.left, value);
			else
				return true;
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
