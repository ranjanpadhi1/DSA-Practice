package com.dsa.list;

public class DesignLinkedList {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.addFirst(40);
		list.addFirst(50);

		System.out.println(list);
		list.addAtIndex(2, 60);

		System.out.println(list);
		list.removeAtIndex(0);
		System.out.println(list);
	}

	static class LinkedList<E> {

		static class Node<E> {
			E val;
			Node<E> next;

			public Node(E val) {
				this.val = val;
			}

			@Override
			public String toString() {
				return val + "";
			}
		}

		private Node<E> head;

		public void add(E val) {
			Node<E> newNode = new Node<>(val);

			if (head == null)
				head = newNode;
			else {
				Node<E> curr = head;

				while (curr.next != null)
					curr = curr.next;

				curr.next = newNode;
			}
		}

		public void removeAtIndex(int index) {
			if (index == 0) {
				head = head.next;
				return;
			}

			Node<E> curr = head;

			for (int i = 0; i < index - 1; i++) {
				curr = curr.next;
			}

			curr.next = curr.next.next;

		}

		public void addAtIndex(int index, E val) {
			Node<E> newNode = new Node<>(val);

			if (index == 0) {
				newNode.next = head.next;
				head = newNode;
				return;
			}

			Node<E> curr = head;

			for (int i = 0; i < index - 1; i++) {
				curr = curr.next;
			}

			newNode.next = curr.next;
			curr.next = newNode;
		}

		public void addFirst(E val) {
			Node<E> newNode = new Node<>(val);
			newNode.next = head;
			head = newNode;
		}

		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer("[");
			Node<E> curr = head;

			while (curr != null) {
				sb.append(curr.val);

				if (curr.next != null)
					sb.append(", ");

				curr = curr.next;
			}

			return sb.append("]").toString();
		}
	}
}
