package com.ds.algo.binarytree;

import java.util.Stack;

public class PrePostInOrderIterative {
	public static void main(String[] args) {
		Integer arr[] = new Integer[] { 10, 20, 40, null, null, 50, null, null, 30, null, 60 };
		Tree tree = new Tree(arr);
		tree.traverse();
		System.out.println(tree.preOrder);
		System.out.println(tree.inOrder);
		System.out.println(tree.postOrder);

	}

	static class Tree {
		StringBuffer preOrder = new StringBuffer();
		StringBuffer inOrder = new StringBuffer();
		StringBuffer postOrder = new StringBuffer();

		public void traverse() {
			Stack<Pair> stack = new Stack<>();
			stack.push(new Pair(root, 1));

			while (!stack.isEmpty()) {
				Pair top = stack.peek();
				if (top.state == 1) {
					preOrder.append(top.node.val + " ");
					top.state++;
					if (top.node.left != null)
						stack.push(new Pair(top.node.left, 1));
				} else if (top.state == 2) {
					inOrder.append(top.node.val + " ");
					top.state++;
					if (top.node.right != null)
						stack.push(new Pair(top.node.right, 1));
				} else {
					postOrder.append(top.node.val + " ");
					stack.pop();
				}
			}
		}

		static class Node {
			Integer val;
			Node left;
			Node right;

			public Node(Integer val) {
				this.val = val;
			}

			@Override
			public String toString() {
				return val + "";
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
			Stack<Pair> stack = new Stack<>();
			for (int i = 0; i < arr.length; i++) {
				Node newNode = arr[i] != null ? new Node(arr[i]) : null;
				if (!stack.isEmpty() && stack.peek().state == 1) {
					stack.peek().node.left = newNode;
					stack.peek().state++;
				} else if (!stack.isEmpty() && stack.peek().state == 2) {
					stack.peek().node.right = newNode;
					stack.pop();
				} else if (stack.isEmpty()) {
					root = newNode;
				}

				if (newNode != null)
					stack.push(new Pair(newNode, 1));
			}
		}
	}
}
