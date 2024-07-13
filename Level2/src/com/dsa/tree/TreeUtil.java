package com.dsa.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeUtil {

	public static Node construct(Integer[] arr) {
		Node root = null;

		Stack<NPair> stack = new Stack<>();

		for (int i = 0; i < arr.length; i++) {
			Node newNode = arr[i] != null ? new Node(arr[i]) : null;
			if (root != null) {
				NPair pair = stack.peek();
				if (pair.state == 1) {
					pair.node.left = newNode;
					pair.state++;
				} else {
					pair.node.right = newNode;
					stack.pop();
				}
			} else
				root = newNode;

			if (newNode != null)
				stack.push(new NPair(newNode, 1));
		}

		return root;
	}

	static int i;

	public static Node constructR(Integer[] arr) {
		i = 0;
		return constructHelper(arr);
	}

	private static Node constructHelper(Integer[] arr) {
		if (i >= arr.length || arr[i] == null) {
			i++;
			return null;
		}
		Node newNode = new Node(arr[i]);
		i++;
		newNode.left = constructHelper(arr);
		newNode.right = constructHelper(arr);

		return newNode;
	}

	public static List<Integer> preOrder(Node root) {
		List<Integer> preOrder = new ArrayList<>();
		Node curr = root;

		while (curr != null) {
			if (curr.left == null) {
				preOrder.add(curr.data);
				curr = curr.right;
			} else {
				Node pred = curr.left;
				while (pred.right != null && pred.right != curr) {
					pred = pred.right;
				}

				if (pred.right == null) {
					pred.right = curr;
					preOrder.add(curr.data);
					curr = curr.left;
				} else {
					pred.right = null;
					curr = curr.right;
				}
			}
		}
		return preOrder;
	}

	public static List<Integer> inOrder(Node root) {
		List<Integer> preOrder = new ArrayList<>();
		Node curr = root;

		while (curr != null) {
			if (curr.left == null) {
				preOrder.add(curr.data);
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
					preOrder.add(curr.data);
					pred.right = null;
					curr = curr.right;
				}
			}
		}
		return preOrder;
	}
}
