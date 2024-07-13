package com.jsp.linkedlist;

public class PalindromeList {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(2);
		list.add(1);
		System.out.println(list);
		System.out.println(list.isPalindrome());
		System.out.println(list.isPalindromeR());
	}

	private static class LinkedList {
		public static class Node {
			int data;
			Node next;

			public Node(int data) {
				this.data = data;
			}

			@Override
			public String toString() {
				return data + "";
			}
		}

		Node head;
		Node tail;

		public boolean isPalindrome() {
			Node midNode = getMidAndUnlink();
			Node start = head, end = this.reverseList(midNode);

			while (start != null && end != null) {
				if (start.data != end.data)
					return false;
				start = start.next;
				end = end.next;
			}

			return true;
		}

		private Node left;

		private boolean palHelper(Node right) {
			if (right != null) {
				if (!palHelper(right.next))
					return false;
				if (right.data != left.data)
					return false;
				left = left.next;
			}
			return true;
		}

		public boolean isPalindromeR() {
			left = head;
			return palHelper(head);
		}

		private Node getMidAndUnlink() {
			Node slow = null, fast = head;

			while (fast != null && fast.next != null) {
				slow = slow == null ? head : slow.next;
				fast = fast.next.next;
			}

			Node mid = slow.next;
			slow.next = null;
			return mid;
		}

		private Node reverseList(Node head) {
			Node prev = null, current = head;
			while (current != null) {
				Node next = current.next;
				current.next = prev;
				prev = current;
				current = next;
			}
			return prev;
		}

		public void add(int data) {
			Node newNode = new Node(data);
			if (head == null)
				head = tail = newNode;
			else {
				tail.next = newNode;
				tail = newNode;
			}
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
