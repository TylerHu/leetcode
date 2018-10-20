package design;

/**
 * LeetCode208. Implement Trie(Prefix Tree)
 *
 * Implement a trie with insert, search, and startsWith methods.
 * Example:Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 *
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 *
 * Solution: First define a TrieNode to reprsent the nodes in a Trie. There is an array in each TrieNode, stores the link
 * to it's next character node. Since all inputs are consist of lowercase letters, the maximum size of the links array is
 * 26. We also define handful methods to put character to the node, and get it's next corresponding character node.
 * For insertion operation to a Trie, we could check whether have a node with current character, if not, put a new node
 * to the current node. For searching operation, iterate all the characters in the word, and get it's corresponding node, if
 * there is no corresponding node, return false, or if the last node is not marked "end", return false, otherwise, return true.
 * For startswith operation, is similar to the searching operation, except that at the end, we just need to check whether
 * the last node is not the root of the Trie.
 *
 */
public class Trie {
    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.containsKey(c)) {
                //not found, create a new node and link to current node
                node.put(c, new TrieNode());
            }
            //iterate next corresponding node
            node = node.get(c);
        }
        //remember to set the last node as "end"
        node.setEnd();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.containsKey(c)) {
                //find current character's corresponding node
                node = node.get(c);
            } else {
                return false;
            }
        }
        //check whether the last node is the "end" node
        return node.isEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (node.containsKey(c)) {
                //found the current character's corresponding node
                node = node.get(c);
            } else {
                return false;
            }
        }
        //check whether the last node is the "root" node
        return node != root;
    }

    class TrieNode {
        TrieNode[] links;
        boolean isEnd;

        public TrieNode() {
            //init the array size to 26
            links = new TrieNode[26];
        }

        public void put(char c, TrieNode node) {
            //set link to character c node
            links[c - 'a'] = node;
        }

        public boolean containsKey(char c) {
            return links[c - 'a'] != null;
        }

        public TrieNode get(char c) {
            return links[c - 'a'];
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
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
