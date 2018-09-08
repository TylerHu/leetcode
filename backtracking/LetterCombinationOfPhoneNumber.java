package backtracking;

/**
 * LeetCode17. Letter Combinations of a Phone Number(https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/)
 *
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 * Solution: Define a LinkedList, and check whether the length of the top string reaches to the end of the digits. If not
 * get the top string of the list, and add charcters of it's next digit's letters to the string. Or we could do it in a backtracking
 * approach.And it turns out the backtracking solution run faster than the linked list solution
 */
public class LetterCombinationOfPhoneNumber {

    public List<String> letterCombinations1(String digits) {
        if (digits == null || digits.length() == 0) {
            return new LinkedList<>();
        }
        //define a mapping from number to letters
        String[] mapping = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        LinkedList<String> result = new LinkedList<>();
        //init the list
        result.add("");
        //not reach the end of the digits
        while (result.peek().length() < digits.length()) {
            //get the top element
            String current = result.poll();
            //get it's next digit letters
            String chars = mapping[digits.charAt(current.length()) - '0'];
            //add letters to the current string, and also add to the list
            for (int i = 0; i < chars.length(); ++i) {
                result.add(current + chars.charAt(i));
            }
        }
        return result;
    }

    static String[] mapping = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations2(String digits) {
        if (digits == null || digits.length() == 0) {
            return new LinkedList<>();
        }
        List<String> result = new ArrayList<>();
        backtrack(result, digits, "");
        return result;
    }

    public void backtrack(List<String> result, String digits, String current) {
        if (current.length() == digits.length()) {
            result.add(new String(current));
            return;
        } else {
            String chars = mapping[digits.charAt(current.length()) - '0'];
            for (int i = 0; i < chars.length(); ++i) {
                backtrack(result, digits, current+chars.charAt(i));
            }
        }
    }
}