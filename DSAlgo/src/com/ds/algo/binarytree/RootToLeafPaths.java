package com.ds.algo.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class RootToLeafPaths {
	public static void main(String[] args) {
		Integer arr[] = new Integer[] { 10, 20, 30, null, null, 40, 50, null, null, null, 60, 70, null, 80, null, null,
				90 };
		Tree tree = new Tree(arr);
		tree.printLevelOrder(tree.root);
		List<String> paths = new LinkedList<>();
		tree.findAllPathsR(tree.root, "", paths);
		System.out.println(paths);
		System.out.println(tree.findAllPaths(tree.root));

	}

	static class Tree {

		public void findAllPathsR(Node root, String path, List<String> paths) {
			if (root != null) {
				path += root.val + "";
				if (root.left == null && root.right == null)
					paths.add(path);
				else {
					path += "->";
					findAllPathsR(root.left, path, paths);
					findAllPathsR(root.right, path, paths);
				}
			}
		}

		public List<String> findAllPaths(Node root) {
			List<String> paths = new ArrayList<>();
			Stack<Pair> stack = new Stack<>();
			stack.push(new Pair(root, 1, root.val + ""));

			while (!stack.isEmpty()) {
				Pair top = stack.peek();
				if (top.state == 1) {
					if (top.node.left != null)
						stack.push(new Pair(top.node.left, 1, top.path + "->" + top.node.left.val));
					top.state++;
				} else if (top.state == 2) {
					if (top.node.right != null)
						stack.push(new Pair(top.node.right, 1, top.path + "->" + top.node.right.val));
					top.state++;
				} else if (top.node.left == null && top.node.right == null) {
					paths.add(stack.pop().path);
				} else
					stack.pop();
			}

			return paths;
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
			String path;

			public Pair(Node node, int state) {
				this.node = node;
				this.state = state;
			}

			public Pair(Node node, int state, String path) {
				this.node = node;
				this.state = state;
				this.path = path;
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

		public void printLevelOrder(Node root) {
			Queue<Node> queue = new LinkedList<>();
			queue.add(root);

			while (!queue.isEmpty()) {
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					root = queue.remove();
					System.out.print(root.val + " ");
					if (root.left != null)
						queue.add(root.left);
					if (root.right != null)
						queue.add(root.right);
				}
				System.out.println();
			}
		}
	}
}
