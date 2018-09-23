package hashtable;

/**
 * LeetCode771. Jewels and Stones(https://leetcode.com/problems/jewels-and-stones/description/)
 *
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.
 * Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
 * The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive,
 * so "a" is considered a different type of stone from "A".
 *
 * Solution: Since the ascii code of character 'A' is 065, and the ascii code of character 'z' is 122, the difference
 * between these two characters is 58. We cound define a array of size 58 to store the character appear in string J.
 * And check each character in string S whether in the array.
 */
public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        if (J.length() == 0 || S.length() == 0) {
            return 0;
        }
        //'z'-A' = 58
        int[] counter = new int[58];
        int res = 0;
        for (char c : J.toCharArray()) {
            //use c-'A' as index, 'A' is the smallest character 
            counter[c - 'A']++;
        }
        for (char c : S.toCharArray()) {
            if (counter[c - 'A'] != 0) {
                res++;
            }
        }
        return res;
    }
}