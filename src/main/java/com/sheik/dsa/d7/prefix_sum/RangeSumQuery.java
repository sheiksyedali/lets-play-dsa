package com.sheik.dsa.d7.prefix_sum;

/**
 * Author: Sheik Syed Ali
 * Date: 28 Mar 2024
 */

import java.util.ArrayList;

/**
 * You are given an integer array A of length N.
 * You are also given a 2D integer array B with dimensions M x 2, where each row denotes a [L, R] query.
 * For each query, you have to find the sum of all elements from L to R indices in A (0 - indexed).
 * More formally, find A[L] + A[L + 1] + A[L + 2] +... + A[R - 1] + A[R] for each query.
 *
 * Problem Constraints
 * 1 <= N, M <= 105
 * 1 <= A[i] <= 109
 * 0 <= L <= R < N
 *
 * Eg:
 * Inputs:
 * A = [1, 2, 3, 4, 5]
 * B = [[0, 3], [1, 2]]
 *
 * output: [10, 5]
 *
 * (Approach 1) TC Big (O): N; SC Big (O): 1
 *
 */
public class RangeSumQuery {

    /**
     * 1. Generate the prefix sum array
     * 2. Iterate the range of queries l, r, find the sum for pf[r] - pf[l]
     * Observation:
     *  A + B = C
     *  B = C - A
     *
     *  First find the sum value of r then subtract it from sum value of l
     *
     *  Big (O): N
     */
    public ArrayList<Long> approach1(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        //Generate the prefix sum values of given input A
        ArrayList<Long> output = new ArrayList<>();
        ArrayList<Integer> prefixSum = new ArrayList<>();
        prefixSum.add(A.get(0));
        for(int i=1; i<A.size(); i++){
            prefixSum.add((A.get(i-1) + A.get(i)));
        }

        for(ArrayList<Integer> query : B){
            int l = query.get(0);
            int r = query.get(1);
            if(l == 0){
                output.add(prefixSum.get(r).longValue());
            } else {
                Integer sumValue = prefixSum.get(r) - prefixSum.get(l);
                output.add(sumValue.longValue());
            }
        }

        System.out.println("Output: "+output);

        return output;
    }

    public long[] rangeSum(int[] A, int[][] B) {
        long[] output = new long[B.length];
        int[] prefixSum = new int[A.length];

        //Generate the prefix sum
        prefixSum[0] = A[0];
        for(int i=1; i<A.length; i++){
            prefixSum[i] = A[i]+prefixSum[i-1];
        }
        printArray(A);
        printArray(prefixSum);

        for(int i=0; i<B.length; i++){
            int l = B[i][0];
            int r = B[i][1];
            if(l == 0){
                output[i] = prefixSum[r];
            } else {
                output[i] = prefixSum[r] - prefixSum[l-1];
            }
        }
        return output;
    }

    private void printArray(int[] a){
        for(int i=0; i<a.length; i++){
            System.out.print(a[i]+", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RangeSumQuery rangeSumQuery = new RangeSumQuery();

        int[] input = {7,3,1,5,5,5,1,2,4,5};
        int[][] queries = {{6,9},{2,9},{2,4},{0,9}};

        rangeSumQuery.rangeSum(input, queries);
    }
}
