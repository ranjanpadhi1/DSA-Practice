package com.dsa.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BinaryTreeTopView {
	public static void main(String[] args) {
		Integer[] arr = { 10, 20, null, 40, 60, 70, null, null, null, null, 30, null, 50, null, null };
		Tree tree = new Tree(arr);
		System.out.println(tree.topView(tree.root));
	}

	static class Tree {
		Node root;

		public Tree(Integer[] arr) {
			root = TreeUtil.construct(arr);
		}

		static class Pair {
			int col;
			Node node;

			public Pair(int col, Node node) {
				this.col = col;
				this.node = node;
			}
		}

		public List<Integer> topView(Node root) {
			Map<Integer, Integer> map = new TreeMap<>();
			Queue<Pair> queue = new ArrayDeque<>();
			queue.add(new Pair(0, root));

			while (!queue.isEmpty()) {
				Pair pair = queue.remove();
				if (!map.containsKey(pair.col))
					map.put(pair.col, pair.node.data);

				if (pair.node.left != null)
					queue.add(new Pair(pair.col - 1, pair.node.left));

				if (pair.node.right != null)
					queue.add(new Pair(pair.col + 1, pair.node.right));
			}
			return new ArrayList<>(map.values());
		}
	}
}
