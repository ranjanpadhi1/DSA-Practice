package com.ds.algo.bst;

public class PrintInRange {

	public static void main(String[] args) {
		BST bst = new BST(new int[] { 12, 25, 37, 50, 62, 75, 100 });
		bst.print(bst.root);
		System.out.println();
		bst.printInRange(bst.root, 30, 80);
	}

	private static class BST {

		public void printInRange(Node root, int lo, int hi) {
			if (root != null) {
				if (lo < root.val && hi < root.val)
					printInRange(root.left, lo, hi);
				else if (lo > root.val && hi > root.val)
					printInRange(root.right, lo, hi);
				else {
					printInRange(root.left, lo, hi);
					System.out.print(root.val + " ");
					printInRange(root.right, lo, hi);
				}
			}
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
