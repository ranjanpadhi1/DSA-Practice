package com.ds.algo.generictree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class KthLargestElement {

	public static void main(String[] args) {
		Tree tree = new Tree(new int[] { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1,
				40, 100, -1, -1, -1 });
		tree.printPreOrder(tree.root);
		tree.floor(tree.root, Integer.MAX_VALUE);
		tree.floor(tree.root, 120);
		System.out.println(tree.floor);
		System.out.println(tree.kthLargestElement(3));
	}

	static class Tree {
		int floor = Integer.MIN_VALUE;

		public int kthLargestElement(int k) {
			floor = Integer.MIN_VALUE;
			int factor = Integer.MAX_VALUE;
			while (k-- >= 0) {
				floor(root, factor);
				factor = floor;
				floor = Integer.MIN_VALUE;
			}
			return factor;
		}

		public void floor(Node root, int data) {
			if (root.data < data) {
				if (root.data > floor)
					floor = root.data;
			}

			for (Node child : root.children)
				floor(child, data);
		}

		static class Node {
			int data;
			List<Node> children = new ArrayList<>();

			public Node(int data) {
				this.data = data;
			}
		}

		Node root;

		public Tree(int arr[]) {
			Stack<Node> stack = new Stack<>();
			for (int data : arr) {
				Node newNode = new Node(data);
				if (data == -1)
					stack.pop();
				else {
					if (stack.isEmpty())
						root = newNode;
					else
						stack.peek().children.add(newNode);
					stack.push(newNode);
				}
			}
		}

		public void printLevelOrder() {
			Node node = root;
			Queue<Node> queue = new LinkedList<>();
			queue.add(root);
			queue.add(null);

			while (!queue.isEmpty()) {
				node = queue.remove();
				if (node != null) {
					System.out.print(node.data + " ");
					for (Node child : node.children)
						queue.add(child);
				} else {
					System.out.println();
					if (!queue.isEmpty())
						queue.add(null);
				}
			}
		}

		public void printPreOrder(Node root) {
			System.out.print(root.data + " ");
			for (Node child : root.children)
				printPreOrder(child);
		}
	}
}
