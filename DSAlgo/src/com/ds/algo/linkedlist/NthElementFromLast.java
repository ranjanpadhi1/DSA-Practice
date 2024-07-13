package com.ds.algo.linkedlist;

public class NthElementFromLast {
	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		list1.head = new LinkedList.Node(10);
		list1.head.next = new LinkedList.Node(20);
		list1.head.next.next = new LinkedList.Node(30);
		list1.head.next.next.next = new LinkedList.Node(40);
		list1.head.next.next.next.next = new LinkedList.Node(50);
		list1.head.next.next.next.next.next = new LinkedList.Node(60);
		System.out.println(list1.elementFromLast(2));

		LinkedList list2 = new LinkedList();
		list2.head = new LinkedList.Node(10);
		list2.head.next = new LinkedList.Node(20);
		list2.head.next.next = new LinkedList.Node(30);
		list2.head.next.next.next = new LinkedList.Node(40);
		list2.head.next.next.next.next = new LinkedList.Node(50);
		System.out.println(list2.elementFromLast(3));
	}

	private static class LinkedList {
		Node head;

		private static class Node {
			Node next;
			int data;

			public Node(int data) {
				this.data = data;
			}

			@Override
			public String toString() {
				return data + "";
			}
		}

		public int elementFromLast(int n) {
			Node first = head;
			while (n-- > 0 && first != null) {
				first = first.next;
			}
			if (first == null)
				return -1;

			Node second = head;
			while (first != null) {
				first = first.next;
				second = second.next;
			}

			return second.data;
		}
	}
}
