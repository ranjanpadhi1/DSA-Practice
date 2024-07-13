package com.dsa.tree;

public class MaxPathSumNodeToNode {
	public static void main(String[] args) {
		Tree tree = new Tree(new Integer[] { -10, 9, null, null, 20, 15, null, null, 7 });
		System.out.println(TreeUtil.preOrder(tree.root));
		System.out.println(TreeUtil.inOrder(tree.root));

		System.out.println(tree.maxPathSum(tree.root));
	}

	static class Tree {
		Node root;

		public Tree(Integer[] arr) {
			root = TreeUtil.construct(arr);
		}

		private int maxSum = Integer.MIN_VALUE;

		public int maxPathSum(Node root) {
			maxSum(root);
			return maxSum;
		}

		private int maxSum(Node root) {
			if (root == null)
				return Integer.MIN_VALUE;

			int leftMax = Math.max(maxSum(root.left), 0);
			int rightMax = Math.max(maxSum(root.right), 0);

			maxSum = Math.max(maxSum, leftMax + rightMax + root.data);

			return Math.max(leftMax, rightMax) + root.data;
		}
	}
}
