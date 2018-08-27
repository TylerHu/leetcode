package backtracking;

/**
 * LeetCode131. Palindrome Partitioning(https://leetcode.com/problems/palindrome-partitioning/description/)
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 *
 * Solution: Use backtracking approach, check every substring if it is palindrome, it it's a palindrome, add it to the templist.
 * If the index equals to the string length, means we have reached the end of the string, add the templist to the result.
 */
public class PalindromePartition {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), s, 0);
        return result;
    }

    public void backtrack(List<List<String>> result, List<String> temp, String s, int index) {
        if (index == s.length()) {
            result.add(new ArrayList(temp));
        } else {
            for (int i = index; i < s.length(); ++i) {
                if (isPalindrome(s, index, i)) {
                    //add substring(index, i+1) to the templist
                    temp.add(s.substring(index, i+1));
                    //backtrack next character
                    backtrack(result, temp, s, i+1);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }

    public boolean isPalindrome(String s, int start, int end) {
        //check whether substring(start, end) is palindrome
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}