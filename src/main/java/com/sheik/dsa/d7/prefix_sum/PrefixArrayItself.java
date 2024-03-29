package com.sheik.dsa.d7.prefix_sum;

/**
 * Author: Sheik Syed Ali
 * Date: 28 Mar 2024
 */

import java.util.ArrayList;

/**
 * Given an array A of N integers. Construct prefix sum of the array in the given array itself.
 * 1 <= N <= 105
 * 1 <= A[i] <= 103
 *
 * Input 1:
 * A = [1, 2, 3, 4, 5]
 *
 * Output 1:
 * [1, 3, 6, 10, 15]
 *
 * (Approach 1)TC Big (O) = N; SC Big (0) = 1
 *
 */
public class PrefixArrayItself {

    /**
     * Calculate prefix sum and store it in same array
     * TC Big (O) = N; SC Big (0) = 1
     */
    public ArrayList<Integer> approach1(ArrayList<Integer> A) {
        for(int i=1; i<A.size(); i++){
            A.set(i, (A.get(i)+ A.get(i-1)));
        }
        return A;
    }

    public static void main(String[] args) {

    }
}
