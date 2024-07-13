package com.jsp.tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class IsTreeBST {

	public static void main(String[] args) {
		Integer[] arr = { 50, 25, 12, null, null, 37, 30, null, null, 40, null, null, 75, 62, 60, null, null, 70, null,
				null, 87 };
		Tree tree = new Tree(arr);
		tree.printLevelOrder();
		System.out.println(tree.isBST());
		System.out.println(tree.isBST2());
	}

	static class Tree {
		int prev;

		public boolean isBST2() {
			prev = Integer.MIN_VALUE;
			return isBST2(root);
		}

		private boolean isBST2(Node root) {
			if (root != null) {

				if (!isBST2(root.left))
					return false;

				if (prev > root.data)
					return false;

				prev = root.data;

				if (!isBST2(root.right))
					return false;
			}
			return true;
		}

		static class BSTPair {
			int min;
			int max;
			boolean isBst;

			public BSTPair(int min, int max, boolean isBst) {
				this.min = min;
				this.max = max;
				this.isBst = isBst;
			}
		}

		public boolean isBST() {
			BSTPair tree = isBST(root);
			return tree.isBst;
		}

		private BSTPair isBST(Node root) {
			if (root == null)
				return new BSTPair(Integer.MAX_VALUE, Integer.MIN_VALUE, true);

			BSTPair left = isBST(root.left);
			BSTPair right = isBST(root.right);

			int min = Math.min(root.data, Math.min(left.min, right.min));
			int max = Math.max(root.data, Math.max(left.max, right.max));
			boolean isBst = left.isBst && right.isBst && root.data > left.max && root.data < right.min;

			return new BSTPair(min, max, isBst);
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
