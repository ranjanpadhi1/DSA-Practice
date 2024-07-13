package com.ds.algo.recursion;

public class ReverseLinkedList {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		list.traverse(list.head);
		list.traverse(list.reverse(list.head, null));
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

		public Node reverse(Node current, Node prev) {
			if (current == null)
				return prev;
			Node node = reverse(current.next, current);
			current.next = prev;
			return node;
		}

		public void traverse(Node head) {
			while (head != null) {
				System.out.print(head.data);
				System.out.print(head.next != null ? " -> " : " -> NULL");
				head = head.next;
			}
			System.out.println();
		}
	}
}
