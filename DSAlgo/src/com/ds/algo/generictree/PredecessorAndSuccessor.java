package com.ds.algo.generictree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class PredecessorAndSuccessor {
	static int predecessor = Integer.MIN_VALUE;
	static int successor = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Tree tree = new Tree(new int[] { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1,
				40, 100, -1, -1, -1 });
		tree.printPreOrder(tree.root);
		System.out.println();
		tree.preAndSucc(tree.root, 60);
		System.out.println(predecessor);
		System.out.println(successor);
	}

	static class Tree {
		int range = 0;

		public void preAndSucc(Node root, int data) {
			if (range == 0) {
				if (data != root.data)
					predecessor = root.data;
				else
					range++;

			} else if (range == 1) {
				successor = root.data;
				range++;
			}
			for (Node child : root.children)
				preAndSucc(child, data);
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
