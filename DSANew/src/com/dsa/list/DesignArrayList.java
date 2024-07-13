package com.dsa.list;

public class DesignArrayList {
	public static void main(String[] args) {
		MyArrayList list = new MyArrayList();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		System.out.println(list);
		list.removeLast();
		System.out.println(list);
		System.out.println(list.get(2));
	}

	static class MyArrayList {
		int[] arr;
		int end;

		public MyArrayList() {
			arr = new int[10];
			end = -1;
		}

		public void removeLast() {
			end--;
		}

		public void add(int val) {
			arr[++end] = val;
			if (end > arr.length / 2)
				resize();
		}

		public int get(int index) {
			return arr[index];
		}

		private void resize() {

		}

		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer();

			for (int i = 0; i <= end; i++) {
				sb.append(arr[i] + " ");
			}
			return sb.toString();
		}

	}
}
