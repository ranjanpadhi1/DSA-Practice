package com.dsa.hashmap;

import java.util.HashMap;
import java.util.Map;

public class DesignLRUCache2 {
	public static void main(String[] args) {
		LRUCache<String, Integer> cache = new LRUCache<>(3);
		cache.put("a", 10);
		cache.put("b", 20);
		cache.put("c", 30);
		System.out.println("---------------------");

		System.out.println("Put a, b , c");
		cache.print();
		System.out.println("---------------------");

		System.out.println("Get a ");
		System.out.println(cache.get("a"));
		cache.print();
		System.out.println("---------------------");

		System.out.println("Get x");
		System.out.println(cache.get("x"));
		System.out.println("---------------------");

		System.out.println("Put d-40");
		cache.put("d", 40);
		cache.print();
		System.out.println("---------------------");

		System.out.println("Put c-50");
		cache.put("c", 50);
		cache.print();
		System.out.println("---------------------");

		System.out.println("Put e-10");
		cache.put("e", 60);
		cache.print();
	}

	static class LRUCache<K, V> {
		static class Node<K, V> {
			K key;
			V val;
			Node<K, V> next;
			Node<V, V> prev;

			public Node(K key, V val) {
				this.key = key;
				this.val = val;
			}

			@Override
			public String toString() {
				return key + "-" + val;
			}
		}

		private int k;
		private Map<K, Node<K, V>> map;
		private Node<K, V> head, tail;

		public LRUCache(int k) {
			this.k = k;
			map = new HashMap<>();
			head = tail = null;
		}

		public void put(K key, V val) {
			if (map.containsKey(key)) {
				Node<K, V> node = removeNode(map.get(key));
				node.val = val;
				map.put(key, addFirst(node));
			} else if (map.size() == k) {
				Node<K, V> node = removeLast();
				map.remove(node.key);
				map.put(key, addFirst(new Node<>(key, val)));
			} else
				map.put(key, addFirst(new Node<>(key, val)));
		}

		public V get(K key) {
			if (map.containsKey(key)) {
				Node<K, V> node = removeNode(map.get(key));
				map.put(key, addFirst(node));
				return node.val;
			}
			return null;
		}

		@SuppressWarnings("unchecked")
		private Node<K, V> removeLast() {
			Node<K, V> node = tail;
			if (node == head) {
				head = tail = null;
				return null;
			} else if (tail != null) {
				tail = (Node<K, V>) tail.prev;
				tail.next = null;
			}
			node.prev = null;
			return node;
		}

		@SuppressWarnings("unchecked")
		private Node<K, V> removeNode(Node<K, V> node) {
			if (head != null && node == head) {
				head = head.next;
				head.prev = null;
			} else if (tail != null && node == tail) {
				tail = (Node<K, V>) tail.prev;
			} else {
				Node<K, V> prevNode = (Node<K, V>) node.prev, nextNode = node.next;
				prevNode.next = nextNode;
				nextNode.prev = (Node<V, V>) prevNode;
			}
			tail.next = null;
			node.prev = null;
			node.next = null;
			return node;
		}

		@SuppressWarnings("unchecked")
		private Node<K, V> addFirst(Node<K, V> newNode) {
			if (head == null)
				head = tail = newNode;
			else {
				head.prev = (Node<V, V>) newNode;
				newNode.next = head;
				head = newNode;
			}
			return newNode;
		}

		public void print() {
			System.out.println(map);
			StringBuffer sb = new StringBuffer("[");
			Node<K, V> curr = head;
			while (curr != null) {
				sb.append(curr.key + "-" + curr.val);
				sb.append(curr.next != null ? ", " : "");
				curr = curr.next;
			}
			System.out.println(sb.append("]").toString());
		}
	}

}
