package com.ds.algo.generictree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderLinewise {
	public static void main(String[] args) {
		int[] arr = new int[] { 10, 20, -1, 30, 50, -1, 60, -1, -1, 40 };

		Tree tree = new Tree(arr);
		tree.printLevels(tree.root);
		System.out.println("---------");
		tree.printLevels2(tree.root);
		System.out.println("---------");
		tree.printLevels3(tree.root);
	}

	static class Tree {

		// Using two Queues - O(n) / O(2n)
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

		// Using one Queue, Marker/Delimiter approach - O(n) / O(n)
		public void printLevels2(Node root) {
			Queue<Node> queue = new LinkedList<>();
			queue.add(root);
			queue.add(null);

			while (!queue.isEmpty()) {
				root = queue.remove();
				if (root != null) {
					System.out.print(root.data + " ");
					for (Node child : root.children)
						queue.add(child);
				} else {
					System.out.println();
					if (!queue.isEmpty())
						queue.add(null);
				}
			}
		}

		// Using one Queue and size/count of child - O(n) / O(n)
		public void printLevels3(Node root) {
			Queue<Node> queue = new LinkedList<>();
			queue.add(root);

			while (!queue.isEmpty()) {
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					root = queue.remove();
					System.out.print(root.data + " ");
					for (Node child : root.children)
						queue.add(child);
				}
				System.out.println();
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
	}
}
