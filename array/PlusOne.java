package array;

/**
 * LeetCode66. Plus One(https://leetcode.com/problems/plus-one/description/)
 *
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array
 * contain a single digit.You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Solution: At first, I tried to solve this problem by using a "carry" variable, and pass it to all the element from right
 * to left. But it turned out to be very slow.
 * Here the solution is check whether there is an element less than 9, if the digit is less than 9, increase by 1 and return it.
 * otherwise, set it's digit to 0, and continue loop over the array. 
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; --i) {
            //when there is digits less than 9, than we can just increase the digit and return it
            //Since it will not carry a new number to the next digit
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        //if the last digit is 9, create a new array with n+1 length, and set the first element to 1
        int[] sum = new int[n+1];
        sum[0] = 1;
        return sum;
    }
}