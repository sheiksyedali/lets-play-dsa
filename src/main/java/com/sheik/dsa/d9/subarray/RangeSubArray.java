package com.sheik.dsa.d9.subarray;

/**
 * Author: Sheik Syed Ali
 * Date: 06 Apr 2024
 */

import java.util.ArrayList;

/**
 * Given an array A of length N, return the subarray from B to C.
 *
 *
 * Problem Constraints
 * 1 <= N <= 105
 * 1 <= A[i] <= 109
 * 0 <= B <= C < N
 *
 * Input 1:
 * A = [4, 3, 2, 6]
 * B = 1
 * C = 3
 *
 * Input 2:
 * A = [4, 2, 2]
 * B = 0
 * C = 1
 *
 * Example Output
 * Output 1:
 * [3, 2, 6]
 * Output 2:
 * [4, 2]
 *
 *
 * approach1:
 *      TC = O(N); SC = O(1)
 *
 */
public class RangeSubArray {

    /**
     * TC = O(N); SC = O(1)
     */
    public ArrayList<Integer> approach1(ArrayList<Integer> A, int B, int C) {
        ArrayList<Integer> result = new ArrayList<>();

        for(int i=B; i<=C; i++)
            result.add(A.get(i));

        return result;
    }
}
