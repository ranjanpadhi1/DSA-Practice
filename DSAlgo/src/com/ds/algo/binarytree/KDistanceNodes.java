package com.ds.algo.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class KDistanceNodes {
	public static void main(String[] args) {
		Integer arr[] = new Integer[] { 10, 20, 30, null, null, 40, 50, 100, null, null, null, null, 60, 70, null, 80,
				null, null, 90 };
		BinaryTree tree = new BinaryTree(arr);
		tree.printLevels(tree.root);
		System.out.println(tree.preOrder(tree.root, new ArrayList<>()));
		System.out.println(tree.findKDistanceNode(40, 2));
	}

	static class BinaryTree {

		public List<Integer> findKDistanceNode(int node, int k) {
			List<Node> nodeToRoot = new ArrayList<>();
			nodeToRootPath(root, node, nodeToRoot);
			System.out.println(nodeToRoot);

			List<Integer> result = new ArrayList<>();
			for (int i = 0; i < nodeToRoot.size(); i++) {
				kDownNodes(nodeToRoot.get(i), k - i, i == 0 ? null : nodeToRoot.get(i - 1), result);
			}
			return result;
		}

		public List<Integer> preOrder(Node root, List<Integer> pre) {
			if (root != null) {
				pre.add(root.val);
				preOrder(root.left, pre);
				preOrder(root.right, pre);
			}
			return pre;
		}

		private void kDownNodes(Node root, int k, Node blocker, List<Integer> result) {
			if (root == null || (blocker != null && blocker.val == root.val))
				return;

			if (k == 0)
				result.add(root.val);

			kDownNodes(root.left, k - 1, blocker, result);
			kDownNodes(root.right, k - 1, blocker, result);
		}

		private boolean nodeToRootPath(Node root, int node, List<Node> nodeToRoot) {
			if (root != null) {
				if (root.val == node || nodeToRootPath(root.left, node, nodeToRoot)
						|| nodeToRootPath(root.right, node, nodeToRoot)) {
					nodeToRoot.add(root);
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
