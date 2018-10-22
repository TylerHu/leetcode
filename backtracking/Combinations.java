package backtracking;

/**
 * LeetCode77. Combinations(https://leetcode.com/problems/combinations/description/)
 *
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * Solution: Use backtracking approach, when the templist size is equal to k, add the templist to the result list
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 1, n, k);
        return result;
    }

    public void backtrack(List<List<Integer>> result, List<Integer> tempList, int start, int n, int k) {
        if (tempList.size() == k) {
            //found k numbers
            result.add(new ArrayList(tempList));
        }
        for (int i = start; i <= n; ++i) {
            //if templist size is already greater than or equal to k, skip 
            if (tempList.size() < k) {
                tempList.add(i);
                backtrack(result, tempList, i+1, n, k);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}