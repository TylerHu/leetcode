package bitmanipulation;

/**
 * LeetCode461. Hamming Distance
 *
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Given two integers x and y, calculate the Hamming distance.
 *
 * Solution: First, get the xor between integers x and y, and calculate how many "1" bits in the xor, that is the hamming
 * distance.
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        //first do xor
        int xor = x ^ y;
        int count = 0;
        while (xor != 0) {
            //calculate how many "1" bits
            count += xor & 1;
            xor >>>= 1;
        }
        return count;
    }
}