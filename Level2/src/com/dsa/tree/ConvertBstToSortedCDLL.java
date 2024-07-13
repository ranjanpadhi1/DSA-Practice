package com.dsa.tree;

public class ConvertBstToSortedCDLL {
	public static void main(String[] args) {
		Tree tree = new Tree(
				new Integer[] { 50, 25, 12, null, null, 37, 30, null, null, 40, null, null, 75, 60, null, null, 80 });

		System.out.println(TreeUtil.inOrder(tree.root));
		System.out.println(TreeUtil.preOrder(tree.root));

//		Node root = tree.convertToCdll1(tree.root);
		Node root = tree.convertToCdll2(tree.root);
		Node curr = root;
		while (curr.right != root) {
			System.out.print(curr.data + " ");
			curr = curr.right;
		}
	}

	static class Tree {
		Node root;

		public Tree(Integer[] arr) {
			root = TreeUtil.construct(arr);
		}

		private Node head, prev;

		public Node convertToCdll1(Node root) {
			connect(root);
			if (head != null && prev != null) {
				head.left = prev;
				prev.right = head;
			}
			return head;
		}

		private void connect(Node root) {
			if (root == null)
				return;

			connect(root.left);
			if (head == null)
				head = root;

			if (prev != null) {
				prev.right = root;
				root.left = prev;
			}
			prev = root;
			connect(root.right);
		}

		public Node convertToCdll2(Node curr) {
			while (curr != null) {
				if (curr.left != null) {
					Node rightMost = curr.left;
					while (rightMost.right != null && rightMost.right != curr) {
						rightMost = rightMost.right;
					}
					if (rightMost.right == null) {
						rightMost.right = curr;
						curr = curr.left;
					} else {
						connectWithPrev(curr);
						curr = curr.right;
					}
				} else {
					connectWithPrev(curr);
					curr = curr.right;
				}
			}
			if (head != null && prev != null) {
				head.left = prev;
				prev.right = head;
			}

			return head;
		}

		private void connectWithPrev(Node curr) {
			if (head == null)
				head = curr;
			if (prev != null) {
				prev.right = curr;
				curr.left = prev;
			}
			if (head != null)
				prev = curr;
		}
	}
}
