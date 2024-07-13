package com.ds.algo.generictree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderZigZag {
	public static void main(String[] args) {
		int[] arr = new int[] { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100,
				-1, -1, -1 };

		Tree tree = new Tree(arr);
		System.out.println("-- Level Order --");
		tree.printLevels(tree.root);
		System.out.println("-- Zig Zig Level --");
		tree.printZigZagLevels(tree.root);
	}

	static class Tree {

		// Using two stacks - O(n) / O(n)
		public void printZigZagLevels(Node root) {
			Stack<Node> stack = new Stack<>();
			Stack<Node> childStack = new Stack<>();
			stack.add(root);
			boolean evenLevel = true;

			while (!stack.isEmpty()) {
				Node node = stack.pop();
				System.out.print(node.data + " ");
				for (int i = 0; i < node.children.size(); i++) {
					childStack.push(node.children.get(evenLevel ? i : node.children.size() - 1 - i));
				}
				if (stack.isEmpty()) {
					stack = childStack;
					childStack = new Stack<>();
					evenLevel = !evenLevel;
					System.out.println();
				}
			}
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
