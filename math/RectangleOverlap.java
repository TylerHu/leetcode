package math;

/**
 * LeetCode836. Rectangle Overlap(https://leetcode.com/problems/rectangle-overlap/description/)
 *
 * A rectangle is represented as a list [x1, y1, x2, y2], where (x1, y1) are the coordinates of its bottom-left corner,
 * and (x2, y2) are the coordinates of its top-right corner.
 * Two rectangles overlap if the area of their intersection is positive.  To be clear, two rectangles that only touch at the
 * corner or edges do not overlap.
 * Given two (axis-aligned) rectangles, return whether they overlap.
 *
 * Solution: Condition for two rectangle to overlap: left1 < right2 && left2 < right1, where left1 represents bottom-left of rectangle 1
 * , right1 represnets top-right of rectangle 1, left2 represents bottom-left of rectangle 2 right2 represents top-right of
 * rectangle 2.
 */
public class RectangleOverlap {
    //condition: left1 < right2 && left2 < right1
    return (rec1[0] < rec2[2] && rec1[1] < rec2[3]) && (rec2[0] < rec1[2] && rec2[1] < rec1[3]);
}