package com.jsp.bst;

import java.util.ArrayDeque;
import java.util.Queue;

public class RangeSumBST {

	public static void main(String[] args) {
		Integer[] arr = { 12, 25, 37, 50, 62, 75, 87 };
		Tree tree = new Tree(arr);
		tree.printInorder(tree.root);
		System.out.println();
		tree.printLevelOrder(tree.root);
		System.out.println(tree.rangeSum(30, 80));
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

		int sum;

		public int rangeSum(int lo, int hi) {
			sum = 0;
			rangeSum(root, lo, hi);
			return sum;
		}

		private void rangeSum(Node root, int lo, int hi) {
			if (root != null) {
				if (root.data < lo)
					rangeSum(root.right, lo, hi);
				else if (root.data > hi)
					rangeSum(root.left, lo, hi);
				else {
					rangeSum(root.left, lo, hi);
					sum += root.data;
					rangeSum(root.right, lo, hi);
				}
			}
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
