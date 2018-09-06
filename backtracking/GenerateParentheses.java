package backtracking;

/**
 * LeetCode22. Generate Parentheses(https://leetcode.com/problems/generate-parentheses/description/)
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * Solution: Use backtracking,  every time check the length of the current string, if it's length equals to 2*n, add it to
 * the result list and return. If the number of open parenthese "(" is less than n, add it the current str, and increase
 * the open parenthese number, if the number of close parenthese ")" is less than the number of open parenthese "(", add
 * ")" to the str, and increase the close parenthese number.
 *
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    public void backtrack(List<String> res, String str, int open, int close, int max) {
        if (str.length() == 2 * max) {
            //reach the expected length, add to the result list
            res.add(str);
            return;
        }
        if (open < max) {
            //the number of open parenthese "(" is less than n, add "(" to the str
            backtrack(res, str+"(", open+1, close, max);
        }
        if (close < open) {
            //the number of close parenthese ")" is less than the number of open parenthese "(",
            //add ")" to the str
            backtrack(res, str+")", open, close+1, max);
        }
    }
}