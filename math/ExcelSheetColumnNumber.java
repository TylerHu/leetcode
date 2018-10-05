package math;

/**
 * LeetCode171. Excel Sheet Column Number(https://leetcode.com/problems/excel-sheet-column-number/description/)
 *
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 *
 * Solution: The idea is straight forward, just iterator through the string, and sum up all it's characters' corresponding
 * number.
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int number = 0;
        for (char c : s.toCharArray()) {
            //'Z'-'A'=26
            //'A' = 1, so need to plus 1 here
            number = number * 26 + (c - 'A' + 1);
        }
        return number;
    }
}