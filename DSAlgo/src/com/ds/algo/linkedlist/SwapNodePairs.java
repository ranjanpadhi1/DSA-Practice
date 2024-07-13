package com.ds.algo.linkedlist;

public class SwapNodePairs {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		list.add(60);
		list.traverse(list.head);
		list.traverse(list.swapPairs());
	}

	private static class LinkedList {
		Node head;

		static class Node {
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

		public Node swapPairs() {
			if (head == null || head.next == null)
				return head;
			// Swap head
			Node temp = head;
			head = head.next;
			temp.next = head.next;
			head.next = temp;

			// Swap pairs
			Node current = head.next;
			while (current != null && current.next != null && current.next.next != null) {
				temp = current.next;
				current.next = temp.next;
				temp.next = current.next.next;
				current.next.next = temp;
				current = current.next.next;
			}
			return head;
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

		public void traverse(Node head) {
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
