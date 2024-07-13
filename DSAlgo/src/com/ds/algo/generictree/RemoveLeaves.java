package com.ds.algo.generictree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class RemoveLeaves {
	public static void main(String[] args) {
		int[] arr = new int[] { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100,
				-1, -1, -1 };

		Tree tree = new Tree(arr);
		System.out.println("-- Level Order --");
		tree.printLevels(tree.root);
		System.out.println("-- Removed Leaves --");
		tree.removeLeafs(tree.root);
		tree.printLevels(tree.root);
	}

	static class Tree {

		// Reverse children in recursion - O(n) / O(n)
		public void removeLeafs(Node root) {
			for (int i = root.children.size() - 1; i >= 0; i--) {
				Node child = root.children.get(i);
				if (child.children.isEmpty())
					root.children.remove(child);
				removeLeafs(child);
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
