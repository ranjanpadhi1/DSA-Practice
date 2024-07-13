package com.ds.algo.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PrintSingleChildNodes {
	public static void main(String[] args) {
		Integer arr[] = new Integer[] { 10, 20, 30, null, null, 40, 50, null, null, null, 60, 70, null, 80, null, null,
				90 };
		Tree tree = new Tree(arr);
		tree.printLevelOrder(tree.root);
		System.out.println("-------------");
		tree.printSingleChildNodes(tree.root);
	}

	static class Tree {

		public void printSingleChildNodes(Node root) {
			if (root != null) {
				if (root.left == null && root.right == null)
					return;
				if (root.left == null || root.right == null)
					System.out.print(root.val + " ");
				printSingleChildNodes(root.left);
				printSingleChildNodes(root.right);
			}
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
