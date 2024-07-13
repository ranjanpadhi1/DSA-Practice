package com.dsa.tree;

public class DesignAVLTree {
	public static void main(String[] args) {
		AvlTree tree = new AvlTree(new int[] { 12, 25, 37, 50, 62, 75, 87 });
		tree.print(tree.z);
		tree.add(11);
		tree.add(10);
		System.out.println("--------------------");
		tree.print(tree.z);
		tree.add(35);
		tree.add(30);
		System.out.println("--------------------");
		tree.print(tree.z);
	}

	static class AvlTree {

		static class Node {
			int val;
			Node left;
			Node right;
			int height;
			int balance;

			public Node(int val) {
				this.val = val;
				height = 1;
				balance = 0;
			}
		}

		Node z;

		public AvlTree(int[] arr) {
			this.z = construct(arr, 0, arr.length - 1);
		}

		private int getHeight(Node node) {
			int leftHt = node.left != null ? node.left.height : 0;
			int rightHt = node.right != null ? node.right.height : 0;
			return Math.max(leftHt, rightHt) + 1;
		}

		private int getBalance(Node node) {
			int leftHt = node.left != null ? node.left.height : 0;
			int rightHt = node.right != null ? node.right.height : 0;
			return leftHt - rightHt;
		}

		private Node construct(int[] arr, int lo, int hi) {
			if (lo > hi)
				return null;

			int mid = (lo + hi) / 2;
			Node node = new Node(arr[mid]);
			node.left = construct(arr, lo, mid - 1);
			node.right = construct(arr, mid + 1, hi);

			node.height = getHeight(node);
			node.balance = getBalance(node);

			return node;
		}

		public void add(int val) {
			add(z, val);
		}

		private Node add(Node root, int val) {
			if (root == null)
				return new Node(val);

			if (root.val > val)
				root.left = add(root.left, val);
			else if (root.val < val)
				root.right = add(root.right, val);

			root.height = this.getHeight(root);
			root.balance = this.getBalance(root);

			if (root.balance > 1) { // LL LR
				if (root.left.balance >= 0) {// LL
					return rightRotate(root);
				} else { // LR
					root = rightRotate(root);
					return leftRotate(root);
				}

			} else if (root.balance < -1) { // RR RL
				if (root.right.balance <= 0) { // RR
					return leftRotate(root);
				} else { // RL

				}
			}
			return root;
		}

		private Node rightRotate(Node z) {
			Node y = z.left;
			z.left = y.right;
			y.right = z;

			z.balance = getBalance(z);
			z.height = getHeight(z);

			y.balance = getBalance(y);
			y.height = getHeight(y);
			return y;
		}

		private Node leftRotate(Node z) {
			Node y = z.right;
			z.right = y.left;
			y.left = z;

			z.balance = getBalance(z);
			z.height = getHeight(z);

			y.balance = getBalance(y);
			y.height = getHeight(y);
			return y;
		}

		public void print(Node node) {
			if (node != null) {
				String left = node.left != null ? node.left.val + "" : "--";
				String right = node.right != null ? node.right.val + "" : "--";
				System.out.println(left + " <-[" + node.val + "|" + node.height + "|" + node.balance + "]-> " + right);
				print(node.left);
				print(node.right);
			}
		}

	}
}
