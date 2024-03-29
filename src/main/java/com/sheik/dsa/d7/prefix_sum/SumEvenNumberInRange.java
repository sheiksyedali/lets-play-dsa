package com.sheik.dsa.d7.prefix_sum;

/**
 * Author: Sheik Syed Ali
 * Date: 29 Mar 2024
 */

import java.util.ArrayList;

/**
 * Problem Description:
 * You are given an array A of length N and Q queries given by the 2D array B of size Q×2.
 * Each query consists of two integers B[i][0] and B[i][1].
 * For every query, your task is to find the count of even numbers in the range from A[B[i][0]] to A[B[i][1]].
 *
 *
 * Problem Constraints
 * 1 <= N <= 105
 * 1 <= Q <= 105
 * 1 <= A[i] <= 109
 * 0 <= B[i][0] <= B[i][1] < N
 *
 * Input 1:
 * A = [1, 2, 3, 4, 5]
 * B = [   [0, 2]
 *         [2, 4]
 *         [1, 4]   ]
 *
 * Output 1:
 * [1, 1, 2]
 */
public class SumEvenNumberInRange {

    /**
     * Generate the prefix sum array only for even index. For odd index just copy the previous even index value to it
     * TC Big (O) = N; SC Big(O) = N
     */
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer> output = new ArrayList<>();
        ArrayList<Integer> evenIndexPrefixSum = new ArrayList<>();
        int zeroElem = A.get(0);
        evenIndexPrefixSum.add((zeroElem % 2 == 0) ? 1 : 0);
        for (int i = 1; i < A.size(); i++) {
            if (A.get(i) % 2 == 0) { // For even index add the ith value with previous prefixsum array value a[i] + pf[i-1]
                evenIndexPrefixSum.add(evenIndexPrefixSum.get(i-1) + 1);
            } else { // For odd index just copy the pf[i-1] value to pf[i]
                evenIndexPrefixSum.add(evenIndexPrefixSum.get(i - 1));
            }
        }

        for (ArrayList<Integer> queries : B) {
            int l = queries.get(0);
            int r = queries.get(1);
            int sum = (l == 0) ? evenIndexPrefixSum.get(r) : evenIndexPrefixSum.get(r) - evenIndexPrefixSum.get(l - 1);
            output.add(sum);
        }

        System.out.println(A);
        System.out.println(evenIndexPrefixSum);
        System.out.println(output);

        return output;
    }

    public static void main(String[] args) {
        SumEvenNumberInRange sumEvenNumberInRange = new SumEvenNumberInRange();


        ArrayList<Integer> input = new ArrayList<>();
        input.add(6);
        input.add(3);
        input.add(3);
        input.add(6);
        input.add(7);
        input.add(8);
        input.add(7);
        input.add(3);
        input.add(7);

        ArrayList<ArrayList<Integer>> queries = new ArrayList<>();
        ArrayList<Integer> q1= new ArrayList<>();
        q1.add(2);
        q1.add(6);
        ArrayList<Integer> q2= new ArrayList<>();
        q2.add(4);
        q2.add(7);
        ArrayList<Integer> q3= new ArrayList<>();
        q3.add(6);
        q3.add(7);

        queries.add(q1);
        queries.add(q2);
        queries.add(q3);

        sumEvenNumberInRange.solve(input, queries);
    }
}
