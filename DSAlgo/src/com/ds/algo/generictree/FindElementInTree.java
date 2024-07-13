package com.ds.algo.generictree;

import java.util.ArrayList;
import java.util.Stack;

public class FindElementInTree {
	public static void main(String[] args) {
		int[] arr = new int[] { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100,
				-1, -1, -1 };

		Tree tree = new Tree(arr);
		System.out.println(tree.find(tree.root, 80));
		System.out.println(tree.find(tree.root, 55));
	}

	static class Tree {

		public boolean find(Node root, int data) {
			if (root.data == data)
				return true;
			for (Node child : root.children) {
				boolean found = find(child, data);
				if (found)
					return true;
			}
			return false;
		}

		static class Node {
			int data;
			ArrayList<Node> children = new ArrayList<>();

			public Node(int data) {
				this.data = data;
			}
		}

		Node root;

		public Tree(int[] arr) {
			Stack<Node> stack = new Stack<>();
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
		}
	}
}
