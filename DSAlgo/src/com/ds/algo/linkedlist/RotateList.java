package com.ds.algo.linkedlist;

public class RotateList {
	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		list1.head = new LinkedList.Node(10);
		list1.head.next = new LinkedList.Node(20);
		list1.head.next.next = new LinkedList.Node(30);
		list1.head.next.next.next = new LinkedList.Node(40);
		list1.head.next.next.next.next = new LinkedList.Node(50);
		list1.head.next.next.next.next.next = new LinkedList.Node(60);
		list1.traverse(list1.rotate(2));

		LinkedList list2 = new LinkedList();
		list2.head = new LinkedList.Node(10);
		list2.head.next = new LinkedList.Node(20);
		list2.head.next.next = new LinkedList.Node(30);
		list2.traverse(list2.rotate(4));
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

		public Node rotate(int k) {
			if (head == null)
				return head;

			int length = 1;
			Node current = head;
			// Make cyclic list
			while (current.next != null) {
				length++;
				current = current.next;
			}
			current.next = head;
			k = k % length;

			// Break n-k link and point head
			current = head;
			for (int i = 0; i < length - k - 1; i++) {
				current = current.next;
			}
			head = current.next;
			current.next = null;

			return head;
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
