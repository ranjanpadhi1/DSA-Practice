package com.dsa.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class DesignMaxFrequencyStack {
	public static void main(String[] args) {
		MaxFreqStack stack = new MaxFreqStack();
		stack.push(4);
		stack.push(0);
		stack.push(9);
		stack.push(3);
		stack.push(4);
		stack.push(2);
		System.out.println(stack.pop());
		stack.push(6);
		System.out.println(stack.pop());
		stack.push(1);
		System.out.println(stack.pop());
		stack.push(1);
		System.out.println(stack.pop());
		stack.push(4);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

	static class MaxFreqStack {

		private int maxFreq;
		private Map<Integer, Integer> freqMap;
		private Map<Integer, Stack<Integer>> freqStackMap;

		public MaxFreqStack() {
			this.maxFreq = 0;
			this.freqMap = new HashMap<>();
			this.freqStackMap = new HashMap<>();
		}

		public void push(int val) {
			int freq = freqMap.getOrDefault(val, 0) + 1;
			freqMap.put(val, freq);

			if (freqStackMap.containsKey(freq))
				freqStackMap.get(freq).push(val);
			else {
				Stack<Integer> stack = new Stack<>();
				stack.push(val);
				freqStackMap.put(freq, stack);
			}
			maxFreq = Math.max(maxFreq, freq);
		}

		public int pop() {
			if (maxFreq == 0)
				return -1;
			Stack<Integer> stack = freqStackMap.get(maxFreq);
			int val = stack.pop();
			if (freqMap.get(val) == 1)
				freqMap.remove(val);
			else
				freqMap.put(val, freqMap.get(val) - 1);

			if (stack.isEmpty())
				freqStackMap.remove(maxFreq--);

			return val;
		}
	}

	/**
	 * Your FreqStack object will be instantiated and called as such:
	 * FreqStack obj = new FreqStack();
	 * obj.push(val);
	 * int param_2 = obj.pop();
	 */
}
