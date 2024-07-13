package com.dsa.tree;

public class RecoverBST {
	public static void main(String[] args) {
		Integer[] arr = { 50, 60, 12, null, null, 37, 30, null, null, 40, null, null, 75, 25, null, null, 80 };
		Tree tree = new Tree(arr);
		System.out.println(TreeUtil.inOrder(tree.root));
		tree.recoverBst(tree.root);
		System.out.println(TreeUtil.inOrder(tree.root));
	}

	static class Tree {

		Node root;

		public Tree(Integer[] arr) {
			root = TreeUtil.construct(arr);
		}

		private Node x, y;

		public void recoverBst(Node root) {
			findSwapedNodes(root);
			swap(x, y);
		}

		private void findSwapedNodes(Node curr) {
			Node prev = null;

			while (curr != null) {
				if (curr.left == null) {
					updateXandY(prev, curr);
					prev = curr;
					curr = curr.right;
				} else {
					Node pred = curr.left;
					while (pred.right != null && pred.right != curr) {
						pred = pred.right;
					}
					if (pred.right == null) {
						pred.right = curr;
						curr = curr.left;
					} else {
						pred.right = null;
						updateXandY(prev, curr);
						prev = curr;
						curr = curr.right;
					}
				}
			}
		}

		private void updateXandY(Node prev, Node curr) {
			if (prev != null && prev.data > curr.data) {
				if (x == null)
					x = prev;
				y = curr;
			}
		}

		private void swap(Node x, Node y) {
			if (x != null && y != null) {
				int temp = x.data;
				x.data = y.data;
				y.data = temp;
			}
		}
	}
}
