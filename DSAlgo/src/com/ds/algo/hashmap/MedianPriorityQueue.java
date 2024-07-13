package com.ds.algo.hashmap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianPriorityQueue {

	public static void main(String[] args) {
		MedianQueue queue = new MedianQueue();
		queue.add(10);
		queue.add(20);
		queue.add(30);
		queue.add(40);
		queue.add(5);
		queue.add(7);
		queue.remove();
		queue.add(12);
		queue.remove();
		queue.add(70);
		queue.remove();
		System.out.println(queue.median());
	}

	static class MedianQueue {
		PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> right = new PriorityQueue<>();

		public void add(int num) {
			if (right.peek() == null || num > right.peek())
				right.add(num);
			else
				left.add(num);

			if (right.size() - left.size() == 2)
				left.add(right.remove());
			else if (left.size() - right.size() == 2)
				right.add(left.remove());
		}

		public int remove() {
			if (left.size() >= right.size())
				return left.remove();
			else
				return right.remove();
		}

		public int median() {
			if (left.size() >= right.size())
				return left.peek();
			else
				return right.peek();
		}

	}
}
