package com.ds.algo.stack;

public class DesignMinStackUsingList {
	public static void main(String[] args) {
		MinStack stack = new MinStack();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		System.out.println(stack);
		System.out.println(stack.getMin());
		stack.push(5);
		System.out.println(stack);
		System.out.println(stack.getMin());
		stack.push(12);
		System.out.println(stack);
		System.out.println(stack.getMin());
		System.out.println(stack.peek());
		stack.pop();
		stack.pop();
		System.out.println(stack);
		System.out.println(stack.getMin());
		stack.push(3);
		System.out.println(stack.getMin());
	}

	private static class MinStack {

		private class Node {
			int val;
			int minVal;
			Node next;

			Node(int val, int minVal) {
				this.val = val;
				this.minVal = minVal;
			}
		}

		Node head;

		public void push(int val) {
			if (head == null)
				head = new Node(val, val);
			else {
				Node newNode = new Node(val, Math.min(head.minVal, val));
				newNode.next = head;
				head = newNode;
			}
		}

		public void pop() {
			if (head != null)
				head = head.next;
		}

		public int peek() {
			return head.val;
		}

		public int getMin() {
			return head.minVal;
		}

		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer("[");
			Node current = head;
			while (current != null) {
				sb.append(current.val);
				sb.append(current.next != null ? ", " : "");
				current = current.next;
			}
			return sb.append("]").toString();
		}

	}

}
