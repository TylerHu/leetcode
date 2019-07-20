package array;

/**
 * LeetCode119. Pascal's Triangle II(https://leetcode.com/problems/pascals-triangle-ii/)
 *
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 * Note that the row index starts from 0.
 *
 * Solution: Define an array and initialize it to store 1s. We could start from top to bottom, and right
 * to left to calculate each cell number.
 */
public class PascalTriangle2 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < rowIndex+1; ++i) {
            result.add(1);
        }
        // from top to bottom
        for (int i = 1; i < rowIndex+1; ++i) {
            // from righ to left to avoid overwritting previous result
            for (int j = i-1; j > 0; j--) {
                // use set() mehtod the set the number at index i.
                result.set(j, result.get(j-1) + result.get(j));
            }
        }
        return result;
    }
}