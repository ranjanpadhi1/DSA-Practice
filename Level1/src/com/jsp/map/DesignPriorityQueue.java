package com.jsp.map;

import java.util.ArrayList;

public class DesignPriorityQueue {
	public static void main(String[] args) {
		PriorityQueue queue = new PriorityQueue();
		queue.add(10);
		queue.add(20);
		queue.add(30);
		queue.add(40);
		queue.add(50);
		queue.add(42);
		queue.add(60);
		queue.add(70);
		queue.add(6);
		queue.add(65);
		queue.add(72);
		queue.add(45);
		queue.add(5);
		queue.printLevels();
		System.out.println(queue.peek());
		System.out.println(queue.heap);
		System.out.println(queue.remove());
		System.out.println(queue.heap);
		System.out.println(queue.remove());
		System.out.println(queue.heap);
		System.out.println(queue.remove());
		System.out.println(queue.heap);
		System.out.println(queue.remove());
		queue.add(38);
		System.out.println(queue.heap);
		System.out.println(queue.remove());
		System.out.println(queue.heap);
		System.out.println(queue.remove());
		System.out.println(queue.heap);
		System.out.println(queue.remove());
		System.out.println(queue.heap);
		System.out.println(queue.peek());
	}

	static class PriorityQueue {

		ArrayList<Integer> heap;

		public PriorityQueue() {
			heap = new ArrayList<>();
		}

		public void printLevels() {
		}

		public void add(int val) {
			heap.add(val);

			// Heapify
			int idx = heap.size() - 1;
			while (heap.get(getParent(idx)) > heap.get(idx)) {
				int parentIdx = getParent(idx);
				swap(idx, parentIdx);
				idx = parentIdx;
			}
		}

		public int remove() {
			int peek = heap.get(0);
			heap.set(0, heap.remove(heap.size() - 1));

			// Down Heapify
			int idx = 0;
			while (idx < heap.size()) {
				int left = getLeft(idx), right = getRight(idx);
				if (left >= heap.size() || right >= heap.size())
					break;

				int minIdx = heap.get(left) < heap.get(right) ? left : right;
				if (heap.get(idx) < heap.get(minIdx)) {
					break;
				}
				swap(minIdx, idx);
				idx = minIdx;
			}

			return peek;
		}

		private void swap(int i, int j) {
			int ith = heap.get(i);
			int jth = heap.get(j);
			heap.set(i, jth);
			heap.set(j, ith);
		}

		public int peek() {
			return heap.get(0);
		}

		private int getParent(int idx) {
			return (idx - 1) / 2;
		}

		private int getLeft(int idx) {
			return (2 * idx) + 1;
		}

		private int getRight(int idx) {
			return (2 * idx) + 2;
		}

	}
}
