package com.sheik.dsa.d7.prefix_sum;

/**
 * Author: Sheik Syed Ali
 * Date: 29 Mar 2024
 */

import java.util.ArrayList;

/**
 * You are given an array A of integers of size N.
 *
 * Your task is to find the equilibrium index of the given array
 *
 * The equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes.
 *
 * If there are no elements that are at lower indexes or at higher indexes, then the corresponding sum of elements is considered as 0.
 *
 * Note:
 *
 * Array indexing starts from 0.
 * If there is no equilibrium index then return -1.
 * If there are more than one equilibrium indexes then return the minimum index.
 *
 * Problem Constraints
 * 1 <= N <= 105
 * -105 <= A[i] <= 105
 *
 * Input:
 * A = [-7, 1, 5, 2, -4, 3, 0]
 *
 * Output 1:
 * 3
 *
 * (Approach 1) TC Big (O) = N; SC Big (O) = 1
 *
 */
public class EquilibriumIndex {

    /**
     * Calculate the prefix sum array
     * for index i, check pf[i-1] = pf[N] - pf[i] if that condition satisfied then i consider as equilibrium index
     *
     * TC Big (O) = N; SC Big (O) = 1
     */
    public int approach1(ArrayList<Integer> A) {
        //Calculate the prefix sum array
        for(int i=1; i<A.size(); i++){
            A.set(i, (A.get(i) + A.get(i-1)));
        }

        //Check equilibrium
        for(int i=0; i<A.size(); i++){
            int lhs;
            int rhs = A.get(A.size() - 1);
            lhs = (i == 0) ? 0 : A.get(i - 1);

            if(lhs == (rhs - A.get(i))){
                return i;
            }
        }
        return -1;
    }


}
