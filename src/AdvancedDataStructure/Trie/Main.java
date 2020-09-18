package AdvancedDataStructure.Trie;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        String[] words = {"bat", "bad", "ball", "base", "mad", "max", "megatron", "prime", "prince"};
        String[] prefixStrings = {"ba", "ab", "m", "maxx", "meg", "pri", "prim"};

        Trie trieStructure = new Trie();

        for (String word : words) trieStructure.insert(word);

        for (String prefix : prefixStrings) {
            System.out.println(prefix + " " + trieStructure.searchPrefix(prefix));
        }

    }
}

class Trie {

    public class TrieNode {
        Map<Character, TrieNode> map;
        boolean isWord;

        public TrieNode() {
            this.map = new HashMap<>();
            this.isWord = false;
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode newNode = current.map.get(word.charAt(i));
            if (newNode == null) {
                newNode = new TrieNode();
                current.map.put(word.charAt(i), newNode);
            }
            current = newNode;
        }
        current.isWord = true;
    }

    public boolean searchPrefix(String prefix) {
        TrieNode current = root;

        for (int i = 0; i < prefix.length(); i++) {
            TrieNode newNode = current.map.get(prefix.charAt(i));
            if (newNode == null) return false;
            else current = newNode;
        }
        return true;
    }

}
