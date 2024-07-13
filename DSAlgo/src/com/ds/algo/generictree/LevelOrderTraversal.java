package com.ds.algo.generictree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderTraversal {
	public static void main(String[] args) {
		int[] arr = new int[] { 10, 20, -1, 30, 50, -1, 60, -1, -1, 40 };

		Tree tree = new Tree(arr);
		tree.print(tree.root);
		System.out.println();
		System.out.println("---");
		tree.printLevelOrder(tree.root);
	}

	static class Tree {

		// Using Queue - O(n) / O(n)
		public void printLevelOrder(Node node) {
			Queue<Node> que = new ArrayDeque<>();
			que.add(node);

			while (que.size() > 0) {
				node = que.remove();
				System.out.print(node.data + " ");
				for (Node child : node.children)
					que.add(child);
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

		public void printChildren(Node root) {
			System.out.println();
			if (root != null) {
				System.out.print(root.data + " -> ");
				for (Node child : root.children)
					System.out.print(child.data + ", ");
				for (Node child : root.children)
					printChildren(child);
			}
		}

		public void print(Node root) {
			if (root != null) {
				System.out.print(root.data + " ");
				for (Node child : root.children)
					print(child);
			}
		}
	}
}
