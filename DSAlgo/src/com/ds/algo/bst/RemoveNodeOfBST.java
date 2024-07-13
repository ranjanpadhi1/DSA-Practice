package com.ds.algo.bst;

public class RemoveNodeOfBST {
	public static void main(String[] args) {
		BST bst = new BST(new int[] { 12, 25, 30, 37, 50, 60, 62, 70, 75, 90, 100 });
		bst.print(bst.root);

		bst.remove(bst.root, 12);
		System.out.println();
		bst.print(bst.root);

		bst.remove(bst.root, 37);
		System.out.println();
		bst.print(bst.root);

		bst.remove(bst.root, 75);
		System.out.println();
		bst.print(bst.root);
	}

	private static class BST {

		public Node remove(Node root, int val) {
			if (root == null)
				return null;

			if (val < root.val)
				root.left = remove(root.left, val);
			else if (val > root.val)
				root.right = remove(root.right, val);
			else {
				if (root.left == null && root.right == null)
					return null;
				else if (root.left == null || root.right == null)
					return root.left == null ? root.right : root.left;
				else {
					int leftMax = max(root.left);
					root.val = leftMax;
					root.left = remove(root.left, leftMax);
					return root;
				}
			}
			return root;
		}

		private int max(Node root) {
			if (root.right != null) {
				return max(root.right);
			} else
				return root.val;
		}

		public BST(int[] arr) {
			construct(arr, 0, arr.length - 1);
		}

		private Node construct(int[] arr, int lo, int hi) {
			if (lo > hi)
				return null;

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
