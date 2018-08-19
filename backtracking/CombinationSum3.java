package backtracking;

/**
 * LeetCode216. Combination Sum III(https://leetcode.com/problems/combination-sum-iii/description/)
 *
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each
 * combination should be a unique set of numbers.
 * Note:
 * All numbers will be positive integers.
 * The solution set must not contain duplicate combinations.
 *
 * Solution: Define an array contains number from 1 to 9 as candidates. Use backtrack approach, when the target is zero and k is also zero,
 * means we found a match combination. If not, update target, k and index respectively.
 */
public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] candidates = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, n, k, 0);
        return result;
    }

    public void backtrack(List<List<Integer>> result, List<Integer> temp, int[] candidates, int target, int k, int index) {
        if (target < 0 || k < 0) {
            return;
        } else if (target == 0 && k == 0) {
            //found a combination
            result.add(new ArrayList(temp));
        } else {
            for (int i = index; i < candidates.length; ++i) {
                temp.add(candidates[i]);
                //update target, k, and index
                backtrack(result, temp, candidates, target-candidates[i], k-1, i+1);
                temp.remove(temp.size() - 1);
            }
        }
    }
}