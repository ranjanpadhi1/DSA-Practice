package com.jsp.linkedlist;

public class ReverseData {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		System.out.println(list);
		list.reverseData();
		System.out.println(list);
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

		int size;
		Node head;
		Node tail;

		Node left;

		public void reverseData() {
			left = head;
			reverseR(head, 0);
		}

		private void reverseR(Node right, int floor) {
			if (right == null)
				return;
			reverseR(right.next, floor + 1);

			if (floor > size / 2) {
				int temp = right.data;
				right.data = left.data;
				left.data = temp;

				left = left.next;
			}
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
