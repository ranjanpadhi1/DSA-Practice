package com.ds.algo.generictree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class MirrorShapeTrees {
	public static void main(String[] args) {
		int[] arr1 = new int[] { 1, 2, 3, -1, -1, 4, 5, -1, 6, -1, -1, 7, -1, -1 };

		int[] arr2 = new int[] { 10, 20, -1, 30, 40, -1, 50, -1, -1, 60, 70, -1, -1, -1 };

		int[] arr3 = new int[] { 10, 20, 30, -1, -1, 40, 50, -1, 60, -1, -1, 70, -1, -1 };

		Tree tree1 = new Tree(arr1);
		System.out.println("-- Level Order --");
		tree1.printLevels(tree1.root);

		Tree tree2 = new Tree(arr2);
		System.out.println("-- Level Order --");
		tree2.printLevels(tree2.root);

		Tree tree3 = new Tree(arr3);
		System.out.println("-- Level Order --");
		tree3.printLevels(tree3.root);

		System.out.println("-- Are Mirrors --");
		System.out.println(tree1.areMirror(tree1.root, tree2.root));
		System.out.println(tree1.areMirror(tree1.root, tree3.root));
		System.out.println(tree1.areMirror(tree2.root, tree3.root));
	}

	static class Tree {

		public boolean areMirror(Node root1, Node root2) {
			if (root1.children.size() != root2.children.size())
				return false;

			for (int i = 0; i < root1.children.size(); i++) {
				int j = root1.children.size() - i - 1;
				if (!areMirror(root1.children.get(i), root2.children.get(j)))
					return false;
			}
			return true;
		}

		Node root;

		static class Node {
			int data;
			List<Node> children = new ArrayList<>();

			public Node(int data) {
				this.data = data;
			}
		}

		public Tree(int[] arr) {
			Stack<Node> stack = new Stack<>();
			for (int data : arr) {
				Node newNode = new Node(data);
				if (data == -1)
					stack.pop();
				else {
					if (!stack.isEmpty())
						stack.peek().children.add(newNode);
					else
						root = newNode;

					stack.push(newNode);
				}
			}
		}

		public void printLevels(Node root) {
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
	}
}
