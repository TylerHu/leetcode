package string;

/**
 * LeetCode345. Reverse Vowels of a String(https://leetcode.com/problems/reverse-vowels-of-a-string/description/)
 *
 *  Write a function that takes a string as input and reverse only the vowels of a string.
 *
 *  Solution: Define two pointers left and right, when the character at left and right pointer are vowels, swap them, if not
 *  move the left and right pointer towards each other until they meet.
 */
public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int n = s.length();
        //define vowels, don't miss the capital AEIOU
        String vowels = "aeiouAEIOU";
        char[] chars = s.toCharArray();
        int left = 0, right = n - 1;
        while (left < right) {
            //if character at left and right pointer are vowels, swap them
            if (vowels.indexOf(chars[left]) != -1 && vowels.indexOf(chars[right]) != -1) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            } else if (vowels.indexOf(chars[left]) != -1) {
                //if character at left pointer is vowel, but character at right pointer is not, move right pointer towards left
                right--;
            } else if (vowels.indexOf(chars[right]) != -1) {
                //if character at right pointer is vowel, but character at left pointer is not, move left pointer towards right
                left++;
            } else {
                //if neither of left nor right character is vowel, move them towards each other
                left++;
                right--;
            }
        }
        return new String(chars);
    }
}