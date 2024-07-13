package com.dsa.tree;

import java.util.Stack;

public class FlattenBinaryTreeToLinkedList {
	public static void main(String[] args) {
		Tree tree = new Tree(new Integer[] { 1, 2, 3, null, null, 4, null, null, 5, null, 6, 7 });
		System.out.println(TreeUtil.preOrder(tree.root));
		System.out.println(TreeUtil.inOrder(tree.root));

//		tree.flattenTree1(tree.root);
//		tree.flattenTree2(tree.root);
		tree.flattenTree3(tree.root);
		System.out.println(TreeUtil.inOrder(tree.root));
	}

	static class Tree {
		Node root;

		public Tree(Integer[] arr) {
			root = TreeUtil.constructR(arr);
		}

		private Node prev;

		public void flattenTree1(Node root) {
			if (root == null)
				return;

			flattenTree1(root.right);
			flattenTree1(root.left);

			root.right = prev;
			root.left = null;
			prev = root;
		}

		public void flattenTree2(Node root) {
			Stack<Node> stack = new Stack<>();
			stack.push(root);

			while (!stack.isEmpty()) {
				Node curr = stack.pop();
				if (curr.right != null)
					stack.push(curr.right);

				if (curr.left != null)
					stack.push(curr.left);

				if (!stack.isEmpty()) {
					curr.right = stack.peek();
					curr.left = null;
				}
			}
		}

		public void flattenTree3(Node curr) {
			while (curr != null) {
				if (curr.left != null) {
					Node rightMost = curr.left;
					while (rightMost.right != null) {
						rightMost = rightMost.right;
					}
					rightMost.right = curr.right;
					curr.right = curr.left;
					curr.left = null;
				}
				curr = curr.right;
			}
		}
	}
}
