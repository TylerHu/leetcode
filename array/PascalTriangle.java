package array;

/**
 * LeetCode118. Pascal's Triangle(https://leetcode.com/problems/pascals-triangle/description/)
 *
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 *
 * Solution: As in a pascal triangle, the value in cell(i,j) is cell(i-1,j-1) + cell(i-1, j) (i>=1, 1<=j<i)
 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList();
        if (numRows == 0) {
            return result;
        }
        //i start from 0, so i < numRows, not i <= numRows
        for (int i = 0; i < numRows; ++i) {
            List<Integer> list = new ArrayList<>();
            //j start from 0, and j <=i
            for (int j = 0; j <= i; ++j) {
                //j == 0 or j == i, set it to zero
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    list.add(result.get(i-1).get(j-1) + result.get(i-1).get(j));
                }
            }
            result.add(list);
        }
        return result;
    }
}