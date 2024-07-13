package com.dsa.tree;

import java.util.ArrayList;
import java.util.List;

public class MorrisInOrderTraversal {
	public static void main(String[] args) {
		Integer[] arr = { 10, 20, null, 40, 60, 70, null, null, null, null, 30, null, 50, null, null };
		Tree tree = new Tree(arr);
		System.out.println(tree.morrisInOrder(tree.root));
	}

	static class Tree {
		Node root;

		public Tree(Integer[] arr) {
			root = TreeUtil.construct(arr);
		}

		public List<Integer> morrisInOrder(Node root) {
			List<Integer> inOrder = new ArrayList<>();
			Node curr = root;

			while (curr != null) {
				if (curr.left == null) {
					inOrder.add(curr.data);
					curr = curr.right;
				} else {
					Node pre = curr.left;
					while (pre.right != null && pre.right != curr) {
						pre = pre.right;
					}
					if (pre.right == null) {
						pre.right = curr;
						curr = curr.left;
					} else {
						pre.right = null;
						inOrder.add(curr.data);
						curr = curr.right;
					}
				}
			}
			return inOrder;
		}

		public void printPreorder(Node root) {
			if (root == null) {
				return;
			}
			System.out.print(root.data + " ");
			printPreorder(root.left);
			printPreorder(root.right);
		}

		public void printInorder(Node root) {
			if (root == null) {
				return;
			}
			printInorder(root.left);
			System.out.print(root.data + " ");
			printInorder(root.right);
		}

		public void printPostorder(Node root) {
			if (root == null) {
				return;
			}
			printPostorder(root.left);
			printPostorder(root.right);
			System.out.print(root.data + " ");
		}
	}
}
