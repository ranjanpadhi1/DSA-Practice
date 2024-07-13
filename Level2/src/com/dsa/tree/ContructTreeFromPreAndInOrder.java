package com.dsa.tree;

import java.util.HashMap;
import java.util.Map;

public class ContructTreeFromPreAndInOrder {
	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.buildTree(new int[] { 10, 20, 40, 50, 80, 30, 60, 70 }, new int[] { 40, 20, 80, 50, 10, 60, 30, 70 });
		System.out.println(TreeUtil.preOrder(tree.root));
	}

	static class Tree {

		Node root;
		private int[] preorder;
		private Map<Integer, Integer> inOrderIndexMap = new HashMap<>();

		public void buildTree(int[] preorder, int[] inorder) {
			this.preorder = preorder;
			for (int i = 0; i < preorder.length; i++) {
				inOrderIndexMap.put(inorder[i], i);
			}
			this.root = buildTree(0, preorder.length - 1, 0, inorder.length - 1);
		}

		private Node buildTree(int preLo, int preHi, int inLo, int inHi) {
			if (preLo > preHi)
				return null;

			Node node = new Node(preorder[preLo]);
			int nodeIndex = this.inOrderIndexMap.get(node.data);
			int leftTreeSize = nodeIndex - inLo;

			node.left = buildTree(preLo + 1, preLo + leftTreeSize, inLo, nodeIndex - 1);
			node.right = buildTree(preLo + leftTreeSize + 1, preHi, nodeIndex + 1, inHi);

			return node;
		}
	}
}
