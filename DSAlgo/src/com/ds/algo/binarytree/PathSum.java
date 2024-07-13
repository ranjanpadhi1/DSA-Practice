package com.ds.algo.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class PathSum {
	public static void main(String[] args) {
		Integer arr[] = new Integer[] { 10, 20, 30, null, null, 40, 50, 100, null, null, null, null, 60, 70, null, 80,
				null, null, 90 };
		BinaryTree tree = new BinaryTree(arr);
		tree.printLevels(tree.root);

		List<Integer> paths = new ArrayList<>();
		tree.targetSumPaths(tree.root, 220, paths);
		System.out.println(paths);
	}

	static class BinaryTree {

		public boolean targetSumPaths(Node root, int targetSum, List<Integer> paths) {
			if (root != null) {
				targetSum -= root.val;
				if (targetSum == 0 || targetSumPaths(root.left, targetSum, paths)
						|| targetSumPaths(root.right, targetSum, paths)) {
					paths.add(root.val);
					return true;
				}
			}
			return false;
		}

		class Node {
			int val;
			Node left;
			Node right;

			public Node(int val) {
				this.val = val;
			}

			@Override
			public String toString() {
				return val + "";
			}
		}

		class Pair {
			Node node;
			int state;

			public Pair(Node node, int state) {
				this.node = node;
				this.state = state;
			}

			@Override
			public String toString() {
				return node.toString();
			}
		}

		Node root;

		public BinaryTree(Integer arr[]) {
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

		public void printLevels(Node root) {
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
