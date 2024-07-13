package com.ds.algo.generictree;

import java.util.ArrayList;
import java.util.Stack;

public class MaxOfTree {
	public static void main(String[] args) {
		int[] arr = new int[] { 10, 20, 30, -1, 40, -1, -1, 50, 60, -1, 70, 80, -1, 90, -1, -1, 100, -1, -1, 110, 120,
				-1, -1, -1 };

		Tree tree = new Tree(arr);
		System.out.println(tree.max(tree.root));
	}

	static class Tree {

		// Using Recursion
		public int max(Node root) {
			int max = Integer.MIN_VALUE;
			if (root != null) {
				for (Node child : root.children) {
					int maxSoFar = max(child);
					if (max < maxSoFar)
						max = maxSoFar;
				}

				if (root.data > max)
					max = root.data;
			}
			return max;
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
	}
}
