package com.dsa.tree;

import java.util.ArrayList;
import java.util.List;

public class MorrisPreOrderTraversal {
	public static void main(String[] args) {
		Integer[] arr = { 10, 20, null, 40, 60, 70, null, null, null, null, 30, null, 50, null, null };
		Tree tree = new Tree(arr);
		System.out.println(tree.morrisPreOrder(tree.root));
	}

	static class Tree {
		Node root;

		public Tree(Integer[] arr) {
			root = TreeUtil.construct(arr);
		}

		public List<Integer> morrisPreOrder(Node root) {
			List<Integer> preOrder = new ArrayList<>();
			Node curr = root;

			while (curr != null) {
				if (curr.left == null) {
					preOrder.add(curr.data);
					curr = curr.right;
				} else {
					Node pre = curr.left;
					// Find in-order Predecessor
					while (pre.right != null && pre.right != curr) {
						pre = pre.right;
					}
					if (pre.right == null) {
						pre.right = curr;
						preOrder.add(curr.data);
						curr = curr.left;
					} else {
						pre.right = null;
						curr = curr.right;
					}
				}
			}
			return preOrder;
		}
	}
}
