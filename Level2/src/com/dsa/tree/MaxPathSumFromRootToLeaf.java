package com.dsa.tree;

public class MaxPathSumFromRootToLeaf {
	public static void main(String[] args) {
		Tree tree = new Tree(new Integer[] { 10, 20, 4, null, null, 50, -80, null, null, -9, null, null, -3, 60, -100,
				null, null, 11, null, null, -70 });
		System.out.println(TreeUtil.preOrder(tree.root));
		System.out.println(TreeUtil.inOrder(tree.root));

		System.out.println(tree.maxPathSum1(tree.root));
		System.out.println(tree.maxPathSum2(tree.root, 0));
	}

	static class Tree {
		Node root;

		public Tree(Integer[] arr) {
			root = TreeUtil.construct(arr);
		}

		public int maxPathSum1(Node root) {
			if (root == null)
				return Integer.MIN_VALUE;

			int leftMax = maxPathSum1(root.left);
			int rightMax = maxPathSum1(root.right);
			int max = Math.max(leftMax, rightMax);

			if (max == Integer.MIN_VALUE)
				max = 0;

			return max + root.data;
		}

		public int maxPathSum2(Node root, int sum) {
			if (root == null)
				return sum;

			return Math.max(maxPathSum2(root.left, sum + root.data), maxPathSum2(root.right, sum + root.data));
		}
	}
}
