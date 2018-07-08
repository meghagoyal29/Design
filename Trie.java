package LeetCode.Design;

import java.util.HashMap;

public class Trie {
	TrieNode root;
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("apple");
		System.out.println(trie.search("apple"));   // returns true
		System.out.println(trie.search("app"));     // returns false
		System.out.println(trie.startsWith("app")); // returns true
		trie.insert("app");   
		System.out.println(trie.search("app"));     // returns true
	}
	/** Initialize your data structure here. */
	public Trie() {
		root=new TrieNode('*');
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		TrieNode q = root;
		for(char c:word.toCharArray()) {
			if(q.children.containsKey(c)) {
				q=q.children.get(c);
				continue;
			}
			q.children.put(c, new TrieNode(c));
			q=q.children.get(c);
		}
		q.children.put('*', new TrieNode('*'));
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		TrieNode q = root;
		for(char c:word.toCharArray()) {
			if(!q.children.containsKey(c)) {
				return false;
			}
			q=q.children.get(c);
		}if(q.children.containsKey('*'))
			return true;
		return false;
	}

	/** Returns if there is any word in the trie that starts with the given prefix. */
	public boolean startsWith(String prefix) {
		TrieNode q = root;
		for(char c:prefix.toCharArray()) {
			if(!q.children.containsKey(c)) {
				return false;
			}
			q=q.children.get(c);
		}
		return true;

	}
}

class TrieNode{
	Character value;
	HashMap<Character,TrieNode> children;
	TrieNode(char c){
		value=c;
		children=new HashMap<>();
	}
}
