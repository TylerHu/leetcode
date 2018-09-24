package greedy;

/**
 * LeetCode860. Lemonade Change(https://leetcode.com/problems/lemonade-change/description/)
 *
 * At a lemonade stand, each lemonade costs $5.
 * Customers are standing in a queue to buy from you, and order one at a time (in the order specified by bills).
 * Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill.  You must provide the correct
 * change to each customer, so that the net transaction is that the customer pays $5.
 * Note that you don't have any change in hand at first.
 * Return true if and only if you can provide every customer with correct change.
 *
 * Solution: If current bill is $5, increase remaining $5 counts;
 * If current bill is $10, check we have any $5 remained, if yes, descrease remaining $5 counts, and increase remaing $10 count, if not, return false;
 * If current bill is $20, check we have any $10 and $5, if yes, descrease remaining $10 and $5 counts, if not, check
 * we have more than three of $5 or not? yes ? descrease $5 by three, if not , return false.
 *
 */
public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int fiveDollars = 0, tenDollars = 0;
        for (int bill : bills) {
            if (bill == 5) {
                fiveDollars++;
            } else if (bill == 10) {
                if (fiveDollars <= 0) {
                    return false;
                }
                fiveDollars--;
                tenDollars++;
            } else {
                if (tenDollars >= 1 && fiveDollars >= 1) {
                    //$10 + $5
                    fiveDollars--;
                    tenDollars--;
                } else if (fiveDollars >= 3) {
                    //$5 * 3
                    fiveDollars -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}