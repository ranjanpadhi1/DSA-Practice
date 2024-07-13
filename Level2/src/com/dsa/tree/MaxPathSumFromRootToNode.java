package com.dsa.tree;

public class MaxPathSumFromRootToNode {
	public static void main(String[] args) {
		Tree tree = new Tree(new Integer[] { 10, 20, 4, null, null, 50, -80, null, null, -9, null, null, -3, 60, -100,
				null, null, 11, null, null, -70 });
		System.out.println(TreeUtil.preOrder(tree.root));
		System.out.println(TreeUtil.inOrder(tree.root));

		System.out.println(tree.maxPathSum(tree.root));
	}

	static class Tree {
		Node root;

		public Tree(Integer[] arr) {
			root = TreeUtil.construct(arr);
		}

		public int maxPathSum(Node root) {
			if (root == null)
				return Integer.MIN_VALUE;

			int leftMax = maxPathSum(root.left);
			int rightMax = maxPathSum(root.right);

			int max = Math.max(leftMax, rightMax);
			if (max < 0)
				max = 0;

			return max + root.data;
		}
	}
}
