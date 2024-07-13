package com.ds.algo.generictree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class LinearizeTree {
	public static void main(String[] args) {
		int[] arr = new int[] { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100,
				-1, -1, -1 };

		Tree tree = new Tree(arr);
		System.out.println("-- Level Order --");
		tree.printLevels(tree.root);
		System.out.println("-- Linearize Tree --");
		tree.linearize(tree.root);
		tree.printLevels(tree.root);
	}

	static class Tree {

		// Recursion - O(n) / O(n)
		public void linearize(Node root) {
			while (root.children.size() > 1) {
				Node lastChild = root.children.remove(root.children.size() - 1);
				Node secondLastChild = root.children.get(root.children.size() - 1);
				getTail(secondLastChild).children.add(lastChild);
			}
			for (Node child : root.children)
				linearize(child);
		}

		private Node getTail(Node node) {
			while (!node.children.isEmpty())
				node = node.children.get(0);
			return node;
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
