/**
 * LeetCode4. Median of Two Sorted Arrays(https://leetcode.com/problems/median-of-two-sorted-arrays/description/)
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Solution: We can consider the median number is the number that split the array into two parts(the left part and the right part).
 * The two parts should match the following two conditions:
 * 1. The numbers in the left part are always smaller than the numbers in the right part
 * 2. The length of left and right part shoule be the same.
 *
 * Let m be the length of the first array, let n be th length of the second array, and m < n, if m > n, swap the two arrays, the reason why doing this will be discussed later.
 * Let i be the cutting point of the first array, and j be the cutting point of the second array.
 * So i + j = (m + n + 1) / 2 => j = (m + n + 1) / 2 - i; since i <= m, m should be less than n to make sure j is non-negative.
 * And nums1[i-1] should less than nums2[j], also nums2[j-1] should less than nums1[i].
 * If the merged array is odd, return the maximum number of the left part array;
 * if the merged array is even, return the mean of the maximum number of the left part and the
 * minimum number of the right part.
 */
public class MedianOfTwoSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int start = 0;
        int end = m;
        while (start <= end) {
            int i = (start + end) / 2;
            int j = (m + n + 1) / 2 - i;
            if (i > 0 && nums1[i-1] > nums2[j]) {
                // means i is too large, decrease it
                end--;
            } else if (i < m && nums2[j-1] > nums1[i]) {
                // means i is too small, increase it
                start++;
            } else {
                // found the cutting point.
                int maxOfLeftPart = Math.max(i == 0 ? Integer.MIN_VALUE : nums1[i-1], j == 0 ? Integer.MIN_VALUE : nums2[j-1]);
                if ((m + n) % 2 == 1) {
                    return maxOfLeftPart;
                }
                int minOfRightPart = Math.min(i == m ? Integer.MAX_VALUE : nums1[i], j == n ? Integer.MAX_VALUE : nums2[j]);
                return (maxOfLeftPart + minOfRightPart) / 2.0;
            }
        }
        return 0;
    }
}