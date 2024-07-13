package com.ds.algo.generictree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class SizeMinMaxHeight {
	static int size = 0;
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	static int height = 0;

	public static void main(String[] args) {
		int[] arr = new int[] { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100,
				-1, -1, -1 };

		Tree tree = new Tree(arr);
		tree.printLevelOrder();
		tree.multisovler(tree.root, 0);
		System.out.println("Size : " + size);
		System.out.println("Min : " + min);
		System.out.println("Max : " + max);
		System.out.println("Height : " + height);
	}

	static class Tree {

		public void multisovler(Node root, int depth) {
			size++;
			max = Math.max(root.data, max);
			min = Math.min(root.data, min);
			height = Math.max(height, depth);
			for (Node child : root.children)
				multisovler(child, depth + 1);
		}

		static class Node {
			int data;
			List<Node> children = new ArrayList<>();

			public Node(int data) {
				this.data = data;
			}
		}

		Node root;

		public Tree(int[] arr) {
			Stack<Node> stack = new Stack<>();
			for (int data : arr) {
				if (data == -1)
					stack.pop();
				else {
					Node newNode = new Node(data);
					if (!stack.isEmpty())
						stack.peek().children.add(newNode);
					else
						root = newNode;
					stack.push(newNode);
				}
			}

		}

		public void printLevelOrder() {
			Queue<Node> queue = new LinkedList<>();
			queue.add(root);
			while (!queue.isEmpty()) {
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					Node node = queue.remove();
					System.out.print(node.data + " ");
					if (node != null) {
						for (Node child : node.children)
							queue.add(child);
					}
				}
				System.out.println();
			}
		}
	}
}
