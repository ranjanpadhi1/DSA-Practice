package com.ds.algo.linkedlist;

public class MiddleElement {
	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		list1.head = new LinkedList.Node(10);
		list1.head.next = new LinkedList.Node(20);
		list1.head.next.next = new LinkedList.Node(30);
		list1.head.next.next.next = new LinkedList.Node(40);
		list1.head.next.next.next.next = new LinkedList.Node(50);
		list1.head.next.next.next.next.next = new LinkedList.Node(60);
		System.out.println(list1.middle());

		LinkedList list2 = new LinkedList();
		list2.head = new LinkedList.Node(10);
		list2.head.next = new LinkedList.Node(20);
		list2.head.next.next = new LinkedList.Node(30);
		list2.head.next.next.next = new LinkedList.Node(40);
		list2.head.next.next.next.next = new LinkedList.Node(50);
		System.out.println(list2.middle());
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

		public int middle() {
			Node slow = head;
			Node fast = head;
			while (fast != null && fast.next != null) {
				slow = slow.next;
				fast = fast.next.next;
			}
			return slow.data;
		}
	}
}
