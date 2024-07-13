package com.jsp.tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class IsTreeBalanced {

	public static void main(String[] args) {
		Integer[] arr = { 3, 9, null, null, 20, 15, null, null, 7, null, null };
		Tree tree = new Tree(arr);
		tree.printLevelOrder();
		System.out.println(tree.isBalanced());

		Integer[] arr2 = { 1, 2, 3, 4, null, null, 4, null, null, 3, null, null, 2, null, null };
		Tree tree2 = new Tree(arr2);
		tree2.printLevelOrder();
		System.out.println(tree2.isBalanced());
	}

	static class Tree {
		static class BPair {
			int height;
			boolean isBalanced;

			public BPair(int height, boolean isBalanced) {
				this.height = height;
				this.isBalanced = isBalanced;
			}
		}

		public boolean isBalanced() {
			return isBalanced(root).isBalanced;
		}

		private BPair isBalanced(Node root) {
			if (root == null)
				return new BPair(0, true);

			BPair left = isBalanced(root.left);
			BPair right = isBalanced(root.right);

			int height = Math.max(left.height, right.height) + 1;
			boolean isBalanced = left.isBalanced && right.isBalanced && Math.abs(left.height - right.height) <= 1;

			return new BPair(height, isBalanced);
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
