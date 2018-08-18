package twopointers;

/**
 * LeetCode88. Merge Sorted Array(https://leetcode.com/problems/merge-sorted-array/description/)
 *
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * Note:
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 *
 * Solution: Define two pointers i and j, and compare the last element of these two arrays, and then move backwards.
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1, j = n-1, index = m+n-1;
        while(i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                //if nums1 > nums2, set nums1[index] = nums1[i], and move both pointers index and i backwards
                nums1[index--] = nums1[i--];
            } else {
                //if nums1 <= nums2, set nums1[index] = nums2[j], and move both pointers index and j backwards.
                nums1[index--] = nums2[j--];
            }
        }

        while(j >= 0) {
            //if nums2 still has numbers left, set all left numbers to nums1
            nums1[index--] = nums2[j--];
        }
    }
}