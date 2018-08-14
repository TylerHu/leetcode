package dp;

/**
 * LeetCode120. Triangle(https://leetcode.com/problems/triangle/description/)
 *
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * Note: Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 * 
 * Solution: Use bottom-up dp approach. Start from the nodes on the bottom row. The min path of these nodes are the value store in these
 * nodes.From there, the min path at the jth node on the ith row would be the min of it's two children(dp[i], dp[j+1]) plus the value of
 * itself. That is: dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j)
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        if (size == 0) {
            return 0;
        }
        int[] dp = new int[size+1];
        //bottom-up
        for(int i = size - 1; i >= 0; --i) {
             for (int j = 0; j < triangle.get(i).size(); ++j) {
                 // dp[j] and dp[j+1] are the two "children" of current node triangle[i][j]
                 dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}