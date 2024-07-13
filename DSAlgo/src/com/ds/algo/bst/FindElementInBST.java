package com.ds.algo.bst;

public class FindElementInBST {
	public static void main(String[] args) {
		BST bst = new BST(new int[] { 12, 25, 37, 50, 62, 75, 100 });
		bst.print(bst.root);
		System.out.println("\n" + bst.find(bst.root, 50));
		System.out.println(bst.find(bst.root, 100));
		System.out.println(bst.find(bst.root, 22));
	}

	private static class BST {

		public boolean find(Node root, int val) {
			if (root == null)
				return false;

			if (val > root.val)
				return find(root.right, val);
			else if (val < root.val)
				return find(root.left, val);
			else
				return true;
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
