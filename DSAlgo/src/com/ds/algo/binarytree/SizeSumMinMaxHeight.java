package com.ds.algo.binarytree;

import java.util.Stack;

public class SizeSumMinMaxHeight {

	public static void main(String[] args) {
		Integer arr[] = new Integer[] { 1, 2, null, null, 3, 4, null, null, 5 };
		BinaryTree tree = new BinaryTree(arr);
		tree.print(tree.root);
		System.out.println("\nSize : " + tree.size(tree.root));
		System.out.println("Sum : " + tree.sum(tree.root));
		System.out.println("Min : " + tree.min(tree.root));
		System.out.println("Max : " + tree.max(tree.root));
		System.out.println("Height : " + tree.height(tree.root));
	}

	private static class BinaryTree {

		public int size(Node root) {
			if (root == null)
				return 0;
			return 1 + size(root.left) + size(root.right);
		}

		public int sum(Node root) {
			if (root == null)
				return 0;
			return root.val + sum(root.left) + sum(root.right);
		}

		public int min(Node root) {
			if (root == null)
				return Integer.MAX_VALUE;
			int minLeft = min(root.left);
			int minRight = min(root.right);
			return Math.min(root.val, Math.min(minLeft, minRight));
		}

		public int max(Node root) {
			if (root == null)
				return Integer.MIN_VALUE;
			int minLeft = max(root.left);
			int minRight = max(root.right);
			return Math.max(root.val, Math.max(minLeft, minRight));
		}

		public int height(Node root) {
			if (root == null)
				return 0;
			return 1 + Math.max(height(root.left), height(root.right));
		}

		static class Node {
			Integer val;
			Node left;
			Node right;

			public Node(Integer val) {
				this.val = val;
			}

			@Override
			public String toString() {
				return val + "";
			}
		}

		Node root;

		class Pair {
			Node node;
			int state;

			public Pair(Node node, int state) {
				this.node = node;
				this.state = state;
			}
		}

		public BinaryTree(Integer[] arr) {
			Stack<Pair> stack = new Stack<>();
			for (int i = 0; i < arr.length; i++) {
				Node newNode = arr[i] != null ? new Node(arr[i]) : null;
				if (!stack.isEmpty() && stack.peek().state == 1) {
					stack.peek().node.left = newNode;
					stack.peek().state++;
				} else if (!stack.isEmpty() && stack.peek().state == 2) {
					stack.peek().node.right = newNode;
					stack.pop();
				} else if (stack.isEmpty()) {
					root = newNode;
				}

				if (newNode != null)
					stack.push(new Pair(newNode, 1));
			}
		}

		public void print(Node root) {
			if (root == null)
				return;
			System.out.print(root.val + " ");
			print(root.left);
			print(root.right);
		}
	}
}
