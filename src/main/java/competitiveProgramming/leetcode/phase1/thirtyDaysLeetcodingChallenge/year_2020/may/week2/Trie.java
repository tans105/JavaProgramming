package competitiveProgramming.leetcode.phase1.thirtyDaysLeetcodingChallenge.year_2020.may.week2;

import java.util.HashMap;
import java.util.Map;

/*
Implement Trie (Prefix Tree)

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

    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = this.root;
        char[] characters = word.toCharArray();

        for (Character ch : characters) {
            Map<Character, Node> dict = node.children;

            if (dict.containsKey(ch)) {
                node = dict.get(ch);
            } else {
                Node newNode = new Node();
                dict.put(ch, newNode);
                node = newNode;
            }
        }

        node.endOfWord = true;
    }

    public boolean search(String word) {
        return search(word, true);
    }

    public boolean startsWith(String prefix) {
        return search(prefix, false);
    }

    public boolean search(String word, boolean findComplete) {
        Node node = this.root;
        char[] characters = word.toCharArray();

        for (Character ch : characters) {
            Map<Character, Node> dict = node.children;

            if (dict.containsKey(ch)) {
                node = dict.get(ch);
            } else {
                return false;
            }
        }

        return !findComplete || node.endOfWord;
    }

    private static class Node {
        public boolean endOfWord;
        public Map<Character, Node> children;

        public Node() {
            this.endOfWord = false;
            this.children = new HashMap<>();
        }

        @Override
        public String toString() {
            return "Node{" +
                    "endOfWord=" + endOfWord +
                    ", children=" + children +
                    '}';
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        trie.insert("a");
        System.out.println(trie.search("a"));
        System.out.println(trie.startsWith("apd"));
    }
}
