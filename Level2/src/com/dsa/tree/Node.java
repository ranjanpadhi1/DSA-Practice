package com.dsa.tree;

public class Node {
	int data;
	Node left;
	Node right;

	public Node(int data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return data + "";
	}
}
