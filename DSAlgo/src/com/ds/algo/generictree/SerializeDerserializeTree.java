package com.ds.algo.generictree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.ds.algo.generictree.SerializeDerserializeTree.Tree.Node;

public class SerializeDerserializeTree {
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, -1, 3, 4, -1, 5, -1 };

		Tree tree = new Tree(arr);
		tree.printLevels(tree.root);
		String treeStr = tree.serialize();
		System.out.println(treeStr);
		Node root = tree.deSerialize(treeStr);
		tree.print(root);
		System.out.println();
		tree.printLevels(root);
	}

	static class Tree {

		public String serialize() {
			StringBuffer sb = new StringBuffer();
			serializeHelper(root, sb);
			return sb.toString();
		}

		public Node deSerialize(String treeStr) {
			Node root = null;
			Stack<Node> stack = new Stack<>();
			String[] arr = treeStr.split(",");
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i].equals("-1"))
					stack.pop();
				else {
					Node newNode = new Node(Integer.valueOf(arr[i]));
					if (!stack.isEmpty())
						stack.peek().children.add(newNode);
					else
						root = newNode;

					stack.push(newNode);
				}
			}
			return root;
		}

		private void serializeHelper(Node root, StringBuffer sb) {
			sb.append(root.data + ",");

			if (root.children.isEmpty())
				sb.append("-1" + ",");

			for (Node child : root.children)
				serializeHelper(child, sb);
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

		public void print(Node root) {
			if (root != null) {
				System.out.print(root.data + " ");
				for (Node child : root.children)
					print(child);
			}
		}

		public void printLevels(Node root) {
			Queue<Node> queue = new LinkedList<>();
			queue.add(root);
			queue.add(null);

			while (!queue.isEmpty()) {
				root = queue.remove();
				if (root != null) {
					System.out.print(root.data + " ");
					for (Node child : root.children)
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
