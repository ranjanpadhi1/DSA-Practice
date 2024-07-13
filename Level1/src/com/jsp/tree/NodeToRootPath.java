package com.jsp.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NodeToRootPath {

	public static void main(String[] args) {
		Integer[] arr = { 10, 20, 40, null, null, 50, 80, null, null, null, 30, 60, null, 90, null, null, 70 };
		Tree tree = new Tree(arr);

		List<Integer> path = new ArrayList<>();
		tree.nodeToRootPath(tree.root, 80, path);
		System.out.println(path);
	}

	static class Tree {

		public boolean nodeToRootPath(Node root, int node, List<Integer> path) {
			if (root == null)
				return false;
			else if (root.data == node) {
				path.add(node);
				return true;
			}
			if (nodeToRootPath(root.left, node, path) || nodeToRootPath(root.right, node, path)) {
				path.add(root.data);
				return true;
			}
			return false;
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
