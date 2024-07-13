package com.ds.algo.linkedlist;

public class AddTwoNumbers2 {
	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		list1.add(4);
		list1.add(6);
		list1.add(8);

		LinkedList list2 = new LinkedList();
		list2.add(8);
		list2.add(6);
		list2.add(9);

		list1.traverse(list1.head);
		list2.traverse(list2.head);
		list2.traverse(list1.addTwoNumbers(list2));
	}

	static class LinkedList {
		private Node head;

		static class Node {
			int data;
			Node next;

			public Node(int data) {
				this.data = data;
			}
		}

		public void add(int data) {
			Node newNode = new Node(data);
			if (head == null)
				head = newNode;
			else {
				Node current = head;
				while (current.next != null)
					current = current.next;
				current.next = newNode;
			}
		}

		public Node addTwoNumbers(LinkedList list2) {
			LinkedList list = new LinkedList();
			Node c1 = reverse(head), c2 = reverse(list2.head);
			int carry = 0;
			while (c1 != null || c2 != null) {
				int sum = (c1 != null ? c1.data : 0) + (c2 != null ? c2.data : 0) + carry;
				carry = sum / 10;
				list.add(sum % 10);
				if (c1 != null)
					c1 = c1.next;
				if (c2 != null)
					c2 = c2.next;
			}
			if (carry > 0)
				list.add(carry);
			return reverse(list.head);
		}

		private Node reverse(Node head) {
			Node current = head, prev = null, next = null;
			while (current != null) {
				next = current.next;
				current.next = prev;
				prev = current;
				current = next;
			}
			return prev;
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
