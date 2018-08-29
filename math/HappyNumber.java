package math;

/**
 * LeetCode202. Happy Number(https://leetcode.com/problems/happy-number/description/)
 *
 * Write an algorithm to determine if a number is "happy".
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by
 * the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops
 * endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 *
 * Solution: The idea is using a hash set to store the sum of squares of every occured number's digits. If can not add to the
 * set, return false, if the sum is 1, return true;
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(set.add(n)) {
            int sum = 0;
            //calculate the sum of squares of it's every digits
            while (n > 0) {
                int remain = n % 10;
                sum += remain * remain;
                n = n / 10;
            }
            //ends in 1 are happy numbers
            if (sum == 1) {
                return true;
            } else {
                //for next loop
                n = sum;
            }
        }
        //if can not add to the set, return false
        return false;
    }
}