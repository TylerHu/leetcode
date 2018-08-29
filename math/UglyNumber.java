package math;

/**
 * LeetCode263. Ugly Number(https://leetcode.com/problems/ugly-number/description/)
 *
 * Write a program to check whether a given number is an ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 *
 * Solution: Just divided by 2, 3, 5 as many times as possible and check whether the last number is 1. And for special case 0
 * just return false
 */
public class UglyNumber {
    public boolean isUgly(int num) {
        if (num == 0) {
            return false;
        }
        //divided by 2, 3, 5 as many times as possible
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }
}