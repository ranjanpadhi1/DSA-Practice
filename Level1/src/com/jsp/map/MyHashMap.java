package com.jsp.map;

import java.util.LinkedList;
import java.util.List;

public class MyHashMap {
	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("A", 100);
		map.put("B", 200);
		map.put("C", 400);
		map.put("D", 300);
		map.put("E", 600);
		map.put("F", 700);
		System.out.println(map);
		System.out.println(map.get("A"));
		System.out.println(map.get("Z"));
		System.out.println(map.containsKey("B"));
		System.out.println(map.containsKey("Z"));
		System.out.println(map.remove("E"));
		map.put("G", 450);
		map.put("H", 310);
		map.put("I", 620);
		map.put("J", 540);
		System.out.println(map);
	}

	static class HashMap<K, V> {
		class Node {
			K key;
			V value;

			public Node(K key, V value) {
				this.key = key;
				this.value = value;
			}

			@Override
			public String toString() {
				return key + "=" + value;
			}
		}

		LinkedList<Node>[] hashTable;

		private int size;
		private int bucketSize;
		private double loadFactor;

		public HashMap() {
			this(2);
		}

		public HashMap(double loadFactor) {
			this.loadFactor = loadFactor;
			createHashtable(4);
		}

		@SuppressWarnings("unchecked")
		private void createHashtable(int bucketSize) {
			this.size = 0;
			this.bucketSize = bucketSize;

			hashTable = new LinkedList[this.bucketSize];
			for (int i = 0; i < hashTable.length; i++) {
				hashTable[i] = new LinkedList<>();
			}
		}

		public void put(K key, V value) {
			int bucket = getBucket(key);
			for (Node node : hashTable[bucket]) {
				if (node.key.equals(key)) {
					node.value = value;
					return;
				}
			}
			size++;
			hashTable[bucket].add(new Node(key, value));

			double lambda = size * 1.0 / bucketSize;
			if (lambda > loadFactor) {
				reHash();
			}
		}

		private void reHash() {
			List<Node>[] oldTable = hashTable;

			createHashtable(this.bucketSize * 2);

			for (List<Node> bucket : oldTable) {
				for (Node node : bucket)
					put(node.key, node.value);
			}
		}

		public V get(K key) {
			for (Node node : hashTable[getBucket(key)]) {
				if (node.key == key)
					return node.value;
			}
			return null;
		}

		public boolean containsKey(K key) {
			for (Node node : hashTable[getBucket(key)]) {
				if (node.key == key)
					return true;
			}
			return false;
		}

		public V remove(K key) {
			List<Node> bucket = hashTable[getBucket(key)];
			for (int i = 0; i < bucket.size(); i++) {
				Node node = bucket.get(i);
				if (node.key == key) {
					size--;
					return bucket.remove(i).value;
				}
			}
			return null;
		}

		private int getBucket(K key) {
			return Math.abs(key.hashCode()) % bucketSize;
		}

		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer("{");
			for (int i = 0; i < hashTable.length; i++) {
				LinkedList<Node> list = hashTable[i];
				sb.append("[");
				for (int j = 0; j < list.size(); j++) {
					sb.append(list.get(j));
					sb.append(j == list.size() - 1 ? "" : ", ");
				}
				sb.append(i == hashTable.length - 1 ? "]" : "], ");
			}
			return sb.append("}").toString();
		}
	}
}
