package competitiveProgramming.leetcode.phase1.thirtyDaysLeetcodingChallenge.year_2020.august.week1;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/549/week-1-august-1st-august-7th/3413/

Add and Search Word - Data structure design
Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

Example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true

Note:
You may assume that all words are consist of lowercase letters a-z.
 */
public class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        char[] arr = word.toCharArray();

        for (char current : arr) {
            Map<Character, TrieNode> children = node.children;

            if (children.containsKey(current)) {
                node = children.get(current);
            } else {
                node = new TrieNode();
                children.put(current, node);
            }
        }

        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        return search(word, root);
    }

    private boolean search(String word, TrieNode node) {
        if (word.length() == 0 && node == null) return true;
        if (node == null) return false;

        char[] arr = word.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            char current = arr[i];
            Map<Character, TrieNode> children = node.children;

            if (current == '.') {
                if(children.size() > 0) {
                    for (Map.Entry<Character, TrieNode> entry : children.entrySet()) {
                        return search(word.substring(i + 1), entry.getValue());
                    }
                } else {
                    return false;
                }
            } else {
                if (children.containsKey(current)) {
                    node = children.get(current);
                } else {
                    return false;
                }
            }
        }

        return node.isEndOfWord;
    }

//    public static void main(String[] args) {
//        WordDictionary dict = new WordDictionary();
//        dict.addWord("a");
//        dict.addWord("a");
//
//        System.out.println(dict.search("a."));//f
//
//    }

    private static class TrieNode {
        boolean isEndOfWord;
        Map<Character, TrieNode> children;

        TrieNode() {
            this.children = new HashMap<>();
        }
    }


}


