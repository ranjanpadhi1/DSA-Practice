package com.jsp.gtree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ConstructGenericTree {
	public static void main(String[] args) {
		Integer[] arr = { 10, 20, 50, null, 60, null, null, 30, 70, null, 80, null, 90, null, null, 40, 100 };
		Tree tree = new Tree(arr);
		tree.printPreOrder(tree.root);
		System.out.println();
		System.out.println(tree.find(tree.root, 60));
		System.out.println(tree.find(tree.root, 85));
	}

	static class Tree {

		static class Node {
			int val;
			List<Node> children;

			public Node(int val) {
				this.val = val;
				children = new ArrayList<>();
			}

			@Override
			public String toString() {
				return val + " ";
			}
		}

		Node root;

		public Tree(Integer[] arr) {
			constructTree(arr);
		}

		public boolean find(Node root, int val) {
			if (root != null) {
				System.out.print(root.val + " -> ");
				if (root.val == val)
					return true;
				else {
					for (Node child : root.children) {
						if (find(child, val))
							return true;
					}
				}
			}
			return false;
		}

		private void constructTree(Integer[] arr) {
			Stack<Node> stack = new Stack<>();

			for (int i = 0; i < arr.length; i++) {
				Node newNode = arr[i] == null ? null : new Node(arr[i]);
				if (stack.isEmpty())
					root = newNode;
				else if (newNode == null)
					stack.pop();
				else {
					stack.peek().children.add(newNode);
				}
				if (newNode != null)
					stack.push(newNode);
			}
		}

		public void printPreOrder(Node root) {
			if (root != null) {
				System.out.print(root.val + " ");
				for (Node child : root.children)
					printPreOrder(child);
			}
		}
	}
}
