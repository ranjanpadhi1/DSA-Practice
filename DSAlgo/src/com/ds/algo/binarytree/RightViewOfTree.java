package com.ds.algo.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class RightViewOfTree {
	public static void main(String[] args) {
		Integer arr[] = new Integer[] { 10, 20, 30, null, null, 40, 50, null, null, null, 60, 70, null, 80, null, null,
				90 };
		Tree tree = new Tree(arr);
		tree.printLevelOrder();
		tree.printRightView(tree.root);
		List<Integer> rightView = new ArrayList<>();
		tree.rightView(tree.root, rightView, 0);
		System.out.println(rightView);
	}

	static class Tree {

		public void printRightView(Node root) {
			List<Integer> rightView = new ArrayList<>();
			Queue<Node> queue = new LinkedList<>();
			queue.add(root);

			while (!queue.isEmpty()) {
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					Node node = queue.remove();
					if (i == size - 1)
						rightView.add(node.val);
					if (node.left != null)
						queue.add(node.left);
					if (node.right != null)
						queue.add(node.right);
				}
			}
			System.out.println(rightView);

		}

		public void rightView(Node root, List<Integer> rightView, int level) {
			if (root != null) {
				if (rightView.size() == level)
					rightView.add(level, root.val);
				rightView(root.right, rightView, level + 1);
				rightView(root.left, rightView, level + 1);
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
