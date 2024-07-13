package com.ds.algo.linkedlist;

public class TraverseLinkedList {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.head = new LinkedList.Node(10);
		list.head.next = new LinkedList.Node(20);
		list.head.next.next = new LinkedList.Node(30);
		list.head.next.next.next = new LinkedList.Node(40);
		list.head.next.next.next.next = new LinkedList.Node(50);
		list.head.next.next.next.next.next = new LinkedList.Node(60);
		list.traverse();
		list.traverseFast();
	}

	private static class LinkedList {
		Node head;

		private static class Node {
			int data;
			Node next;

			public Node(int data) {
				this.data = data;
			}
		}

		public void traverse() {
			Node current = head;
			while (current != null) {
				System.out.print(current.data);
				System.out.print(current.next != null ? " -> " : " -> NULL");
				current = current.next;
			}
			System.out.println();
		}

		public void traverseFast() {
			Node current = head;
			while (current != null && current.next != null) {
				System.out.print(current.data);
				System.out.print(current.next.next != null ? " -> " : " -> NULL");
				current = current.next.next;
			}
			System.out.println();
		}
	}
}
