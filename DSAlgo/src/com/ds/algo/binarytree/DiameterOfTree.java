package com.ds.algo.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DiameterOfTree {

	public static void main(String[] args) {
		Integer arr[] = new Integer[] { 10, 20, 30, null, null, 40, 50, null, null, null, 60, 70, null, 80, null, null,
				90 };
		BinaryTree tree = new BinaryTree(arr);
		tree.printLevelOrder(tree.root);
		System.out.println("Diameter : " + tree.diameter(tree.root));
	}

	private static class BinaryTree {
		int diameter;

		public int diameter(Node root) {
			diameter = 0;
			height(root);
			return diameter;
		}

		public int height(Node root) {
			if (root != null) {
				int leftHeight = height(root.left);
				int rightHeight = height(root.right);
				diameter = Math.max(diameter, leftHeight + rightHeight);
				return Math.max(leftHeight, rightHeight) + 1;
			}
			return 0;
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

		public void printLevelOrder(Node root) {
			Queue<Node> queue = new LinkedList<>();
			queue.add(root);

			while (!queue.isEmpty()) {
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					root = queue.remove();
					System.out.print(root.val + " ");
					if (root.left != null)
						queue.add(root.left);
					if (root.right != null)
						queue.add(root.right);
				}
				System.out.println();
			}
		}
	}
}
