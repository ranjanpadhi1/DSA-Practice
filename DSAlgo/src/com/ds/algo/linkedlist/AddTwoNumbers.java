package com.ds.algo.linkedlist;

public class AddTwoNumbers {
	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		list1.add(2);
		list1.add(4);
		list1.add(3);
		list1.traverse(list1.head);
		LinkedList list2 = new LinkedList();
		list2.add(9);
		list2.add(6);
		list2.add(9);
		list1.traverse(list2.head);
		list1.traverse(list1.addTwoNumbers(list1.head, list2.head));
	}

	private static class LinkedList {
		Node head;

		static class Node {
			int data;
			Node next;

			public Node(int data) {
				this.data = data;
			}
		}

		public Node addTwoNumbers(Node head1, Node head2) {
			Node c1 = head1, c2 = head2, newHead = null, cNode = null;
			int carry = 0;
			while (c1 != null || c2 != null) {
				// Do sum
				int sum = (c1 != null ? c1.data : 0) + (c2 != null ? c2.data : 0) + carry;
				int digit = sum % 10;
				carry = sum / 10;

				// New result Linked List
				Node newNode = new Node(digit);
				if (newHead == null)
					newHead = cNode = newNode;
				else {
					cNode.next = newNode;
					cNode = cNode.next;
				}

				// Increment c1 & c1
				if (c1 != null)
					c1 = c1.next;

				if (c2 != null)
					c2 = c2.next;
			}

			if (carry > 0)
				cNode.next = new Node(carry);

			return newHead;
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

		public void traverse(Node head) {
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
