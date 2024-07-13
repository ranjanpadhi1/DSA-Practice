package com.ds.algo.generictree;

import java.util.ArrayList;
import java.util.Stack;

import com.ds.algo.generictree.ConstructGenericTree.Tree.Node;

public class ConstructGenericTree {
	public static void main(String[] args) {
		int[] arr = new int[] { 10, 20, 30, -1, 40, -1, -1, 50, 60, -1, 70, 80, -1, 90, -1, -1, 100, -1, -1, 110, 120,
				-1, -1, -1 };

		Tree tree = new Tree();
		Node root = tree.construct(arr);
		tree.print(root);
		tree.printChildren(root);
	}

	static class Tree {
		static class Node {
			int data;
			ArrayList<Node> children = new ArrayList<>();

			public Node(int data) {
				this.data = data;
			}
		}

		Node root;

		public Node construct(int[] arr) {
			Stack<Node> stack = new Stack<>();
			Node root = null;
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
			return root;
		}

		public void printChildren(Node root) {
			System.out.println();
			if (root != null) {
				System.out.print(root.data + " -> ");
				for (Node child : root.children)
					System.out.print(child.data + ", ");
				for (Node child : root.children)
					printChildren(child);
			}
		}

		public void print(Node root) {
			if (root != null) {
				System.out.print(root.data + " ");
				for (Node child : root.children)
					print(child);
			}
		}
	}
}
