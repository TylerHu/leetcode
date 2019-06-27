package math;

/**
 * LeetCode204. Count Primes(https://leetcode.com/problems/count-primes/description/)
 *
 * Count the number of prime numbers less than a non-negative number, n.
 *
 * Solution: The idea is when number i is a prime number, then number i*j which i*j<n is not a prime number, use a array
 * to store the state of all the numbers that less than n, and count how many numbers's state is false.
 */
public class CountPrimes {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n+1];
        int count = 0;
        for (int i = 2; i < n; ++i) {
            if (!notPrime[i]) {
                //number i is a prime number, increase count
                count++;
                for (int j = 2; i*j < n; ++j) {
                    //mark number i*j is not prime
                    notPrime[i*j] = true;
                }
            }
        }
        return count;

    }
}