package com.jsp.trie;

public class DesignTrie {
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("apple");
		trie.insert("add");
		System.out.println(trie.startsWith("ap"));
		trie.insert("beer");
		System.out.println(trie.search("add"));
		System.out.println(trie.search("app"));
		System.out.println(trie.startsWith("app"));
		trie.insert("app");
		System.out.println(trie.search("apps"));
	}

	static class Trie {
		static class TrieNode {
			char val;
			TrieNode[] children;
			boolean isEnd;

			public TrieNode() {
				children = new TrieNode[26];
			}

			public TrieNode(char val) {
				this.val = val;
				children = new TrieNode[26];
			}

			public boolean containsKey(char ch) {
				return children[ch - 'a'] != null;
			}

			public TrieNode getChild(char ch) {
				return children[ch - 'a'];
			}

			public TrieNode put(char ch, TrieNode node) {
				children[ch - 'a'] = node;
				return node;
			}

			public void setEnd(boolean isEnd) {
				this.isEnd = isEnd;
			}

			public boolean isEnd() {
				return isEnd;
			}
		}

		TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		public void insert(String str) {
			TrieNode current = root;
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if (current.containsKey(ch))
					current = current.getChild(ch);
				else {
					current = current.put(ch, new TrieNode(ch));
				}
			}
			current.setEnd(true);
		}

		public boolean startsWith(String str) {
			TrieNode current = root;
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if (current.containsKey(ch))
					current = current.getChild(ch);
				else
					return false;
			}
			return true;
		}

		public boolean search(String str) {
			TrieNode current = root;
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if (current.containsKey(ch))
					current = current.getChild(ch);
				else
					return false;
			}
			return current.isEnd;
		}
	}
}
