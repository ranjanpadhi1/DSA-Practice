package com.ds.algo.bst;

public class AddNodeInBST {
	public static void main(String[] args) {
		BST bst = new BST(new int[] { 12, 25, 37, 50, 62, 75, 100 });
		bst.print(bst.root);

		bst.add(bst.root, 30);
		System.out.println();
		bst.print(bst.root);

		bst.add(bst.root, 90);
		System.out.println();
		bst.print(bst.root);

		bst.add(bst.root, 50);
		System.out.println();
		bst.print(bst.root);
	}

	private static class BST {

		public Node add(Node root, int val) {
			if (root == null)
				return new Node(val);

			if (val < root.val) {
				root.left = add(root.left, val);
			} else if (val > root.val)
				root.right = add(root.right, val);

			return root;
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
