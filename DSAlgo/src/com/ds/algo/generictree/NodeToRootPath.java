package com.ds.algo.generictree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class NodeToRootPath {
	public static void main(String[] args) {
		int[] arr = new int[] { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100,
				-1, -1, -1 };

		Tree tree = new Tree(arr);
		tree.printLevels(tree.root);
		System.out.println("-------------");
		System.out.println("50 -> " + tree.nodeToRootPath(tree.root, 50));
		System.out.println("110 -> " + tree.nodeToRootPath(tree.root, 110));
	}

	static class Tree {

		public List<Integer> nodeToRootPath(Node root, int data) {
			if (root.data == data) {
				List<Integer> path = new ArrayList<>();
				path.add(data);
				return path;
			}
			for (Node child : root.children) {
				List<Integer> pathTillChild = nodeToRootPath(child, data);
				if (!pathTillChild.isEmpty()) {
					pathTillChild.add(root.data);
					return pathTillChild;
				}
			}
			return new ArrayList<>();
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
