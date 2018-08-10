package twopointers;

/**
 * LeetCode11. Container With Most Water(https://leetcode.com/problems/container-with-most-water/description/)
 *
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * Note: You may not slant the container and n is at least 2.
 *
 * Solution: Define two pointers left and right. At the begining, set left = 0, right = length-1. The area between this two pointers is the minimum height
 * of these two pointers mutiply the x-distance between left and right pointers. That is Math.min(height[left], height[right]) * (right-left).
 * if the left pointer is lower than the right pointer, move left pointer towards the inner array, otherwise move the right pointer towards the inner array,
 * until these two pointers meet each other. The area is depends on the minimum height of these  two pointers, if we move the taller one towards
 * inner array, the minimum height will be equal to or even smaller than the last time, besides, the x-distance is getting small every time when we move the
 * pointer towards the inner array. So we need to move the lower pointer instead of the taller one.
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        int maxArea = 0;
        while (left < right) {
            // calculate the current area
            int area = Math.min(height[left], height[right]) * (right-left);
            // update the max area
            maxArea = Math.max(maxArea, area);
            if (height[left] < height[right]) {
                // if left is lower than right, move left towards inner array
                left++;
            } else {
                // if right is lower than left, move right towards inner array
                right--;
            }
        }
        return maxArea;
    }
}