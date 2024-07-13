package com.ds.algo.binarytree;

import java.util.Stack;

public class PrePostInOrderTraversal {
	public static void main(String[] args) {
		Integer arr[] = new Integer[] { 10, 20, 30, null, null, 40, 50, null, null, null, 60, 70, null, 80, null, null,
				90 };
		Tree tree = new Tree(arr);
		tree.printPreOrder(tree.root);
		System.out.println();
		tree.printInOrder(tree.root);
		System.out.println();
		tree.printPostOrder(tree.root);
	}

	static class Tree {

		public void printPreOrder(Node root) {
			if (root == null)
				return;
			System.out.print(root.val + " ");
			printPreOrder(root.left);
			printPreOrder(root.right);
		}

		public void printInOrder(Node root) {
			if (root == null)
				return;
			printInOrder(root.left);
			System.out.print(root.val + " ");
			printInOrder(root.right);
		}

		public void printPostOrder(Node root) {
			if (root == null)
				return;
			printPostOrder(root.left);
			printPostOrder(root.right);
			System.out.print(root.val + " ");
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
			System.out.println();
		}
	}
}
