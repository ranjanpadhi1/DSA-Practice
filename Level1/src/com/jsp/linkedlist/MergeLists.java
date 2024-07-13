package com.jsp.linkedlist;

public class MergeLists {
	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		list1.add(10);
		list1.add(20);
		list1.add(40);

		LinkedList list2 = new LinkedList();
		list2.add(10);
		list2.add(30);
		list2.add(40);

		System.out.println(list1);
		System.out.println(list2);
		list1.print(list1.merge(list2));
	}

	private static class LinkedList {
		public static class Node {
			int data;
			Node next;

			public Node(int data) {
				this.data = data;
			}
		}

		Node head;
		Node tail;

		public Node merge(LinkedList list2) {
			Node p1 = head, p2 = list2.head, dummy = new Node(-1), head = dummy;

			while (p1 != null && p2 != null) {
				if (p1.data < p2.data) {
					dummy.next = p1;
					p1 = p1.next;
				} else {
					dummy.next = p2;
					p2 = p2.next;
				}
				dummy = dummy.next;
			}

			if (p1 != null)
				dummy.next = p1;

			if (p2 != null)
				dummy.next = p2;

			return head.next;
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
