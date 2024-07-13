package com.jsp.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LowestCommonAncestor {

	public static void main(String[] args) {
		Integer[] arr = { 50, 25, 12, null, null, 37, 30, null, null, 40, null, null, 75, 62, null, null, 87 };
		Tree tree = new Tree(arr);
		System.out.println(tree.leastCommonAncestor(12, 40));
	}

	static class Tree {

		public boolean nodeToRootPath(Node root, int node, List<Integer> path) {
			if (root == null)
				return false;
			else if (root.data == node) {
				path.add(node);
				return true;
			}
			if (nodeToRootPath(root.left, node, path) || nodeToRootPath(root.right, node, path)) {
				path.add(root.data);
				return true;
			}
			return false;
		}

		public int leastCommonAncestor(int p, int q) {
			List<Integer> pPaths = new ArrayList<>();
			nodeToRootPath(root, p, pPaths);

			List<Integer> qPaths = new ArrayList<>();
			nodeToRootPath(root, q, qPaths);

			int i = pPaths.size(), j = qPaths.size(), lca = -1;
			while (i >= 0 && j >= 0 && pPaths.get(--i) == qPaths.get(--j)) {
				lca = pPaths.get(i);
			}
			return lca;
		}

		static class Node {
			int data;
			Node left;
			Node right;

			public Node(int data) {
				this.data = data;
			}

			@Override
			public String toString() {
				return data + "";
			}
		}

		static class Pair {
			Node node;
			int state;

			public Pair(Node node, int state) {
				this.node = node;
				this.state = state;
			}
		}

		Node root;

		public Tree(Integer[] arr) {
			constructTree(arr);
		}

		private void constructTree(Integer[] arr) {
			Stack<Pair> stack = new Stack<>();

			for (int i = 0; i < arr.length; i++) {
				Node newNode = arr[i] != null ? new Node(arr[i]) : null;
				if (root != null) {
					Pair pair = stack.peek();
					if (pair.state == 1) {
						pair.node.left = newNode;
						pair.state++;
					} else {
						pair.node.right = newNode;
						stack.pop();
					}
				} else
					root = newNode;

				if (newNode != null)
					stack.push(new Pair(newNode, 1));
			}
		}
	}
}
