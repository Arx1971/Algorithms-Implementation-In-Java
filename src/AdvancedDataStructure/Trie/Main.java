package AdvancedDataStructure.Trie;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        String[] words = {"bat", "bad", "ball", "base", "mad", "max", "megatron", "prime", "prince"};
        String[] prefixStrings = {"ba", "ab", "m", "maxx", "meg", "pri", "prim"};
        String[] searchWords = {"bad", "mad", "badman", "megatrons", "primes", "princes", "prine"};
        String[] wildWords = {"..d", ".ax", "..a", "b..d", "pr..c.", "..aa"};

        /*
         * Basic Trie Operations
         * */

        Trie trieStructure = new Trie();

        for (String word : words) trieStructure.insert(word);

        System.out.println("Search For Prefix: ");

        for (String prefix : prefixStrings) {
            System.out.println(prefix + " " + trieStructure.prefixSearch(prefix));
        }

        System.out.println("Search For word: ");

        for (String word : searchWords) {
            System.out.println(word + " " + trieStructure.wordSearch(word));
        }

        for (String word : wildWords) {
            System.out.println(word + " " + trieStructure.wildCardSearch(word));
        }

        /* Longest Common Prefix Using Trie*/

        System.out.println(new Trie().longestCommonPrefix(new String[]{"flower", "flow"}));
    }


}

class Trie {

    public static class TrieNode {
        Map<Character, TrieNode> map;
        boolean isWord;

        public TrieNode() {
            this.map = new HashMap<>();
            this.isWord = false;
        }
    }

    private final TrieNode root;

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

    public boolean prefixSearch(String prefix) {
        TrieNode current = root;

        for (int i = 0; i < prefix.length(); i++) {
            TrieNode newNode = current.map.get(prefix.charAt(i));
            if (newNode == null) return false;
            else current = newNode;
        }
        return true;
    }

    public boolean wordSearch(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode newNode = current.map.get(word.charAt(i));
            if (newNode == null) return false;
            else current = newNode;
        }
        return current.isWord;
    }

    public boolean wildCardSearch(String word) {
        return wildCardSearch(word, this.root, 0);
    }

    public boolean wildCardSearch(String word, TrieNode root, int index) {
        if (word.length() == index) return root.isWord;

        if (word.charAt(index) == '.') {
            for (Character ch : root.map.keySet()) {
                if (wildCardSearch(word, root.map.get(ch), index + 1)) return true;
            }
        } else {
            for (Character ch : root.map.keySet()) {
                if (word.charAt(index) == ch && wildCardSearch(word, root.map.get(ch), index + 1)) return true;
            }
        }

        return false;
    }

    public String longestCommonPrefix(String[] words) {
        if (words.length == 0) return "";
        Trie trie = new Trie();
        String searchString = null;
        for (String word : words) {
            if (searchString == null) {
                searchString = word;
            } else if (searchString.length() > word.length()) {
                searchString = word;
            }
            trie.insert(word);
        }
        return trie.commonPrefix(searchString);
    }

    public String commonPrefix(String word) {
        TrieNode current = root;
        if (current.map.size() > 1) return "";
        String longestCommonPrefix = "";
        for (int i = 0; i < word.length(); i++) {
            TrieNode newNode = current.map.get(word.charAt(i));
            if (newNode == null || newNode.map.size() > 1) return longestCommonPrefix + word.charAt(i);
            else {
                longestCommonPrefix += word.charAt(i);
                current = newNode;
            }
        }
        return longestCommonPrefix;
    }
}
