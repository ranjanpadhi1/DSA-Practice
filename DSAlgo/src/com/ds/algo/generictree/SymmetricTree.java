package com.ds.algo.generictree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class SymmetricTree {
	public static void main(String[] args) {
		Tree tree1 = new Tree(new int[] { 10, 20, -1, 30, -1, -1 });
		tree1.printLevelOrder();
		System.out.println(tree1.isSymmetric());
		System.out.println("---------");

		Tree tree2 = new Tree(new int[] { 10, 20, 30, -1, -1, 40, 50, -1, 60, -1, -1, 70, 80, -1, -1 });
		tree2.printLevelOrder();
		System.out.println(tree2.isSymmetric());
		System.out.println("---------");

		Tree tree3 = new Tree(new int[] { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1,
				40, 100, -1, -1, -1 });
		tree3.printLevelOrder();
		System.out.println(tree3.isSymmetric());
	}

	static class Tree {

		public boolean isSymmetric() {
			return areMirror(root, root);
		}

		private boolean areMirror(Node root1, Node root2) {
			if (root1.children.size() != root2.children.size())
				return false;

			for (int i = 0; i < root1.children.size(); i++) {
				int j = root1.children.size() - i - 1;
				if (!areMirror(root1.children.get(i), root2.children.get(j)))
					return false;
			}

			return true;
		}

		static class Node {
			int data;
			List<Node> children = new ArrayList<>();

			public Node(int data) {
				this.data = data;
			}
		}

		Node root;

		public Tree(int[] arr) {
			Stack<Node> stack = new Stack<>();
			for (int data : arr) {
				if (data == -1)
					stack.pop();
				else {
					Node newNode = new Node(data);
					if (!stack.isEmpty())
						stack.peek().children.add(newNode);
					else
						root = newNode;
					stack.push(newNode);
				}
			}
		}

		public void printLevelOrder() {
			Node node = root;
			Queue<Node> queue = new LinkedList<>();
			queue.add(root);
			queue.add(null);

			while (!queue.isEmpty()) {
				node = queue.remove();
				if (node != null) {
					System.out.print(node.data + " ");
					for (Node child : node.children)
						queue.add(child);
				} else {
					System.out.println();
					if (!queue.isEmpty())
						queue.add(null);
				}
			}
		}
	}
}
