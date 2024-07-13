package com.jsp.linkedlist;

public class MyLinkedList {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
//		java.util.LinkedList<Integer> list = new java.util.LinkedList();
		list.add(10);
		list.addFirst(10);
		list.add(20);
		list.addFirst(20);
		list.add(30);
		list.addFirst(30);
		list.add(40);
		list.addFirst(40);
		list.add(50);

		System.out.println(list);
		System.out.println(list.size());
		list.removeFirst();
		System.out.println(list);
		System.out.println(list.size());
		list.removeLast();
		System.out.println(list);
		list.reverse();
		System.out.println(list);
		System.out.println(list.kthFromEnd(2));
		System.out.println(list.findMiddle());
	}

	public static class LinkedList {
		public static class Node {
			public int data;
			public Node next;

			public Node(int data) {
				this.data = data;
			}
		}

		public Node head;
		public Node tail;
		private int size;

		public int size() {
			return size;
		}

		public int findMiddle() {
			Node slow = head, fast = head;

			while (fast != null && fast.next != null) {
				slow = slow.next;
				fast = fast.next.next;
			}
			return slow.data;
		}

		public int kthFromEnd(int k) {
			Node slow = head, fast = head;
			for (int i = 0; i < k; i++) {
				fast = fast.next;
			}

			while (fast != null) {
				slow = slow.next;
				fast = fast.next;
			}

			return slow.data;
		}

		public void reverse() {
			Node current = head, prev = null, next = null;

			while (current != null) {
				next = current.next;
				current.next = prev;
				prev = current;
				current = next;
			}
			head = prev;
		}

		public void add(int data) {
			Node newNode = new Node(data);
			if (head == null)
				head = tail = newNode;
			else {
				tail.next = newNode;
				tail = newNode;
			}
			size++;
		}

		public void removeFirst() {
			if (head != null) {
				head = head.next;
				size--;
			}
			if (head == null)
				tail = null;
		}

		public void removeLast() {
			Node current = head;
			if (current == null)
				return;
			else if (current.next == null)
				head = tail = null;
			else {
				while (current.next.next != null) {
					current = current.next;
				}
				current.next = null;
				tail = current;
			}
		}

		public void addFirst(int data) {
			Node newNode = new Node(data);
			newNode.next = head;
			head = newNode;
			if (tail == null)
				tail = head;
			size++;
		}

		public void print(Node head) {
			StringBuffer sb = new StringBuffer("[");
			Node current = head;
			while (current != null) {
				sb.append(current.data);
				sb.append(current.next != null ? ", " : "");
				current = current.next;
			}
			sb.append("]").toString();
			System.out.println(sb);
		}

		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer("[");
			Node current = head;
			while (current != null) {
				sb.append(current.data);
				sb.append(current.next != null ? ", " : "");
				current = current.next;
			}
			return sb.append("]").toString();
		}
	}
}
