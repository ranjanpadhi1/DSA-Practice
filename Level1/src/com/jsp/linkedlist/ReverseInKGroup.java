package com.jsp.linkedlist;

public class ReverseInKGroup {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		list.add(60);
		list.add(70);
		list.add(80);
		System.out.println(list);
		list.print(list.reverseInKGroup(list.head, 8));
	}

	static class LinkedList {
		static class Node {
			int val;
			Node next;

			public Node(int val) {
				this.val = val;
			}
		}

		Node head;
		Node tail;

		public void add(int val) {
			Node newNode = new Node(val);
			if (head == null)
				head = tail = new Node(val);
			else {
				Node curr = head;
				while (curr.next != null)
					curr = curr.next;
				curr.next = tail = newNode;
			}
		}

		private Node kHead, kTail;

		private void addFirstNode(Node node) {
			if (kHead == null)
				kHead = kTail = node;
			else {
				node.next = kHead;
				kHead = node;
			}
		}

		public Node reverseInKGroup(Node head, int k) {
			if (head == null || head.next == null || k == 0)
				return head;

			Node newHead = null, newTail = null;
			int size = this.size();
			Node current = head;
			while (size >= k) {
				for (int i = 0; i < k; i++) {
					Node next = current.next;
					current.next = null;
					addFirstNode(current);
					current = next;
				}
				if (newHead == null) {
					newHead = kHead;
					newTail = kTail;
				} else {
					newTail.next = kHead;
					newTail = kTail;
				}
				kHead = kTail = null;
				size -= k;
			}

			if (newTail != null)
				newTail.next = current;

			return newHead;
		}

		public int size() {
			int size = 0;
			Node curr = head;
			while (curr != null) {
				curr = curr.next;
				size++;
			}
			return size;
		}

		public void print(Node head) {
			StringBuffer sb = new StringBuffer("[");
			Node curr = head;
			while (curr != null) {
				sb.append(curr.val);
				sb.append(curr.next != null ? ", " : "");
				curr = curr.next;
			}
			System.out.println(sb.append("]").toString());
		}

		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer("[");
			Node curr = head;
			while (curr != null) {
				sb.append(curr.val);
				sb.append(curr.next != null ? ", " : "");
				curr = curr.next;
			}
			return sb.append("]").toString();
		}
	}
}
