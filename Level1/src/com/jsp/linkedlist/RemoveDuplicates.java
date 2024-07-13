package com.jsp.linkedlist;

public class RemoveDuplicates {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add(10);
		list.add(10);
		list.add(20);
		list.add(20);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(40);
		list.add(50);
		list.add(60);
		list.add(60);
		System.out.println(list);
		list.removeDuplicates();
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

		Node head;
		Node tail;

		public Node removeDuplicates() {
			Node prev = null, current = head;

			while (current != null) {
				if (prev != null && prev.data == current.data)
					prev.next = current.next;
				else
					prev = current;

				current = current.next;
			}
			return head;
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
