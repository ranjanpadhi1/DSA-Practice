package com.jsp.map;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import com.jsp.linkedlist.MyLinkedList.LinkedList;
import com.jsp.linkedlist.MyLinkedList.LinkedList.Node;

public class MergeKSortedList {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add(1);
		list.add(4);
		list.add(5);

		LinkedList list2 = new LinkedList();
		list2.add(1);
		list2.add(3);
		list2.add(4);

		LinkedList list3 = new LinkedList();
		list3.add(2);
		list3.add(6);

		List<LinkedList> kLists = new ArrayList<>();
		kLists.add(list);
		kLists.add(list2);
		kLists.add(list3);
		list.print(merge(kLists));
	}

	static class Pair implements Comparable<Pair> {
		Node node;

		public Pair(Node node) {
			this.node = node;
		}

		@Override
		public int compareTo(Pair o) {
			return Integer.compare(node.data, o.node.data);
		}
	}

	private static Node merge(List<LinkedList> kLists) {
		Node dummy = new Node(-1), current = dummy;

		PriorityQueue<Pair> queue = new PriorityQueue<>();
		for (LinkedList list : kLists) {
			queue.add(new Pair(list.head));
		}

		while (!queue.isEmpty()) {
			Pair pair = queue.remove();
			current.next = pair.node;
			current = current.next;
			if (pair.node.next != null)
				queue.add(new Pair(pair.node.next));
		}

		return dummy.next;
	}
}
