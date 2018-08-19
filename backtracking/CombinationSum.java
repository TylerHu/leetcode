package backtracking;

/**
 * LeetCode39. Combination Sum(https://leetcode.com/problems/combination-sum/description/)
 *
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations
 * in candidates where the candidate numbers sums to target.
 * The same repeated number may be chosen from candidates unlimited number of times.
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 *
 * Solution: Use backtracking approach. One thing need to know is that when doing the backtracking, in order to reuse the last elemnet,
 * the start index of next round is still the same with current one. And we have to sort the array first, so when the target becomes negative,
 * we can just skip to next round.
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
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
                temp.add(candidates[i]);
                //here index is still i for next round
                backtrack(list, temp, candidates, target-candidates[i], i);
                temp.remove(temp.size() - 1);
            }
        }
    }
}