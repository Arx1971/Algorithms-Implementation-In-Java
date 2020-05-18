package AdvancedDataStructure.Trie;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Trie trie = new Trie();
        trie.inset("Megatron");
        System.out.println(trie.searchPrefix("Me"));

    }

}

class Trie {

    public class TrieNode {
        Map<Character, TrieNode> map;
        boolean isEndOfTheWord;

        TrieNode() {
            map = new HashMap<>();
            isEndOfTheWord = false;
        }
    }

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void inset(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode node = current.map.get(word.charAt(i));
            if (node == null) {
                node = new TrieNode();
                current.map.put(word.charAt(i), node);
            }
            current = node;
        }
        current.isEndOfTheWord = true;
    }

    public TrieNode searchForTrieNode(String word) {

        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            TrieNode node = current.map.get(word.charAt(i));
            if (node == null) return null;
            current = node;
        }
        return current;
    }

    public boolean searchWord(String word) {
        TrieNode node = searchForTrieNode(word);
        return node != null && node.isEndOfTheWord;
    }

    public boolean searchPrefix(String prefix) {
        TrieNode node = searchForTrieNode(prefix);
        return node != null;
    }

}
