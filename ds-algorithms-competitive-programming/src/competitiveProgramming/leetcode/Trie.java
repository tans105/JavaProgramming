package competitiveProgramming.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
208. Implement Trie (Prefix Tree)

Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.
 */
public class Trie {
    private final TrieNode root;

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
    }

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode node = root;
        char[] arr = word.toCharArray();

        for (char c : arr) {
            Map<Character, TrieNode> children = node.children;
            if (children != null) {
                if (children.containsKey(c)) {
                    node = children.get(c);
                } else {
                    children.put(c, new TrieNode());
                    node = children.get(c);
                }
            }
        }

        node.endOfWord = true;

    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = root;
        char[] arr = word.toCharArray();
        boolean isPresent = true;

        for (char c : arr) {
            Map<Character, TrieNode> map = node.children;
            if (map.containsKey(c)) {
                node = map.get(c);
            } else {
                isPresent = false;
                break;
            }
        }

        if (!node.endOfWord) {
            isPresent = false;
        }

        return isPresent;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        char[] arr = prefix.toCharArray();
        TrieNode node = root;

        for (int i = 0; i < arr.length; i++) {
            Map<Character, TrieNode> mapping = node.children;
            if (!mapping.containsKey(arr[i])) {
                return false;
            }
            node = mapping.get(arr[i]);
        }
        return true;
    }
}

class TrieNode {
    public boolean endOfWord;
    public Map<Character, TrieNode> children;

    public TrieNode() {
        this.endOfWord = false;
        this.children = new HashMap<>();
    }
}

