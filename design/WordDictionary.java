package design;

/**
 * LeetCode211. Add and Search Word - Data structure design
 *
 * Design a data structure that supports the following two operations:
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A .
 * means it can represent any one letter.
 *
 * Example:
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 *
 * Solution: The basic idea is the same with leetcod 208, we could define build a Trie, and store all the word's character
 * into the Trie. And then search from the root to the leaf in the Trie. For the special case '.', we could get all the current
 * node's links, and check there is a possible way to find the rest of the word in this links.
 */
public class WordDictionary {
    TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.containsKey(c)) {
                node.put(c, new TrieNode());
            }
            node = node.get(c);
        }
        //set isEnd mark
        node.setEnd();
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        //search from the root of the trie
        return match(word, 0, root);
    }

    public boolean match(String word, int k, TrieNode node) {
        if (k == word.length()) {
            //find all the character in the trie, also need to check whether the last node is the end node
            return node.isEnd();
        }
        char c = word.charAt(k);
        if (c != '.') {
            //check whether current character is in the trie, if so, keep looking for it's next character, if not, return false
            return node.containsKey(c) && match(word, k+1, node.get(c));
        } else {
            TrieNode[] links = node.getLinks();
            for (TrieNode link : links) {
                //iterate through all the links and do the searching
                if (link != null) {
                    if (match(word, k+1, link)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    class TrieNode {
        TrieNode[] links;
        boolean isEnd;

        public TrieNode() {
            links = new TrieNode[26];
        }

        public void put(char c, TrieNode node) {
            links[c - 'a'] = node;
        }

        public TrieNode get(char c) {
            return links[c - 'a'];
        }

        public boolean containsKey(char c) {
            return links[c - 'a'] != null;
        }

        public TrieNode[] getLinks() {
            return links;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }

}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */