package bitmanipulation;

/**
 * LeetCode137. Single Number II(https://leetcode.com/problems/single-number-ii/description/)
 *
 * Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
 *
 * Solution: The idea is to count how many "1" bits in each slot of 32bit intergers. If all the element appear three times,
 * sum % 3 will be 0, if sum % 3 not equal to 0, means that "1" bit belongs to the number that appeared only once, and we
 * could move it back to it's spot by sum << i, and then all all the "1" bits back to get the number
 */
public class SingleNumber2 {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; ++i) {
            int sum = 0;
            for (int j = 0 ; j < nums.length; ++j) {
                //nums[j]>>i to get the ith bit
                sum += nums[j] >> i & 1;
            }
            //get the "1" bit that belongs to the number appeared once
            sum = sum % 3;

            if (sum != 0) {
                //restore the number back by left shifting 
                result |= sum << i;
            }
        }

        return result;
    }
}