package com.ds.algo.generictree;

import java.util.ArrayList;
import java.util.Stack;

public class HeightOfTree {
	public static void main(String[] args) {
		int[] arr = new int[] { 10, 20, 30, -1, 40, -1, -1, 50, 60, -1, 70, 80, -1, 90, -1, -1, 100, -1, -1, 110, 120,
				-1, -1, -1 };

		Tree tree = new Tree(arr);
		System.out.println(tree.height(tree.root));
	}

	static class Tree {

		public int height(Node root) {
			if (root != null) {
				int height = 0;
				for (Node child : root.children) {
					int childHt = height(child);
					if (childHt > height)
						height = childHt;
				}
				height += 1;
				return height;
			}
			return 0;
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