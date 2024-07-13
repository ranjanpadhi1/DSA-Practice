package com.ds.algo.linkedlist;

import java.util.LinkedHashMap;
import java.util.Map;

public class CloneLinkedList {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.traverse(list.head);
		list.traverse(list.clone());
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

		public Node clone() {
			if (head == null)
				return head;
			Map<Node, Node> map = new LinkedHashMap<>();
			Node nHead = new Node(head.data), current = head.next, nCurrent = nHead;
			map.put(head, nHead);
			while (current != null) {
				Node newNode = new Node(current.data);
				nCurrent.next = newNode;
				nCurrent = nCurrent.next;
				map.put(current, nCurrent);
				current = current.next;
			}
			System.out.println(map);
			return nHead;
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
