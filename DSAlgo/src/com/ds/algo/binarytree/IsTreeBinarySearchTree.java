package com.ds.algo.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class IsTreeBinarySearchTree {
	public static void main(String[] args) {
		Integer arr[] = new Integer[] { 10, 20, 30, null, null, 40, 50, null, null, null, 60, 70, null, 80, null, null,
				90 };
		Tree tree = new Tree(arr);
		tree.printLevelOrder();
		System.out.println(tree.isTreeBst(tree.root).isBst);
		System.out.println(tree.isTreeBst2(tree.root) + "\n");

		Integer arr2[] = new Integer[] { 50, 25, 12, null, null, 37, null, null, 75, 62, null, null, 87 };
		Tree tree2 = new Tree(arr2);
		tree2.printLevelOrder();
		tree2.inOrder(tree2.root);
		System.out.println("\n" + tree2.isTreeBst(tree2.root).isBst);
		System.out.println(tree2.isTreeBst2(tree2.root));
	}

	static class Tree {
		static class BSTPair {
			boolean isBst;
			int min;
			int max;
		}

		int prev = Integer.MIN_VALUE;

		public boolean isTreeBst2(Node root) {
			if (root != null) {
				if (!isTreeBst2(root.left))
					return false;

				if (prev > root.val)
					return false;

				prev = root.val;

				if (!isTreeBst2(root.right))
					return false;
			}
			return true;
		}

		public BSTPair isTreeBst(Node root) {
			if (root == null) {
				BSTPair newPair = new BSTPair();
				newPair.isBst = true;
				newPair.min = Integer.MAX_VALUE;
				newPair.max = Integer.MIN_VALUE;
				return newPair;
			}
			BSTPair left = isTreeBst(root.left);
			BSTPair right = isTreeBst(root.right);

			BSTPair newPair = new BSTPair();
			newPair.isBst = left.isBst && right.isBst && root.val > left.max && root.val < right.min;
			newPair.min = Math.min(root.val, Math.min(left.min, right.min));
			newPair.max = Math.max(root.val, Math.max(left.max, right.max));
			return newPair;
		}

		public void inOrder(Node root) {
			if (root != null) {
				inOrder(root.left);
				System.out.print(root.val + " ");
				inOrder(root.right);
			}
		}

		static class Node {
			int val;
			Node left;
			Node right;

			Node(int val) {
				this.val = val;
			}

			@Override
			public String toString() {
				return val + "";
			}
		}

		class Pair {
			Node node;
			int state;

			public Pair(Node node, int state) {
				this.node = node;
				this.state = state;
			}
		}

		Node root;

		public Tree(Integer[] arr) {
			Stack<Pair> stack = new Stack<>();
			for (int i = 0; i < arr.length; i++) {
				Node newNode = arr[i] != null ? new Node(arr[i]) : null;
				if (!stack.isEmpty()) {
					Pair pair = stack.peek();
					if (pair.state == 1) {
						pair.node.left = newNode;
						pair.state++;
					} else if (pair.state == 2) {
						pair.node.right = newNode;
						stack.pop();
					}
				}

				if (root == null)
					root = newNode;

				if (newNode != null)
					stack.push(new Pair(newNode, 1));
			}
		}

		public void printLevelOrder() {
			Queue<Node> queue = new LinkedList<>();
			queue.add(root);
			while (!queue.isEmpty()) {
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					Node node = queue.remove();
					System.out.print(node.val + " ");
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
