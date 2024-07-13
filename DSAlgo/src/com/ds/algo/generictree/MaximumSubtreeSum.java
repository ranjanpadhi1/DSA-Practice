package com.ds.algo.generictree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class MaximumSubtreeSum {
	public static void main(String[] args) {
		int[] arr1 = new int[] { 10, 20, -50, -1, -60, -1, -1, 30, -70, -1, 80, -110, -1, 120, -1, -1, 90, -1, -1, 40,
				-100, -1, -1, -1 };

		Tree tree = new Tree(arr1);
		tree.printLevels(tree.root);
		System.out.println("-------------");
		tree.printLevels(tree.maximumSubTree());
		System.out.println("Max Subtree sum - " + tree.maxSum);

	}

	static class Tree {
		Node maxSumNode = null;
		int maxSum = Integer.MIN_VALUE;

		public Node maximumSubTree() {
			maximumSum(root);
			return maxSumNode;
		}

		private int maximumSum(Node root) {
			int sum = root.data;
			for (Node child : root.children)
				sum += maximumSum(child);
			if (sum > maxSum) {
				maxSum = sum;
				maxSumNode = root;
			}
			return sum;
		}

		static class Node {
			int data;
			ArrayList<Node> children = new ArrayList<>();

			public Node(int data) {
				this.data = data;
			}
		}

		Node root;

		public Tree(int[] arr) {
			Stack<Node> stack = new Stack<>();
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == -1)
					stack.pop();
				else {
					Node newNode = new Node(arr[i]);
					if (stack.size() > 0)
						stack.peek().children.add(newNode);
					else
						root = newNode;
					stack.push(newNode);
				}
			}
		}

		public void printLevels(Node root) {
			Queue<Node> queue = new ArrayDeque<>();
			Queue<Node> childQueue = new ArrayDeque<>();
			queue.add(root);

			while (!queue.isEmpty()) {
				root = queue.remove();
				System.out.print(root.data + " ");
				for (Node child : root.children)
					childQueue.add(child);

				if (queue.isEmpty()) {
					queue = childQueue;
					childQueue = new ArrayDeque<>();
					System.out.println();
				}
			}
		}
	}
}
