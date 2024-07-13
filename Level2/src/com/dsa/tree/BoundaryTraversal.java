package com.dsa.tree;

import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversal {
	public static void main(String[] args) {
		Integer[] arr = { 10, 20, null, 40, 60, 70, null, null, null, null, 30, null, 50, null, null };
		Tree tree = new Tree(arr);
		System.out.println(tree.boundaryTraversal(tree.root));
	}

	static class Tree {
		Node root;

		public Tree(Integer[] arr) {
			root = TreeUtil.construct(arr);
		}

		private List<Integer> result;

		public List<Integer> boundaryTraversal(Node root) {
			result = new ArrayList<>();
			if (root == null)
				return result;

			result.add(root.data);

			if (isLeafNode(root))
				return result;

			leftWall(root.left);
			leaves(root);
			rightWall(root.right);

			return result;
		}

		private void leftWall(Node root) {
			if (root == null || isLeafNode(root))
				return;

			if (!isLeafNode(root))
				result.add(root.data);

			if (root.left != null)
				leftWall(root.left);
			else
				leftWall(root.right);
		}

		private void leaves(Node root) {
			if (root == null)
				return;

			if (isLeafNode(root)) {
				result.add(root.data);
				return;
			}
			leaves(root.left);
			leaves(root.right);
		}

		private void rightWall(Node root) {
			if (root == null || isLeafNode(root))
				return;

			if (root.right != null)
				rightWall(root.right);
			else
				rightWall(root.left);

			if (!this.isLeafNode(root))
				result.add(root.data);
		}

		private boolean isLeafNode(Node root) {
			return root != null && root.left == null && root.right == null;
		}
	}
}
