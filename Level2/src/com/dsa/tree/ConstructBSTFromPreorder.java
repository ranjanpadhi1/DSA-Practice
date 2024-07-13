package com.dsa.tree;

public class ConstructBSTFromPreorder {
	public static void main(String[] args) {
		Tree tree = new Tree(new int[] { 50, 25, 12, 37, 30, 40, 75, 62, 87 });
		System.out.println(TreeUtil.preOrder(tree.root));
		System.out.println(TreeUtil.inOrder(tree.root));
	}

	static class Tree {
		Node root;

		public Tree(int[] arr) {
			root = constructBst(arr, Integer.MIN_VALUE, Integer.MAX_VALUE);
		}

		private int i;

		private Node constructBst(int[] arr, int min, int max) {
			if (i == arr.length)
				return null;

			if (arr[i] > min && arr[i] < max) {
				Node node = new Node(arr[i++]);
				node.left = constructBst(arr, min, node.data);
				node.right = constructBst(arr, node.data, max);
				return node;
			} else
				return null;
		}

	}
}
