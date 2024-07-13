package com.dsa.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class DiagonalTraversal {
	public static void main(String[] args) {
		Integer[] arr = { 10, 20, null, 40, 60, 70, null, null, null, null, 30, null, 50, null, null };
		Tree tree = new Tree(arr);
		System.out.println(tree.diagonalTraversal(tree.root));
	}

	static class Tree {
		Node root;

		public Tree(Integer[] arr) {
			root = TreeUtil.construct(arr);
		}

		public ArrayList<Integer> diagonalTraversal(Node root) {
			ArrayList<Integer> result = new ArrayList<>();
			Queue<Node> queue = new ArrayDeque<>();
			queue.add(root);

			while (!queue.isEmpty()) {
				Node node = queue.remove();
				while (node != null) {
					result.add(node.data);
					if (node.left != null)
						queue.add(node.left);

					node = node.right;
				}
			}
			return result;
		}
	}
}
