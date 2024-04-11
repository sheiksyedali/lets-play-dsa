package com.sheik.dsa.d9_subarray;

/**
 * Author: Sheik Syed Ali
 * Date: 06 Apr 2024
 */

import com.sheik.dsa.util.Utils;

import java.util.ArrayList;

/**
 * You are given an integer array A of length N.
 * You have to find the sum of all subarray sums of A.
 * More formally, a subarray is defined as a contiguous part of an array which we can obtain by deleting zero or more elements from either end of the array.
 * A subarray sum denotes the sum of all the elements of that subarray.
 *
 * Note : Be careful of integer overflow issues while calculations. Use appropriate datatypes.
 *
 * Problem Constraints
 * 1 <= N <= 105
 * 1 <= Ai <= 10 4
 *
 * Example Input
 * Input 1:
 * A = [1, 2, 3]
 * Input 2:
 * A = [2, 1, 3]
 *
 * Example Output
 * Output 1:
 * 20
 * Output 2:
 * 19
 *
 */
public class SumAllSubarray {

    /**
     * Approach:
     *      Prepare prefix sum array
     *      Calculate all subarrays sum
     *
     * TC = O(N pow 2); SC = O(N)
     */
    public Long approach1(ArrayList<Integer> A) {
        Long sum = 0l;
        int[] pf = new int[A.size()];

        //Prepare prefix summ array
        pf[0] =  A.get(0);
        for(int i =1; i<pf.length; i++){
            pf[i] = A.get(i) + pf[i - 1];
        }

        for(int i=0; i<A.size(); i++){
            for(int j=i; j<A.size(); j++){
                if(i == 0){
                    sum += pf[j];
                } else {
                    sum += pf[j] - pf[i-1];
                }
            }
        }

        System.out.println("Sum of all subarray: "+sum);

        return sum;
    }

    public static void main(String[] args) {
        SumAllSubarray sumAllSubarray = new SumAllSubarray();

        int[] input = {1, 2, 3};
        sumAllSubarray.approach1(Utils.toList(input));
    }
}
