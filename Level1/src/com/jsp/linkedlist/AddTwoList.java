package com.jsp.linkedlist;

public class AddTwoList {
	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		list1.add(9);
		list1.add(7);
		list1.add(4);
		list1.add(6);
		System.out.println(list1);

		LinkedList list2 = new LinkedList();
		list2.add(7);
		list2.add(0);
		list2.add(5);

		System.out.println(list2);
		list1.print(list1.add(list2));
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

		public Node add(LinkedList list2) {
			Node c1 = reverse(head), c2 = reverse(list2.head), c3 = new Node(-1), head = c3;
			int carry = 0;

			while (c1 != null || c2 != null) {
				int sum = carry;
				if (c1 != null) {
					sum += c1.data;
					c1 = c1.next;
				}

				if (c2 != null) {
					sum += c2.data;
					c2 = c2.next;
				}

				carry = sum / 10;
				c3.next = new Node(sum % 10);
				c3 = c3.next;
			}

			if (carry > 0)
				c3.next = new Node(carry);
			head = head.next;
			return reverse(head);
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

		public Node reverse(Node head) {
			Node current = head, prev = null, next = null;

			while (current != null) {
				next = current.next;
				current.next = prev;
				prev = current;
				current = next;
			}
			return prev;
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
