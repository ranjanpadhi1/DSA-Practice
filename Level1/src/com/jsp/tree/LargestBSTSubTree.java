package com.jsp.tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class LargestBSTSubTree {

	public static void main(String[] args) {
		Integer[] arr = { 50, 25, 12, null, null, 37, 30, null, null, 40, null, null, 75, 62, 50, null, null, 77, null,
				null, 87 };
		Tree tree = new Tree(arr);
		tree.printLevelOrder();
		System.out.println(tree.largestBSTSubtree());
	}

	static class Tree {

		static class TreeInfo {
			int min;
			int max;
			int size;
			boolean isBst;

			public TreeInfo(int min, int max, int size, boolean isBst) {
				super();
				this.min = min;
				this.max = max;
				this.size = size;
				this.isBst = isBst;
			}
		}

		int maxBstSize;

		public int largestBSTSubtree() {
			maxBstSize = 0;
			largestBST(root);
			return maxBstSize;
		}

		private TreeInfo largestBST(Node root) {
			if (root == null)
				return new TreeInfo(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);

			TreeInfo leftTree = largestBST(root.left);
			TreeInfo rightTree = largestBST(root.right);

			int min = Math.min(root.data, Math.min(leftTree.min, rightTree.min));
			int max = Math.max(root.data, Math.max(leftTree.max, rightTree.max));
			int size = 1 + leftTree.size + rightTree.size;
			boolean isBst = leftTree.isBst && rightTree.isBst && root.data > leftTree.max && root.data < rightTree.min;

			if (isBst) {
				maxBstSize = Math.max(maxBstSize, size);
			}
			return new TreeInfo(min, max, size, isBst);
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