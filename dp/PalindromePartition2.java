package dp;

/**
 * LeetCode132. Palindrome Partitioning II(https://leetcode.com/problems/palindrome-partitioning-ii/description/)
 *
 *Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 *
 * Solution: If [j,i](j<=i) is palindrome, means [j+1, i-1] is palindrome, and s[i] == s[j]. Define a dp array cut, cut[i] represents
 * the minimum cuts for substring(0,i), if [j,i] is palindrome, cut[i] = cut[j-1] + 1
 */
public class PalindromePartition2 {
    public int minCut(String s) {
        int n = s.length();
        //dp array
        int[] cut = new int[n];
        //store the state of substring(i,j) is palindrome or not
        boolean[][] isPalindrome = new boolean[n][n];
        int min = 0;
        for (int i = 0; i < n; ++i) {
            //init min cut
            min = i;
            for (int j = 0; j <= i; ++j) {
                //if the lenght of (j,i) is less then 3, like aa or a, and if s[i] == s[j], appearently, [j,i] is palindrome
                //if the lenght of (j,i) is larger than 3, and s[i] == s[j], we need to check whether [j+1, i-1] is palindrome as well
                if (s.charAt(j) == s.charAt(i) && (i-j+1<3 || isPalindrome[j+1][i-1])) {
                    isPalindrome[j][i] = true;
                    //cut[j-1]+1 will be the min cut for [0,i];
                    min = j == 0 ? 0 : Math.min(min, cut[j-1] + 1);
                }
            }
            cut[i] = min;
        }
        return cut[n-1];
    }
}