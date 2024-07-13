package com.ds.algo.linkedlist;

public class RemoveNthNodeFromEnd {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		list.add(60);
		System.out.println(list);
		list.deleteFromEnd(2);
		System.out.println(list);
		LinkedList list2 = new LinkedList();
		list2.add(10);
		list2.add(20);
		System.out.println(list2);
		list2.deleteFromEnd(2);
		System.out.println(list2);
		LinkedList list3 = new LinkedList();
		list3.add(10);
		System.out.println(list3);
		list3.deleteFromEnd(2);
		System.out.println(list3);
		LinkedList list4 = new LinkedList();
		list4.add(10);
		System.out.println(list4);
		list4.deleteFromEnd(1);
		System.out.println(list4);
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

		public void deleteFromEnd(int n) {
			Node first = head, second = head;
			while (n-- > 0 && first != null)
				first = first.next;
			if (first == null)
				return;
			while (first.next != null) {
				first = first.next;
				second = second.next;
			}
			second.next = second.next != null ? second.next.next : null;
		}

		public void add(int data) {
			Node current = head, newNode = new Node(data);
			if (head == null)
				head = newNode;
			else {
				while (current.next != null)
					current = current.next;
				current.next = newNode;
			}
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