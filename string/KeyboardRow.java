package string;

/**
 * LeetCode500. Keyboard Row(https://leetcode.com/problems/keyboard-row/description/)
 *
 * Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American
 * keyboard like the image below.
 *
 * Solution: Use java8 streamming and regex to match the pattern
 */
public class KeyboardRow {
    public String[] findWords(String[] words) {
        //1. transform to stream
        //2. lowercase the input
        //3. regex pattern, no spaces between each pattern
        //4. return new String[]
        return Stream.of(words).filter(s -> s.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")).toArray(String[]::new);
    }
}