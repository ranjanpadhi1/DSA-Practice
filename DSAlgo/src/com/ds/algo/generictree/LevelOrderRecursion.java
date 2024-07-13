package com.ds.algo.generictree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LevelOrderRecursion {
	public static void main(String[] args) {
		int[] arr = new int[] { 10, 20, -1, 30, 50, -1, 60, -1, -1, 40 };

		Tree tree = new Tree(arr);
		List<List<Integer>> levels = new ArrayList<>();
		tree.levelOrder(tree.root, 0, levels);
		System.out.println(levels);
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

		public void levelOrder(Node root, int level, List<List<Integer>> levels) {
			if (levels.size() == level)
				levels.add(new ArrayList<>());

			levels.get(level).add(root.data);

			for (Node child : root.children)
				levelOrder(child, level + 1, levels);
		}
	}
}
