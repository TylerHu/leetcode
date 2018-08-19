package backtracking;

/**
 * LeetCode40. Combination Sum II(https://leetcode.com/problems/combination-sum-ii/description/)
 *
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 * Each number in candidates may only be used once in the combination.
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 *
 * Solution: Similar to leetcode 39, also use backtracking approach. But we have to sort the array first this time, and since we can't reuse
 * the candidates, the index should be i + 1. One more thing is to avoid duplicate combinations, we have to skip the looping when two neighbors
 * are the same.
 */
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        //sort the array first
        Arrays.sort(candidates);
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    public void backtrack(List<List<Integer>> list, List<Integer> temp, int[] candidates, int target, int index) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            list.add(new ArrayList(temp));
        } else {
            for (int i = index; i < candidates.length; ++i) {
                if (i > index && candidates[i] == candidates[i-1]) {
                    //when two neighbors are the same, skip
                    continue;
                }
                temp.add(candidates[i]);
                //next index is i+1
                backtrack(list, temp, candidates, target-candidates[i], i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
}