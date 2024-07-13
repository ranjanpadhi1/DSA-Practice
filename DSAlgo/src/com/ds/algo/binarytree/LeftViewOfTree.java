package com.ds.algo.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class LeftViewOfTree {
	public static void main(String[] args) {
		Integer arr[] = new Integer[] { 10, 20, 30, null, null, 40, 50, null, null, null, 60, 70, null, 80, null, null,
				90 };
		Tree tree = new Tree(arr);
		tree.printLevelOrder();
		tree.printLeftView(tree.root);
		List<Integer> leftView = new ArrayList<>();
		tree.leftView(tree.root, leftView, 0);
		System.out.println(leftView);
	}

	static class Tree {

		public void printLeftView(Node root) {
			List<Integer> leftView = new ArrayList<>();
			Queue<Node> queue = new LinkedList<>();
			queue.add(root);

			while (!queue.isEmpty()) {
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					Node node = queue.remove();
					if (i == 0)
						leftView.add(node.val);
					if (node.left != null)
						queue.add(node.left);
					if (node.right != null)
						queue.add(node.right);
				}
			}
			System.out.println(leftView);

		}

		public void leftView(Node root, List<Integer> leftView, int level) {
			if (root != null) {
				if (leftView.size() == level)
					leftView.add(root.val);
				leftView(root.left, leftView, level + 1);
				leftView(root.right, leftView, level + 1);
			}
		}

		static class Node {
			int val;
			Node left;
			Node right;

			Node(int val) {
				this.val = val;
			}

			@Override
			public String toString() {
				return val + "";
			}
		}

		class Pair {
			Node node;
			int state;

			public Pair(Node node, int state) {
				this.node = node;
				this.state = state;
			}
		}

		Node root;

		public Tree(Integer[] arr) {
			Stack<Pair> stack = new Stack<>();
			for (int i = 0; i < arr.length; i++) {
				Node newNode = arr[i] != null ? new Node(arr[i]) : null;
				if (!stack.isEmpty()) {
					Pair pair = stack.peek();
					if (pair.state == 1) {
						pair.node.left = newNode;
						pair.state++;
					} else if (pair.state == 2) {
						pair.node.right = newNode;
						stack.pop();
					}
				}

				if (root == null)
					root = newNode;

				if (newNode != null)
					stack.push(new Pair(newNode, 1));
			}
		}

		public void printLevelOrder() {
			Queue<Node> queue = new LinkedList<>();
			queue.add(root);
			while (!queue.isEmpty()) {
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					Node node = queue.remove();
					System.out.print(node.val + " ");
					if (node.left != null)
						queue.add(node.left);
					if (node.right != null)
						queue.add(node.right);
				}
				System.out.println();
			}
		}
	}
}
