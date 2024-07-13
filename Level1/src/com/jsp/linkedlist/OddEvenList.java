package com.jsp.linkedlist;

public class OddEvenList {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		System.out.println(list);
		list.print(list.oddEvenList());

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

		public Node oddEvenList() {
			Node odd = new Node(-1), even = new Node(-1), oddHead = odd, evenHead = even, current = head;

			while (current != null) {
				if (current.data % 2 == 0) {
					even.next = current;
					even = even.next;
				} else {
					odd.next = current;
					odd = odd.next;
				}
				current = current.next;
			}

			// Update next of last node to null
			even.next = null;
			// Join odd and even list
			odd.next = evenHead.next;

			return oddHead.next;
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
