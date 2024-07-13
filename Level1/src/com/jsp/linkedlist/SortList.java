package com.jsp.linkedlist;

public class SortList {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add(2);
		list.add(8);
		list.add(1);
		list.add(7);
		list.add(4);
		list.add(6);
		list.add(5);
		list.add(8);
		System.out.println(list);
		list.print(list.sort(list.head));
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

		public Node sort(Node head) {
			if (head == null || head.next == null)
				return head;

			Node mid = getMid(head);
			Node l1 = sort(head);
			Node l2 = sort(mid);
			return merge(l1, l2);
		}

		private Node getMid(Node head) {
			Node midPrev = null;

			while (head != null && head.next != null) {
				midPrev = (midPrev == null) ? head : midPrev.next;
				head = head.next.next;
			}

			Node mid = midPrev.next;
			midPrev.next = null;
			return mid;
		}

		public Node merge(Node list1, Node list2) {
			Node p1 = list1, p2 = list2, dummy = new Node(-1), head = dummy;

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
