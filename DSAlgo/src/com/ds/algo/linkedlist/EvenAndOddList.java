package com.ds.algo.linkedlist;

public class EvenAndOddList {
	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		list1.head = new LinkedList.Node(10);
		list1.head.next = new LinkedList.Node(20);
		list1.head.next.next = new LinkedList.Node(30);
		list1.head.next.next.next = new LinkedList.Node(40);
		list1.head.next.next.next.next = new LinkedList.Node(50);
		list1.head.next.next.next.next.next = new LinkedList.Node(60);
		list1.divideToEvenAndOddList();

		LinkedList list2 = new LinkedList();
		list2.head = new LinkedList.Node(10);
		list2.head.next = new LinkedList.Node(20);
		list2.head.next.next = new LinkedList.Node(30);
		list2.head.next.next.next = new LinkedList.Node(40);
		list2.head.next.next.next.next = new LinkedList.Node(50);
		list2.divideToEvenAndOddList();
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

		public void divideToEvenAndOddList() {
			Node head1 = head, head2 = head.next;

			Node current1 = head, current2 = head.next;

			while (current1 != null && current2 != null) {
				current1.next = current1.next != null ? current1.next.next : null;
				current1 = current1.next;

				current2.next = current2.next != null ? current2.next.next : null;
				current2 = current2.next;
			}

			traverse(head1);
			traverse(head2);

		}

		private void traverse(Node head) {
			Node current = head;
			while (current != null) {
				System.out.print(current.data);
				System.out.print(current.next != null ? " -> " : " -> NULL");
				current = current.next;
			}
			System.out.println();
		}
	}
}