package com.ds.algo.stack;

public class DesignQueueUsingArray {
	public static void main(String[] args) {
		Queue queue = new Queue(3);
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		queue.add(5);
		System.out.println(queue);
		System.out.println(queue.peek());
		System.out.println(queue);
		System.out.println(queue.remove());
		queue.add(6);
		System.out.println(queue);
	}

	private static class Queue {
		int[] queue;
		int queueSize;
		int front;
		int size;

		public Queue(int maxSize) {
			queue = new int[maxSize];
			queueSize = queue.length;
			front = 0;
			size = 0;
		}

		public void add(int val) {
			if (size < queueSize) {
				int rear = (front + size) % queueSize;
				queue[rear] = val;
				size++;
			}
		}

		public int remove() {
			int val = queue[front];
			front = (front + 1) % queueSize;
			size--;
			return val;
		}

		public int peek() {
			return queue[front];
		}

		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer("[");
			for (int i = 0; i < size; i++) {
				int idx = (front + i) % queueSize;
				sb.append(queue[idx]);
				sb.append(i == size - 1 ? "" : ", ");
			}
			return sb.append("]").toString();
		}
	}
}
