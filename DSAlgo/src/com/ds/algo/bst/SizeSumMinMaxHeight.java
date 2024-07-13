package com.ds.algo.bst;

public class SizeSumMinMaxHeight {
	public static void main(String[] args) {
		BST bst = new BST(new int[] { 12, 25, 37, 50, 62, 75, 100 });
		bst.print(bst.root);
		System.out.println("\nSize : " + bst.size(bst.root));
		System.out.println("Sum : " + bst.sum(bst.root));
		System.out.println("Min : " + bst.min(bst.root));
		System.out.println("Max : " + bst.max(bst.root));
		System.out.println("Height : " + bst.height(bst.root, 0));
	}

	private static class BST {

		public int size(Node root) {
			return root != null ? 1 + size(root.left) + size(root.right) : 0;
		}

		public int sum(Node root) {
			return root != null ? root.val + sum(root.left) + sum(root.right) : 0;
		}

		public int min(Node root) {
			if (root.left != null)
				return min(root.left);
			else
				return root.val;
		}

		public int max(Node root) {
			if (root.right != null)
				return max(root.right);
			else
				return root.val;
		}

		public int height(Node root, int l) {
			if (root == null)
				return 0;
			return Math.max(height(root.left, l + 1), height(root.right, l + 1)) + 1;
		}

		public BST(int[] arr) {
			construct(arr, 0, arr.length - 1);
		}

		private Node construct(int[] arr, int lo, int hi) {
			if (lo == hi)
				return new Node(arr[lo]);

			int mid = (lo + hi) / 2;
			Node newNode = new Node(arr[mid]);
			if (root == null)
				root = newNode;

			newNode.left = construct(arr, lo, mid - 1);
			newNode.right = construct(arr, mid + 1, hi);

			return newNode;
		}

		private static class Node {
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

		Node root;

		public void print(Node root) {
			if (root != null) {
				print(root.left);
				System.out.print(root.val + " ");
				print(root.right);
			}
		}
	}
}
