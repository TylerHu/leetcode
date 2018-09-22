package hashtable;

/**
 * LeetCode349. Intersection of Two Arrays(https://leetcode.com/problems/intersection-of-two-arrays/description/)
 *
 * Given two arrays, write a function to compute their intersection.
 *
 * Solution: Define two hash set, one of the set is used to store all the element in the first array, and then check
 * whether the elements in the second array is already in the set, if yes, put it into the result set.
 */
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        //result set
        Set<Integer> interset = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int j : nums2) {
            if (set.contains(j)) {
                //intersect
                interset.add(j);
            }
        }
        //set to in[]
        return interset.stream().mapToInt(Integer::valueOf).toArray();
    }
}