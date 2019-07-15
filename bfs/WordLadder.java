package bfs;

/**
 * LeetCode127. Word Ladder(https://leetcode.com/problems/word-ladder/)
 *
 * Given two words (beginWord and endWord), and a dictionary's word list,
 * find the length of shortest transformation sequence from beginWord to endWord, such that:
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //switch to set will improve runtime from 1000ms to 15ms
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return 0;
        }
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visitedSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        int len = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
            Set<String> temp = new HashSet<>();
            for (String word : beginSet) {
                char[] characters = word.toCharArray();
                for (int i = 0; i < word.length(); ++i) {
                    char old = characters[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        characters[i] = c;
                        String target = String.valueOf(characters);
                        if (endSet.contains(target)) {
                            return len+1;
                        }
                        if (!visitedSet.contains(target) && dict.contains(target)) {
                            temp.add(target);
                            visitedSet.add(target);

                        }
                        characters[i] = old;
                    }
                }
            }
            beginSet = temp;
            len++;
        }
        return 0;
    }
}