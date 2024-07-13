package com.jsp.map;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class DesignMedianPriorityQueue {
	public static void main(String[] args) {
		MedianPriorityQueue pq = new MedianPriorityQueue();
		pq.add(30);
		pq.add(20);
		pq.add(50);
		pq.add(40);
		pq.add(10);
		pq.add(70);
		pq.add(60);
		System.out.println(pq.median());
		pq.remove();
		System.out.println(pq.median());
		pq.remove();
		System.out.println(pq.median());
	}

	static class MedianPriorityQueue {
		private Queue<Integer> q1, q2;

		public MedianPriorityQueue() {
			q1 = new PriorityQueue<>(Collections.reverseOrder());
			q2 = new PriorityQueue<>();
		}

		public void add(int val) {
			if (q1.isEmpty() || val < q1.peek()) {
				q1.add(val);
				if (q1.size() - q2.size() > 1) {
					q2.add(q1.remove());
				}
			} else {
				q2.add(val);
				if (q2.size() - q1.size() > 1) {
					q1.add(q2.remove());
				}
			}
		}

		public int remove() {
			if (q1.size() >= q2.size())
				return q1.remove();
			else
				return q2.remove();
		}

		public int median() {
			if (q1.isEmpty())
				return -1;
			if (q1.size() >= q2.size())
				return q1.peek();
			else
				return q2.peek();
		}
	}
}
