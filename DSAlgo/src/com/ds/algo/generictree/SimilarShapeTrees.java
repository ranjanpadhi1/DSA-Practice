package com.ds.algo.generictree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class SimilarShapeTrees {
	public static void main(String[] args) {
		int[] arr1 = new int[] { 1, 2, 5, -1, 6, -1, -1, 3, 7, -1, 8, 11, -1, 12, -1, -1, 9, -1, -1, 4, 10, -1, -1,
				-1 };

		int[] arr2 = new int[] { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100,
				-1, -1, -1 };

		int[] arr3 = new int[] { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, -1,
				-1 };

		Tree tree1 = new Tree(arr1);
		Tree tree2 = new Tree(arr2);
		Tree tree3 = new Tree(arr3);
		tree1.printLevels(tree1.root);
		System.out.println("-------------");
		tree2.printLevels(tree2.root);
		System.out.println("-------------");
		System.out.println(tree1.areSimiar(tree1.root, tree2.root));
		System.out.println("-------------");
		tree2.printLevels(tree3.root);
		System.out.println("-------------");
		System.out.println(tree1.areSimiar(tree1.root, tree3.root));
	}

	static class Tree {

		public boolean areSimiar(Node root1, Node root2) {
			if (root1.children.size() != root2.children.size())
				return false;
			for (int i = 0; i < root1.children.size(); i++) {
				Node n1 = root1.children.get(i);
				Node n2 = root2.children.get(i);
				if (!areSimiar(n1, n2))
					return false;
			}
			return true;
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
