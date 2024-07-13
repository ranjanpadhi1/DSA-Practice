package com.ds.algo.linkedlist;

public class MergeTwoSortedList {
	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		list1.add(1);
		list1.add(2);
		list1.add(4);
		list1.traverse(list1.head);

		LinkedList list2 = new LinkedList();
		list2.add(1);
		list2.add(3);
		list2.add(4);
		list2.traverse(list2.head);
		list2.traverse(list1.merge(list2));
	}

	static class LinkedList {
		Node head;

		static class Node {
			int data;
			Node next;

			public Node(int data) {
				this.data = data;
			}
		}

		public void add(int data) {
			Node current = head, newNode = new Node(data);
			if (head == null)
				head = newNode;
			else {
				while (current.next != null)
					current = current.next;
				current.next = newNode;
			}
		}

		// Using dummy node
		public Node merge(LinkedList list2) {
			Node c1 = head, c2 = list2.head;
			Node dummy = new Node(-1), newHead = dummy;

			while (c1 != null && c2 != null) {
				if (c1.data < c2.data) {
					dummy.next = c1;
					c1 = c1.next;
				} else {
					dummy.next = c2;
					c2 = c2.next;
				}
				dummy = dummy.next;
			}

			if (c1 != null)
				dummy.next = c1;
			if (c2 != null)
				dummy.next = c2;

			return newHead.next;
		}

		public void traverse(Node head) {
			for (Node current = head; current != null; current = current.next) {
				System.out.print(current.data);
				System.out.print(current.next != null ? " -> " : " -> NULL");
			}
			System.out.println();
		}
	}
}
