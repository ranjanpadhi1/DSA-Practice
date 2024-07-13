package com.ds.algo.linkedlist;

public class ReverseList {
	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		list1.head = new LinkedList.Node(10);
		list1.head.next = new LinkedList.Node(20);
		list1.head.next.next = new LinkedList.Node(30);
		list1.head.next.next.next = new LinkedList.Node(40);
		list1.head.next.next.next.next = new LinkedList.Node(50);
		list1.head.next.next.next.next.next = new LinkedList.Node(60);
		list1.reverse();

		LinkedList list2 = new LinkedList();
		list2.head = new LinkedList.Node(10);
		list2.head.next = new LinkedList.Node(20);
		list2.head.next.next = new LinkedList.Node(30);
		list2.head.next.next.next = new LinkedList.Node(40);
		list2.head.next.next.next.next = new LinkedList.Node(50);
		list2.reverse();
	}

	private static class LinkedList {
		Node head;

		private static class Node {
			Node next;
			int data;

			public Node(int data) {
				this.data = data;
			}

			@Override
			public String toString() {
				return data + "";
			}
		}

		public void reverse() {
			Node prev = null, current = head, next = null;

			while (current != null) {
				next = current.next;
				current.next = prev;
				prev = current;
				current = next;
			}
			traverse(prev);
		}

		private void traverse(Node head) {
			Node current = head;
			while (current != null) {
				System.out.print(current.data);
				System.out.print(current.next != null ? " -> " : " -> NULL");
				current = current.next;
			}
			System.out.println();
		}
	}

}
