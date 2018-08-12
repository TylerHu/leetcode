package backtracking;

/**
 * LeetCode78. Subsets(https://leetcode.com/problems/subsets/description/)
 *
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 *
 * Solution: There are two kinds of approach to solve this problem. The first one is using backtracking approach, which is:
 * add number to a templist, and then backtrack it's next elements, after that, remove the last element in the templist and
 * keep the looping going.
 * The second approach is when doing the iterating, there are only two choices, add the current element to the subset, or
 * do not add the current element to the subset. No need to do a recursive call.
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    public void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int index) {
        // need to create a new list object, copy from the templist
        // to avoid later iterating operation affects the subset
        // in the list
        list.add(new ArrayList(tempList));
        for (int i = index; i < nums.length; ++i) {
            tempList.add(nums[i]);
            // set the new index as i+1
            backtrack(list, tempList, nums, i+1);
            // remove the last elment from the templist and do it again
            tempList.remove(tempList.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithoutRecursive(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        //add an empty list to the result first
        result.add(new ArrayList<>());
        for (int i = 0; i < nums.length; ++i) {
            int size = result.size();
            for (int j = 0; j < size; ++j) {
                List<Integer> subset = new ArrayList(result.get(j));
                subset.add(nums[i]);
                // add a new subset to the result list
                result.add(subset);
            }
        }
        return result;
    }

}