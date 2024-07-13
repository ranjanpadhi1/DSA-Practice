package com.ds.algo.linkedlist;

public class DesignLinkedList {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.addAtHead(1);
		list.addAtTail(3);
		list.addAtIndex(1, 2); // linked list becomes 1->2->3
		System.out.println(list);
		System.out.println(list.get(1)); // return 2
		list.deleteAtIndex(1); // now the linked list is 1->3
		System.out.println(list);
		System.out.println(list.get(1)); // return 3
		System.out.println(list);
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

		public int get(int index) {
			Node current = head;
			while (index-- > 0 && current != null)
				current = current.next;
			if (current == null)
				return -1;
			return current.data;
		}

		public void addAtHead(int data) {
			Node newNode = new Node(data);
			if (head == null)
				head = newNode;
			else {
				newNode.next = head;
				head = newNode;
			}
		}

		public void addAtTail(int data) {
			Node current = head, newNode = new Node(data);
			if (head == null)
				head = newNode;
			else {
				while (current.next != null)
					current = current.next;
				current.next = newNode;
			}
		}

		public void addAtIndex(int index, int data) {
			if (index == 0) {
				addAtHead(data);
				return;
			}

			Node current = head, newNode = new Node(data);
			while (index-- > 1 && current != null)
				current = current.next;

			if (current != null) {
				newNode.next = current.next;
				current.next = newNode;
			}
		}

		public void deleteAtIndex(int index) {
			if (index == 0) {
				head = head != null ? head.next : null;
				return;
			}
			Node current = head;
			while (index-- > 1 && current != null)
				current = current.next;
			if (current != null)
				current.next = current.next != null ? current.next.next : null;
		}

		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer();
			Node current = head;
			while (current != null) {
				sb.append(current.data);
				sb.append(current.next != null ? " -> " : " -> NULL");
				current = current.next;
			}
			return sb.toString();
		}
	}
}
