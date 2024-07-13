package com.ds.algo.binarytree;

public class ConstructTreeLevelOrder {

	public static void main(String[] args) {
		Integer arr[] = new Integer[] { 3, 9, 20, null, null, 15, 7 };
		BinaryTree tree = new BinaryTree(arr);
		tree.print(tree.root);
	}

	private static class BinaryTree {

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

		Node root;

		public BinaryTree(Integer[] arr) {
			root = new Node(arr[0]);
			constructTree(root, arr, 0);
		}

		private Node constructTree(Node root, Integer[] arr, int i) {
			return root;
		}

		public void print(Node root) {
			if (root == null)
				return;
			System.out.print(root.val + " ");
			print(root.left);
			print(root.right);
		}
	}
}
