package com.ds.algo.binarytree;

public class DesginSegmentTree {

	public static void main(String[] args) {
		SegmentTree segTree = new SegmentTree(new int[] { 10, 20, 30, 40, 50, 60, 70, 80 });
		segTree.update(2, 40);
		System.out.println(segTree.query(0, 3));
//		segTree.print(segTree.root);
//		[5,6],[9,27],[2,3],[6,7],[1,-82],[3,-72],[3,7],[1,8],[5,13],[4,-67]
		SegmentTree segTree2 = new SegmentTree(new int[] { -28, -39, 53, 65, 11, -56, -65, -39, -43, 97 });
		System.out.println(segTree2.query(5, 6));
		segTree2.update(9, 27);
		System.out.println(segTree2.query(2, 3));
		System.out.println(segTree2.query(6, 7));
		segTree2.update(1, -82);
		segTree2.update(3, -72);
		System.out.println(segTree2.query(3, 7));
		System.out.println(segTree2.query(1, 8));
		segTree2.update(5, 13);
		segTree2.update(4, -67);
	}

	static class SegmentTree {

		static class Node {
			int sum;
			int start;
			int end;
			Node left;
			Node right;

			public Node(int sum, int start, int end, Node left, Node right) {
				super();
				this.sum = sum;
				this.start = start;
				this.end = end;
				this.left = left;
				this.right = right;
			}
		}

		Node root;

		public SegmentTree(int[] arr) {
			this.root = constructTree(arr, 0, arr.length - 1);
		}

		private Node constructTree(int[] arr, int lo, int hi) {
			if (lo == hi)
				return new Node(arr[lo], lo, lo, null, null);

			int mid = (lo + hi) / 2;
			Node left = constructTree(arr, lo, mid);
			Node right = constructTree(arr, mid + 1, hi);

			return new Node(left.sum + right.sum, lo, hi, left, right);
		}

		public void update(int index, int val) {
			this.updateHelper(root, index, val);
		}

		private void updateHelper(Node root, int index, int val) {
			int mid = (root.start + root.end) / 2;

			if (root.start == root.end) {
				root.sum = val;
				return;
			}

			if (index <= mid)
				updateHelper(root.left, index, val);
			else if (index > mid)
				updateHelper(root.right, index, val);

			root.sum = root.left.sum + root.right.sum;
		}

		public int query(int start, int end) {
			return queryHelper(root, start, end);
		}

		private int queryHelper(Node root, int start, int end) {
			if (root.end < start || root.start > end)
				return 0;
			else if (root.start >= start && root.end <= end)
				return root.sum;
			else
				return queryHelper(root.left, start, end) + queryHelper(root.right, start, end);
		}

		public void print(Node root) {
			if (root != null) {
				System.out.print(root.sum + "-" + root.start + "-" + root.end + ", ");
				print(root.left);
				print(root.right);
			}
		}
	}

}
