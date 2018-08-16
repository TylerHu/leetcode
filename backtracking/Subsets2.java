package backtracking;

/**
 * LeetCode90. Subsets II(https://leetcode.com/problems/subsets-ii/description/)
 *
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 *
 * Solution: Similar to leetcode78, except thate there might be duplicates, so we have to skip duplicate numbers when doing the
 * backtracking.
 */
public class Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        //sort the array first
        Arrays.sort(nums);
        backtrack(result, new ArrayList<Integer>(), nums, 0);
        return result;
    }

    public void backtrack(List<List<Integer>> list, List<Integer> temp, int[] nums, int index) {
        list.add(new ArrayList(temp));
        for (int i = index; i < nums.length; ++i) {
            //avoid duplicate subsets
            if (i > index && nums[i] == nums[i-1]) {
                continue;
            }
            temp.add(nums[i]);
            backtrack(list, temp, nums, i+1);
            temp.remove(temp.size() - 1);
        }
    }
}