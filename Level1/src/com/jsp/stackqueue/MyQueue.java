package com.jsp.stackqueue;

import java.util.EmptyStackException;

public class MyQueue {
	public static void main(String[] args) {
		Queue queue = new Queue(5);
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		System.out.println(queue);
		System.out.println("Dequeue: " + queue.dequeue());
		System.out.println(queue);
		System.out.println("Enqueue : 60");
		queue.enqueue(60);
		System.out.println(queue);
		System.out.println("Dequeue: " + queue.dequeue());
		System.out.println(queue);
		System.out.println("Enqueue : 70");
		queue.enqueue(70);
		System.out.println(queue);
		System.out.println("Enqueue : 80");
		queue.enqueue(80);
		System.out.println(queue);
	}

	static class Queue {
		private int capacity, front, rear, size;
		int[] queue;

		public Queue() {
			this(10);
		}

		public Queue(int capacity) {
			this.capacity = capacity;
			queue = new int[capacity];
		}

		public int dequeue() {
			if (size == 0)
				throw new EmptyStackException();
			size--;
			int idx = front;
			front = (front + 1) % capacity;
			return queue[idx];
		}

		public void enqueue(int data) {
			if (isFull()) {
				increaseCapacity();
			}
			queue[rear] = data;
			rear = (rear + 1) % capacity;
			size++;
		}

		private boolean isFull() {
			return size == capacity;
		}

		private void increaseCapacity() {
			capacity = capacity * 2;
			int[] newQueue = new int[capacity];
			for (int i = 0; i < size; i++) {
				int idx = (front + i) % size;
				newQueue[i] = queue[idx];
			}
			front = 0;
			rear = front + size;
			queue = newQueue;
		}

		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer("[");

			for (int i = 0; i < size; i++) {
				int idx = (front + i) % capacity;
				sb.append(queue[idx] + (i != size - 1 ? ", " : ""));
			}
			return sb.append("]").toString();
		}
	}
}
