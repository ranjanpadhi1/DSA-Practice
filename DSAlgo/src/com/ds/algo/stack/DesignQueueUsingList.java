package com.ds.algo.stack;

import java.util.ArrayList;
import java.util.List;

public class DesignQueueUsingList {
	public static void main(String[] args) {
		Queue queue = new Queue();
		queue.add(10);
		queue.add(20);
		queue.add(30);
		queue.add(40);
		System.out.println(queue);
		System.out.println(queue.remove());
		System.out.println(queue);
		System.out.println(queue.peek());
		System.out.println(queue);
	}

	private static class Queue {
		List<Integer> queue;

		public Queue() {
			queue = new ArrayList<>();
		}

		public void add(int val) {
			queue.add(val);
		}

		public int remove() {
			return queue.remove(0);
		}

		public int peek() {
			return queue.get(0);
		}

		@Override
		public String toString() {
			return queue.toString();
		}
	}
}
