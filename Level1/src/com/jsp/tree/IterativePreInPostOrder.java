package com.jsp.tree;

import java.util.Stack;

public class IterativePreInPostOrder {

	public static void main(String[] args) {
		Integer[] arr = { 10, 20, 40, null, null, 50, 80, null, null, null, 30, 60, null, 90, null, null, 70 };
		Tree tree = new Tree(arr);
		tree.traverse();
	}

	static class Tree {

		public void traverse() {
			Stack<Pair> stack = new Stack<>();
			stack.push(new Pair(root, 1));

			StringBuffer pre = new StringBuffer(), in = new StringBuffer(), post = new StringBuffer();

			while (!stack.isEmpty()) {
				Pair top = stack.peek();
				if (top.state == 1) {
					pre.append(top.node.data + " ");
					top.state++;
					if (top.node.left != null) {
						stack.push(new Pair(top.node.left, 1));
					}
				} else if (stack.peek().state == 2) {
					in.append(top.node.data + " ");
					top.state++;
					if (top.node.right != null) {
						stack.push(new Pair(top.node.right, 1));
					}
				} else {
					post.append(top.node.data + " ");
					stack.pop();
				}
			}

			System.out.println("Pre-order: " + pre);
			System.out.println("In-order: " + in);
			System.out.println("Post-order: " + post);
		}

		static class Node {
			int data;
			Node left;
			Node right;

			public Node(int data) {
				this.data = data;
			}

			@Override
			public String toString() {
				return data + "";
			}
		}

		static class Pair {
			Node node;
			int state;

			public Pair(Node node, int state) {
				this.node = node;
				this.state = state;
			}
		}

		Node root;

		public Tree(Integer[] arr) {
			constructTree(arr);
		}

		private void constructTree(Integer[] arr) {
			Stack<Pair> stack = new Stack<>();

			for (int i = 0; i < arr.length; i++) {
				Node newNode = arr[i] != null ? new Node(arr[i]) : null;
				if (root != null) {
					Pair pair = stack.peek();
					if (pair.state == 1) {
						pair.node.left = newNode;
						pair.state++;
					} else {
						pair.node.right = newNode;
						stack.pop();
					}
				} else
					root = newNode;

				if (newNode != null)
					stack.push(new Pair(newNode, 1));
			}
		}
	}
}
