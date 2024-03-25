package com.sheik.dsa.d6.arrays;

/**
 * Author: Sheik Syed Ali
 * Date: 25 Mar 2024
 */

import java.util.ArrayList;

/**
 * You are given an integer array A of length N.
 *  You are also given a 2D integer array B with dimensions M x 2, where each row denotes a [L, R] query.
 *  For each query, you have to find the sum of all elements from L to R indices in A (0 - indexed).
 *  More formally, find A[L] + A[L + 1] + A[L + 2] +... + A[R - 1] + A[R] for each query.
 */
public class SumBetweenRange {

    /**
     * Iterate it through entire array
     * TC Big (O): N(pow 2)
     */
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer> output = new ArrayList<>();
        for(ArrayList<Integer> matrix: B){
            int sum = 0;
            for(int i=matrix.get(0); i<=matrix.get(1); i++){
                sum = sum + A.get(i);
            }
            output.add(sum);
        }
        return output;
    }
}
