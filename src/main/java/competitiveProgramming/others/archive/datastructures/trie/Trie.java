package competitiveProgramming.others.archive.datastructures.trie;

import java.util.Map;

public class Trie {
    private final TrieNode root = new TrieNode();

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("ABC");
        trie.insert("ABD");
        System.out.println(trie.search("ABD"));
    }

    public void insert(String str) {
        TrieNode node = root;
        char[] arr = str.toCharArray();

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


    public boolean search(String str) {
        TrieNode node = root;
        char[] arr = str.toCharArray();
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
}
