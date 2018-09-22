package array;

/**
 * LeetCode350. Intersection of Two Arrays II(https://leetcode.com/problems/intersection-of-two-arrays-ii/description/)
 *
 * Given two arrays, write a function to compute their intersection.
 * Each element in the result should appear as many times as it shows in both arrays.
 *
 * Solution: Sort these two arrays first, and use two pointer to keep track of the current element in each array, check
 * whether current element in these two arrays are the same. If yes, add it to the list, if not, increase the smaller number's
 * index. At the end, transform the list to array and return.
 */
public class IntersectionOfTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        int length1 = nums1.length;
        int length2 = nums2.length;
        int i = 0;
        int j = 0;
        //sort two arrays
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while (i < length1 && j < length2) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                //increase both pointers
                ++i;
                ++j;
            }else if (nums1[i] > nums2[j]) {
                //increase smaller number's pointer
                ++j;
            } else {
                //increase smaller number's pointer
                ++i;
            }
        }
        //list to array
        return Arrays.stream(list.toArray(new Integer[list.size()])).mapToInt(Integer::valueOf).toArray();

    }
}