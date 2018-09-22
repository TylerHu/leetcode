package hashtable;

/**
 * LeetCode454. 4Sum II(https://leetcode.com/problems/4sum-ii/description/)
 *
 * Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l]
 * is zero.To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the
 * range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.
 *
 * Solution: The idea is simple, split four lists into two groups, for example, A and B in group one, C and D in group two.
 * and store all the possible sum of group one in the map, check whether the sum of gruop two is also in the map.
 */
public class FourSum2 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < A.length; ++i) {
            for (int j = 0; j < B.length; ++j) {
                //store all the possible sum of A[i], B[j]
                map.put(A[i]+B[j], map.getOrDefault(A[i]+B[j], 0) + 1);
            }
        }

        int res = 0;
        for (int i = 0; i < C.length; ++i) {
            for (int j = 0; j < C.length; ++j) {
                //check whether the sum of C[i], D[j] in the map
                res += map.getOrDefault(-1 * (C[i] + D[j]), 0);
            }
        }
        return res;
    }
}