package com.jsp.bst;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TwoSumPairsBST {

	public static void main(String[] args) {
		Integer[] arr = { 12, 25, 30, 37, 40, 50, 60, 62, 70, 75, 87 };
		Tree tree = new Tree(arr);
		tree.printInorder(tree.root);
		System.out.println();
		tree.printLevelOrder(tree.root);
		System.out.println(tree.targetSumPair(100));
		System.out.println(tree.targetSumPair2(100));
		System.out.println(tree.targetSumPair3(100));
	}

	static class Tree {

		static class Node {
			int data;
			Node left;
			Node right;

			public Node(int data) {
				this.data = data;
			}

			@Override
			public String toString() {
				return data + "";
			}
		}

		static class Pair {
			Node node;
			int state;

			public Pair(Node node, int state) {
				this.node = node;
				this.state = state;
			}
		}

		Node root;

		public Tree(Integer[] arr) {
			constructTree(arr);
		}

		List<String> pairs;

		public List<String> targetSumPair(int target) {
			pairs = new ArrayList<>();
			targetSumPair(root, target);
			return pairs;
		}

		private void targetSumPair(Node node, int target) {
			if (node != null) {
				targetSumPair(node.left, target);

				int diff = target - node.data;
				if (node.data < diff && find(root, diff)) {
					pairs.add(node.data + " " + diff);
				}

				targetSumPair(node.right, target);
			}
		}

		public List<String> targetSumPair2(int target) {
			pairs = new ArrayList<>();

			List<Integer> list = new ArrayList<>();
			toSortedList(root, list);

			int lo = 0, hi = list.size() - 1;

			while (lo < hi) {
				int sum = list.get(lo) + list.get(hi);
				if (sum > target)
					hi--;
				else if (sum < target)
					lo++;
				else
					pairs.add(list.get(lo++) + " " + list.get(hi--));
			}
			return pairs;
		}

		public List<String> targetSumPair3(int target) {
			pairs = new ArrayList<>();
			Stack<Pair> left = new Stack<>(), right = new Stack<>();
			left.add(new Pair(root, 1));
			right.add(new Pair(root, 1));

			Node lo = getNextFromInorder(left);
			Node hi = getNextFromRevInorder(right);

			while (lo.data < hi.data) {
				int sum = lo.data + hi.data;
				if (sum < target)
					lo = getNextFromInorder(left);
				else if (sum > target)
					hi = getNextFromRevInorder(right);
				else {
					pairs.add(lo.data + " " + hi.data);
					lo = getNextFromInorder(left);
					hi = getNextFromRevInorder(right);
				}
			}
			return pairs;
		}

		private Node getNextFromInorder(Stack<Pair> left) {
			while (!left.isEmpty()) {
				Pair peek = left.peek();
				if (peek.state == 1) {
					if (peek.node.left != null)
						left.add(new Pair(peek.node.left, 1));
					peek.state++;
				} else {
					Node node = left.pop().node;
					if (node.right != null)
						left.add(new Pair(node.right, 1));
					return node;
				}
			}
			return null;
		}

		private Node getNextFromRevInorder(Stack<Pair> right) {
			while (!right.isEmpty()) {
				Pair peek = right.peek();
				if (peek.state == 1) {
					if (peek.node.right != null)
						right.add(new Pair(peek.node.right, 1));
					peek.state++;
				} else {
					Node node = right.pop().node;
					if (node.left != null)
						right.add(new Pair(node.left, 1));
					return node;
				}
			}
			return null;
		}

		private void toSortedList(Node root, List<Integer> list) {
			if (root != null) {
				toSortedList(root.left, list);
				list.add(root.data);
				toSortedList(root.right, list);
			}
		}

		private boolean find(Node root, int val) {
			if (root != null) {
				if (root.data < val)
					return find(root.right, val);
				else if (root.data > val)
					return find(root.left, val);
				else
					return true;

			}
			return false;
		}

		private void constructTree(Integer[] arr) {
			root = construct(arr, 0, arr.length - 1);
		}

		private Node construct(Integer[] arr, int lo, int hi) {
			if (lo <= hi) {
				int mid = (lo + hi) / 2;
				Node newNode = new Node(arr[mid]);
				newNode.left = construct(arr, lo, mid - 1);
				newNode.right = construct(arr, mid + 1, hi);
				return newNode;
			}
			return null;
		}

		public void printLevelOrder(Node root) {
			if (root == null)
				return;
			Queue<Node> queue = new ArrayDeque<>();
			queue.add(root);

			while (!queue.isEmpty()) {
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					root = queue.remove();
					System.out.print(root.data + " ");

					if (root.left != null)
						queue.add(root.left);

					if (root.right != null)
						queue.add(root.right);
				}
				System.out.println();
			}
		}

		public void printInorder(Node root) {
			if (root == null) {
				return;
			}
			printInorder(root.left);
			System.out.print(root.data + " ");
			printInorder(root.right);
		}

	}
}
