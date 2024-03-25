package com.sheik.dsa.d6.arrays;

/**
 * Author: Sheik Syed Ali
 * Date: 25 Mar 2024
 */

import java.util.ArrayList;

/**
 * Given an integer array A of size N. In one second, you can increase the value of one element by 1.
 * Find the minimum time in seconds to make all elements of the array equal.
 * Input: A = [2, 4, 1, 3, 2]
 * output: 8
 * Explain: We can change the array A = [4, 4, 4, 4, 4]. The time required will be 8 seconds.
 */
public class TimeToEquality {

    /**
     * Find a Max
     * Differentiate the max with element and add it to the sum
     * TC Big (O) = N
     */
    public int solve(ArrayList<Integer> A) {
        int totalSecs = 0;
        int max = A.get(0);
        for(int i=0; i<A.size(); i++){
            if(max < A.get(i)){
                max = A.get(i);
            }
        }

        for(int i=0; i<A.size(); i++){
            totalSecs = totalSecs + max - A.get(i);
        }

        return totalSecs;
    }
}
