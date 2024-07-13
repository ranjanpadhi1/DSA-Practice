package com.dsa.hashmap;

import java.util.HashMap;
import java.util.Map;

public class DesignLRUCache {
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(3);
		// ["LRUCache","put","put","put","put","get","get","get","get","put","get","get","get","get","get"]
		// [[3],[1,1],[2,2],[3,3],[4,4],[4],[3],[2],[1],[5,5],[1],[2],[3],[4],[5]]
		cache.put(1, 1);
		cache.put(2, 2);
		cache.put(3, 3);
		cache.put(4, 4);
		System.out.println(cache.get(4));
		cache.print();
		System.out.println(cache.get(3));
		cache.print();
		System.out.println(cache.get(2));
		System.out.println(cache.get(1));
		cache.put(5, 5);
		System.out.println(cache.get(1));
		System.out.println(cache.get(2));
		System.out.println(cache.get(3));
		System.out.println(cache.get(4));
		System.out.println(cache.get(5));
	}

	static class LRUCache {
		static class Node {
			int key;
			int val;
			Node next;
			Node prev;

			public Node(int key, int val) {
				this.key = key;
				this.val = val;
			}

			@Override
			public String toString() {
				return key + "";
			}
		}

		private Map<Integer, Node> map;
		private Node head, tail;
		private int capacity;

		public LRUCache(int capacity) {
			this.capacity = capacity;
			map = new HashMap<>();
		}

		public int get(int key) {
			if (map.containsKey(key)) {
				Node node = removeNode(map.get(key));
				map.put(key, addFirst(node));
				return node.val;
			}
			return -1;
		}

		public void put(int key, int value) {
			if (map.containsKey(key)) {
				Node node = removeNode(map.get(key));
				node.val = value;
				map.put(key, addFirst(node));
			} else if (map.size() == capacity) {
				Node node = removeNode(tail);
				map.remove(node.key);
				map.put(key, addFirst(new Node(key, value)));
			} else
				map.put(key, addFirst(new Node(key, value)));
		}

		private Node addFirst(Node newNode) {
			if (head == null)
				head = tail = newNode;
			else {
				head.prev = newNode;
				newNode.next = head;
				head = newNode;
			}
			return newNode;
		}

		private Node removeNode(Node node) {
			if (head != null && node == head) {
				head = head.next;
				if (head != null)
					head.prev = null;
			} else if (tail != null && node == tail) {
				tail = tail.prev;
				if (tail != null)
					tail.next = null;
			} else {
				Node next = node.next, prev = node.prev;
				next.prev = prev;
				prev.next = next;
			}

			node.prev = null;
			node.next = null;
			return node;
		}

		public void print() {
			StringBuffer sb = new StringBuffer("[");
			Node curr = head;
			while (curr != null) {
				sb.append(curr.key + "-" + curr.val);
				sb.append(curr.next != null ? ", " : "");
				curr = curr.next;
			}
			System.out.println(sb.append("]").toString());

			StringBuffer sb2 = new StringBuffer("[");
			Node curr2 = tail;
			while (curr2 != null) {
				sb2.append(curr2.key + "-" + curr2.val);
				sb2.append(curr2.prev != null ? ", " : "");
				curr2 = curr2.prev;
			}
			System.out.println(sb2.append("]").toString());
		}
	}

	/**
	 * Your LRUCache object will be instantiated and called as such:
	 * LRUCache obj = new LRUCache(capacity);
	 * int param_1 = obj.get(key);
	 * obj.put(key,value);
	 */
}
