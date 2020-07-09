package datastructures.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    public boolean endOfWord;
    public Map<Character, TrieNode> children;

    public TrieNode() {
        this.endOfWord = false;
        this.children = new HashMap<>();
    }

    @Override
    public String toString() {
        return "TrieNode{" +
                "endOfWord=" + endOfWord +
                ", children=" + children +
                '}';
    }
}
