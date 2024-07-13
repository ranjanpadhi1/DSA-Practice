package com.ds.algo.linkedlist;

public class EvenOrOdd {
	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		list1.head = new LinkedList.Node(10);
		list1.head.next = new LinkedList.Node(20);
		list1.head.next.next = new LinkedList.Node(30);
		System.out.println(list1.evenOrOdd());

		LinkedList list2 = new LinkedList();
		list2.head = new LinkedList.Node(10);
		list2.head.next = new LinkedList.Node(20);
		list2.head.next.next = new LinkedList.Node(30);
		list2.head.next.next.next = new LinkedList.Node(40);
		System.out.println(list2.evenOrOdd());
	}

	private static class LinkedList {
		Node head;

		private static class Node {
			Node next;

			public Node(int data) {
			}
		}

		public String evenOrOdd() {
			Node current = head;
			// Traverse to the last node
			while (current != null && current.next != null)
				current = current.next.next;
			return current == null ? "EVEN" : "ODD";
		}
	}

}